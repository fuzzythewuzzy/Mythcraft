
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mythcraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.mythcraft.potion.Slot2cooldownMobEffect;
import net.mcreator.mythcraft.potion.Slot1cooldownMobEffect;
import net.mcreator.mythcraft.potion.RmbboxercooldownMobEffect;
import net.mcreator.mythcraft.potion.LcMobEffect;
import net.mcreator.mythcraft.MythCraftMod;

public class MythCraftModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MythCraftMod.MODID);
	public static final RegistryObject<MobEffect> LC = REGISTRY.register("lc", () -> new LcMobEffect());
	public static final RegistryObject<MobEffect> RMBBOXERCOOLDOWN = REGISTRY.register("rmbboxercooldown", () -> new RmbboxercooldownMobEffect());
	public static final RegistryObject<MobEffect> SLOT_1COOLDOWN = REGISTRY.register("slot_1cooldown", () -> new Slot1cooldownMobEffect());
	public static final RegistryObject<MobEffect> SLOT_2COOLDOWN = REGISTRY.register("slot_2cooldown", () -> new Slot2cooldownMobEffect());
}
