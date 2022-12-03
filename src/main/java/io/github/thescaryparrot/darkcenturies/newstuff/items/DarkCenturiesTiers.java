package io.github.thescaryparrot.darkcenturies.newstuff.items;

import java.util.function.Supplier;

import io.github.thescaryparrot.darkcenturies.init.ItemInit;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;


public enum DarkCenturiesTiers implements Tier {
	SOUL_STEEL(0, 59, 2.0F, 0.0F, 15, () -> {
		return Ingredient.of(ItemInit.SOUL_STEEL.get());
	});
	
	private final int level;
	private final int uses;
	private final float speed;
	private final float damage;
	private final int enchantmentValue;
	private final Ingredient repairIngredient;

	private DarkCenturiesTiers(int p_43332_, int p_43333_, float p_43334_, float p_43335_, int p_43336_, Supplier<Ingredient> p_43337_) {
	   this.level = p_43332_;
	   this.uses = p_43333_;
	   this.speed = p_43334_;
	   this.damage = p_43335_;
	   this.enchantmentValue = p_43336_;
	   this.repairIngredient = p_43337_.get();
	}

	public int getUses() {
	   return this.uses;
	}

	public float getSpeed() {
	   return this.speed;
	}

	public float getAttackDamageBonus() {
	   return this.damage;
	}

	public int getLevel() {
	   return this.level;
	}

	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	public Ingredient getRepairIngredient() {
	   return this.repairIngredient;
	}
}

