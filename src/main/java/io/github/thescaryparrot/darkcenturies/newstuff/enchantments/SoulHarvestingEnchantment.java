package io.github.thescaryparrot.darkcenturies.newstuff.enchantments;

import io.github.thescaryparrot.darkcenturies.DarkCenturies;
import io.github.thescaryparrot.darkcenturies.init.EnchantmentInit;
import io.github.thescaryparrot.darkcenturies.newstuff.items.ISoulStorageItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = DarkCenturies.MODID, bus = Bus.FORGE)
public class SoulHarvestingEnchantment extends Enchantment {

	public SoulHarvestingEnchantment(Rarity p_44676_, EquipmentSlot... p_44678_) {
		super(p_44676_, EnchantmentCategory.WEAPON, p_44678_);
	}
	
	@Override
	public int getMinCost(int p_45102_) {
		return p_45102_ * 25;
	}
	
	@Override
	public int getMaxCost(int p_45105_) {
		return this.getMinCost(p_45105_) + 50;
	}
	
	@Override
	public boolean isTreasureOnly() {
		return true;
	}
	
	@Override
	public int getMaxLevel() {
		return 1;
	}
	
	@SubscribeEvent
	public static void onLivingDeath(final LivingDeathEvent event)
	{		
		if (!(event.getSource().getEntity() instanceof Player player)) return;
		if (player.getMainHandItem().getEnchantmentLevel(EnchantmentInit.SOUL_HARVESTING.get()) == 0) return;
			
		ISoulStorageItem.changePlayerSoulAmount(player, 1);
	}
}
