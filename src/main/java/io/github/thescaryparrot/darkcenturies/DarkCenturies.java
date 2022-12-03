package io.github.thescaryparrot.darkcenturies;

import io.github.thescaryparrot.darkcenturies.init.BlockInit;
import io.github.thescaryparrot.darkcenturies.init.EnchantmentInit;
import io.github.thescaryparrot.darkcenturies.init.ItemInit;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DarkCenturies.MODID)
public class DarkCenturies {
	
	public static final String MODID = "darkcenturies";
	
	public DarkCenturies()
	{
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		//activates the registries
		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		EnchantmentInit.ENCHANTMENTS.register(bus);
	}
}
