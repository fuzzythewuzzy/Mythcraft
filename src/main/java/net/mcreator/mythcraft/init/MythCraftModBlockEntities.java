
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mythcraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.mythcraft.block.entity.EngineeringTableBlockEntity;
import net.mcreator.mythcraft.MythCraftMod;

public class MythCraftModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MythCraftMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> ENGINEERING_TABLE = register("engineering_table", MythCraftModBlocks.ENGINEERING_TABLE, EngineeringTableBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
