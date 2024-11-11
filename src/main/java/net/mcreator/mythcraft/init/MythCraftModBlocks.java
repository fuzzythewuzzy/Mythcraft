
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mythcraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.mythcraft.block.EngineeringTableBlock;
import net.mcreator.mythcraft.MythCraftMod;

public class MythCraftModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MythCraftMod.MODID);
	public static final RegistryObject<Block> ENGINEERING_TABLE = REGISTRY.register("engineering_table", () -> new EngineeringTableBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
