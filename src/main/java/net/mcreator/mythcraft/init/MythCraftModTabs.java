
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mythcraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.mythcraft.MythCraftMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MythCraftModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MythCraftMod.MODID);
	public static final RegistryObject<CreativeModeTab> MYTHCRAFTABILITES = REGISTRY.register("mythcraftabilites",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.myth_craft.mythcraftabilites")).icon(() -> new ItemStack(Blocks.AMETHYST_CLUSTER)).displayItems((parameters, tabData) -> {
				tabData.accept(MythCraftModItems.LIGHTING_CLOACK.get());
				tabData.accept(MythCraftModItems.ECLISPE_STRIKE.get());
				tabData.accept(MythCraftModItems.UMBRAL_STEP.get());
				tabData.accept(MythCraftModItems.CRIMSON_CLAWS.get());
				tabData.accept(MythCraftModItems.SANGUINE_HEALING.get());
			}).withSearchBar().build());
	public static final RegistryObject<CreativeModeTab> MYTHCRAFT_ITEMS = REGISTRY.register("mythcraft_items",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.myth_craft.mythcraft_items")).icon(() -> new ItemStack(MythCraftModItems.TURBANICANT.get())).displayItems((parameters, tabData) -> {
				tabData.accept(MythCraftModItems.TURBANICANT.get());
				tabData.accept(MythCraftModItems.BLOOD.get());
				tabData.accept(MythCraftModItems.SHADOW_VIAL.get());
				tabData.accept(MythCraftModBlocks.ENGINEERING_TABLE.get().asItem());
				tabData.accept(MythCraftModItems.CYBERNETIC_ARM.get());
			})

					.build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {

			tabData.accept(MythCraftModItems.BLOOD_SYCTHE.get());

		}
	}
}
