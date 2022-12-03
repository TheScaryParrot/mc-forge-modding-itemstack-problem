package io.github.thescaryparrot.darkcenturies.newstuff.items;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class TestItem extends Item{

	public TestItem(Properties p_41383_) {
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
	}
}
