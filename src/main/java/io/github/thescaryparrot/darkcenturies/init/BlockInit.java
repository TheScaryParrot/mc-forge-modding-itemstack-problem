package io.github.thescaryparrot.darkcenturies.init;

import java.util.function.Supplier;

import io.github.thescaryparrot.darkcenturies.DarkCenturies;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DarkCenturies.MODID);
	
	public static final RegistryObject<Block> SOUL_GRASS = registerBlockWithItem("soul_grass",
			() -> new Block(BlockBehaviour.Properties.of(Material.GRASS)), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	
	
	@SuppressWarnings("unused")
	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> supplier)
	{
		RegistryObject<T> block = BLOCKS.register(name, supplier);
		return block;
	}
	
	private static <T extends Block> RegistryObject<T> registerBlockWithItem(String name, Supplier<T> supplier, Properties properties)
	{
		RegistryObject<T> block = BLOCKS.register(name, supplier);
		ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
		return block;
	}
}
