
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mythcraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.mythcraft.item.UmbralStepItem;
import net.mcreator.mythcraft.item.TurbanicantItem;
import net.mcreator.mythcraft.item.ShadowVialItem;
import net.mcreator.mythcraft.item.SanguineHealingItem;
import net.mcreator.mythcraft.item.LightingCloackItem;
import net.mcreator.mythcraft.item.EclispeStrikeItem;
import net.mcreator.mythcraft.item.CyberneticArmItem;
import net.mcreator.mythcraft.item.CrimsonClawsItem;
import net.mcreator.mythcraft.item.BloodSyctheItem;
import net.mcreator.mythcraft.item.BloodItem;
import net.mcreator.mythcraft.MythCraftMod;

public class MythCraftModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MythCraftMod.MODID);
	public static final RegistryObject<Item> LIGHTING_CLOACK = REGISTRY.register("lighting_cloack", () -> new LightingCloackItem());
	public static final RegistryObject<Item> ECLISPE_STRIKE = REGISTRY.register("eclispe_strike", () -> new EclispeStrikeItem());
	public static final RegistryObject<Item> UMBRAL_STEP = REGISTRY.register("umbral_step", () -> new UmbralStepItem());
	public static final RegistryObject<Item> TURBANICANT = REGISTRY.register("turbanicant", () -> new TurbanicantItem());
	public static final RegistryObject<Item> BLOOD_SYCTHE = REGISTRY.register("blood_sycthe", () -> new BloodSyctheItem());
	public static final RegistryObject<Item> CRIMSON_CLAWS = REGISTRY.register("crimson_claws", () -> new CrimsonClawsItem());
	public static final RegistryObject<Item> SANGUINE_HEALING = REGISTRY.register("sanguine_healing", () -> new SanguineHealingItem());
	public static final RegistryObject<Item> BLOOD = REGISTRY.register("blood", () -> new BloodItem());
	public static final RegistryObject<Item> SHADOW_VIAL = REGISTRY.register("shadow_vial", () -> new ShadowVialItem());
	public static final RegistryObject<Item> ENGINEERING_TABLE = block(MythCraftModBlocks.ENGINEERING_TABLE);
	public static final RegistryObject<Item> CYBERNETIC_ARM = REGISTRY.register("cybernetic_arm", () -> new CyberneticArmItem());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
