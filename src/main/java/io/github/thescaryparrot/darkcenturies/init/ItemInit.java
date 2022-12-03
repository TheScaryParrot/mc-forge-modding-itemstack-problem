package io.github.thescaryparrot.darkcenturies.init;

import java.util.function.Supplier;

import io.github.thescaryparrot.darkcenturies.DarkCenturies;
import io.github.thescaryparrot.darkcenturies.newstuff.items.DarkCenturiesTiers;
import io.github.thescaryparrot.darkcenturies.newstuff.items.KeepInventoryTotem;
import io.github.thescaryparrot.darkcenturies.newstuff.items.RessurectionAmulet;
import io.github.thescaryparrot.darkcenturies.newstuff.items.SoulBag;
import io.github.thescaryparrot.darkcenturies.newstuff.items.TestItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DarkCenturies.MODID);
	
	public static final RegistryObject<SoulBag> SOUL_BAG = registerItem("soul_bag",
			() -> new SoulBag(100, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> SOUL_STEEL = registerItem("soul_steel", () -> new Item(new Item.Properties()));
	public static final RegistryObject<SwordItem> SOUL_DAGGER = registerItem("soul_dagger",
			() -> new SwordItem(DarkCenturiesTiers.SOUL_STEEL, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<KeepInventoryTotem> KEEP_INVENTORY_TOTEM = registerItem("soul_totem",
			() -> new KeepInventoryTotem(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_COMBAT).rarity(Rarity.EPIC)));
	public static final RegistryObject<RessurectionAmulet> RESSURECTION_AMULET = registerItem("amulet_of_ressurection",
			() -> new RessurectionAmulet(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.RARE).tab(CreativeModeTab.TAB_MISC)));
	
	public static final RegistryObject<TestItem> TEST_ITEM = registerItem("test_item", () -> new TestItem(new Item.Properties()));
	
	private static <T extends Item> RegistryObject<T> registerItem(String name, Supplier<T> supplier)
	{
		RegistryObject<T> item = ITEMS.register(name, supplier);
		return item;
	}
}
