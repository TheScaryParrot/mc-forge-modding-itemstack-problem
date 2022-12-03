package io.github.thescaryparrot.darkcenturies.newstuff.items;

import java.util.List;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class SoulBag extends Item implements ISoulStorageItem{
	
	private int maxSoulAmount;
	
	public SoulBag(int maxSoulAmount, Properties properties) {
		super(properties);
		this.maxSoulAmount = maxSoulAmount;
	}

	@Override
	public int getMaxSoulAmount() {
		return maxSoulAmount;
	}

	@Override
	public void appendHoverText(ItemStack itemStack, Level level, List<Component> components, TooltipFlag flag) {
		ISoulStorageItem item = (ISoulStorageItem)itemStack.getItem();
		
		components.add(Component.literal("Souls: " + ISoulStorageItem.getSoulAmount(itemStack) + "/" + item.getMaxSoulAmount()));
		super.appendHoverText(itemStack, level, components, flag);
	}

}
