package io.github.thescaryparrot.darkcenturies.init;

import java.util.function.Supplier;

import io.github.thescaryparrot.darkcenturies.DarkCenturies;
import io.github.thescaryparrot.darkcenturies.newstuff.enchantments.SoulHarvestingEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EnchantmentInit {
	public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, DarkCenturies.MODID);
	
	public static final RegistryObject<SoulHarvestingEnchantment> SOUL_HARVESTING = registerEnchantment("soul_harvesting",
			() -> new SoulHarvestingEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.MAINHAND));
	
	
	private static <T extends Enchantment> RegistryObject<T> registerEnchantment(String name, Supplier<T> supplier)
	{
		RegistryObject<T> enchantment = ENCHANTMENTS.register(name, supplier);
		return enchantment;
	}
}
