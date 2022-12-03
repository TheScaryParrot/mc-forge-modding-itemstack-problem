package io.github.thescaryparrot.darkcenturies.newstuff.items;

import io.github.thescaryparrot.darkcenturies.DarkCenturies;
import io.github.thescaryparrot.darkcenturies.init.ItemInit;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = DarkCenturies.MODID, bus = Bus.FORGE)
public class RessurectionAmulet extends Item{

	public RessurectionAmulet(Properties p_41383_) {
		super(p_41383_);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public InteractionResult useOn(UseOnContext context) {
		Level level = context.getLevel();
		ItemStack itemStack = context.getItemInHand();
		
		if (!level.isClientSide) {
			System.out.println(itemStack);
			
			itemStack.shrink(1);
			
			System.out.println(itemStack);
			System.out.println(context.getPlayer().getInventory().items);
		}
		
		return InteractionResult.sidedSuccess(level.isClientSide);
		
		/*if (ressurectEntity(level, context.getClickLocation().add(new Vec3(0, 1, 0)), context.getItemInHand()))
		{
			System.out.println("ressurect");
			if (level instanceof ServerLevel) {
				System.out.println(context.getItemInHand());
				context.getItemInHand().shrink(1);
				System.out.println("shrink");
				System.out.println(context.getItemInHand());
				System.out.println(context.getPlayer().getInventory().items);
			}
			
			
			return InteractionResult.sidedSuccess(level.isClientSide);
		}
		else
		{
			return InteractionResult.PASS;
		}*/
	}
	
	@Override
	public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity entity, InteractionHand hand) {
		System.out.println("entity interact");
		
		if (!(entity instanceof TamableAnimal)) return InteractionResult.FAIL; //change
		
		entity.addTag("ressurection_amulet_applied");
		System.out.println(itemStack);
		itemStack.shrink(1);
		System.out.println(itemStack);
		System.out.println(player.getInventory().items);
		
		return InteractionResult.sidedSuccess(player.getLevel().isClientSide());
	}
	
	public static boolean ressurectEntity(Level level, Vec3 pos, ItemStack itemStack)
	{
		if (!(itemStack.getItem() instanceof RessurectionAmulet)) return false;
		
		LivingEntity entity = getContainedEntity(itemStack, level, pos);
		
		if (entity == null) return false;
		
		entity.setHealth(entity.getMaxHealth());
		level.addFreshEntity(entity);
		return true;
	}
	
	public static LivingEntity getContainedEntity(ItemStack itemStack, Level level, Vec3 pos)
	{
		if (!(itemStack.getItem() instanceof RessurectionAmulet)) return null;
		
		CompoundTag tag = itemStack.getTag();
		if (tag == null) return null;
		
		//creates entity out of tag, level & position
		Entity entity = EntityType.loadEntityRecursive(tag, level, (p_138828_) -> {
            p_138828_.moveTo(pos.x, pos.y, pos.z, p_138828_.getYRot(), p_138828_.getXRot());
            return p_138828_;
		});
		
		return entity instanceof LivingEntity livingEntity ? livingEntity : null;
	}
	
	@SubscribeEvent
	public static void onLivingEntityDeath(LivingDeathEvent event)
	{
		LivingEntity entity = event.getEntity();
		
		if (!entity.getTags().contains("ressurection_amulet_applied")) return;
		
		ItemStack ressurectionAmulet = new ItemStack(ItemInit.RESSURECTION_AMULET.get(), 1);
		entity.save(ressurectionAmulet.getOrCreateTag()); //Saves the entity in itemStack CompoundTag
		
		ItemEntity itemEntity = new ItemEntity(entity.level, entity.position().x, entity.position().y, entity.position().z, ressurectionAmulet);
		entity.level.addFreshEntity(itemEntity); //creates the item in the world
	}
}
