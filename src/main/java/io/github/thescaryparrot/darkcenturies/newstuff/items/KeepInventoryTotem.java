package io.github.thescaryparrot.darkcenturies.newstuff.items;

import io.github.thescaryparrot.darkcenturies.DarkCenturies;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = DarkCenturies.MODID, bus = Bus.FORGE)
public class KeepInventoryTotem extends Item{

	public KeepInventoryTotem(Properties properties) {
		super(properties);
	}
	
	/*When living drops items on death. Doesn't work because items are already dropped and not in inventory anymore
	may help: (https://forums.minecraftforge.net/topic/110641-stuck-on-trying-to-carry-a-capability-after-death/#comment-493763)
	
	@SubscribeEvent
	public static void onLivingDropsItem(LivingDropsEvent event)
	{
		System.out.println("event");
		
		Iterable<ItemEntity> itemEntities = event.getDrops();
		int index = -1;
		
		System.out.println("list");
		
		for (ItemEntity itemEntity : itemEntities) {
			index++;
			
			System.out.println(itemEntity.getItem().getItem());
			
			if (!(itemEntity.getItem().getItem() instanceof KeepInventoryTotem)) continue;
			
			System.out.println("found item");
			
			//player.getInventory().setItem(index, new ItemStack(Items.AIR));
			event.setCanceled(true);
			
			event.getEntity().getCapability(Capabilities.EXTRA_ITEM_HANDLER_CAPABILITY)
			
			System.out.println("done");
		}
	}*/
}
