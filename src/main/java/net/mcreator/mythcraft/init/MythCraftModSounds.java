
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mythcraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.mythcraft.MythCraftMod;

public class MythCraftModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MythCraftMod.MODID);
	public static final RegistryObject<SoundEvent> BLOODSPLASH = REGISTRY.register("bloodsplash", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("myth_craft", "bloodsplash")));
}
