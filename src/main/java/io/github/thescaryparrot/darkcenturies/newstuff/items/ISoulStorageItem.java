package io.github.thescaryparrot.darkcenturies.newstuff.items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public interface ISoulStorageItem{
	
	public int getMaxSoulAmount();
	
	public static boolean HasSoulAmount(ItemStack itemStack, int amount)
	{
		if (!(itemStack.getItem() instanceof ISoulStorageItem soulStorageItem)) return false;
		
		CompoundTag tag = itemStack.getOrCreateTag();
		int containedAmount = tag.contains("stored_souls") ? tag.getInt("stored_souls") : 0;
		
		return containedAmount >= amount;
		
	}
	
	public void appendHoverText(ItemStack itemStack, Level level, List<Component> components, TooltipFlag flag);
	
	public static int getSoulAmount(ItemStack itemStack)
	{
		if (!(itemStack.getItem() instanceof ISoulStorageItem soulStorageItem)) return 0;
		
		CompoundTag tag = itemStack.getOrCreateTag();
		return tag.contains("stored_souls") ? tag.getInt("stored_souls") : 0;
	}
	
	
	
	public static boolean changeSoulAmount(ItemStack itemStack, int amount)
	{
		if (!(itemStack.getItem() instanceof ISoulStorageItem soulStorageItem)) return false;
		if (!HasSoulAmount(itemStack, -amount)) return false;
		
		CompoundTag tag = itemStack.getOrCreateTag();
		int soulAmount = tag.contains("stored_souls") ? soulAmount = tag.getInt("stored_souls") : 0;
		
		if(soulAmount == soulStorageItem.getMaxSoulAmount()) return false; //Storage is already full
		
		soulAmount += amount;
		soulAmount = Math.max(0, Math.min(soulStorageItem.getMaxSoulAmount(), soulAmount)); //clamps soulAmount with 0 & maxSoulAmount
		
		tag.putInt("stored_souls", soulAmount);
		return true;
	}
	
	public static boolean changePlayerSoulAmount(Player player, int amount)
	{
		for (ItemStack itemStack : getPlayerSoulStorageItems(player)) {
			if (ISoulStorageItem.changeSoulAmount(itemStack, amount)) return true;
		}
		
		return false;
	}
	
	public static boolean playerHasSouls(Player player, int amount)
	{
		int currentAmount = 0;
		
		for (ItemStack itemStack : getPlayerSoulStorageItems(player)) {
			currentAmount += getSoulAmount(itemStack);
		}
		
		return currentAmount >= amount;
	}
	
	public static List<ItemStack> getPlayerSoulStorageItems(Player player)
	{
		List<ItemStack> soulStorageItems = new ArrayList<ItemStack>();
		Iterable<ItemStack> playerItemStacks = player.getInventory().items;
		
		for (ItemStack itemStack : playerItemStacks) {
			if (itemStack.getItem() instanceof ISoulStorageItem) soulStorageItems.add(itemStack);
		}
		
		return soulStorageItems;
	}
}
