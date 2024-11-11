
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mythcraft.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.mythcraft.client.gui.MovekeybindsScreen;
import net.mcreator.mythcraft.client.gui.EngerineringtableguiScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MythCraftModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(MythCraftModMenus.ENGERINERINGTABLEGUI.get(), EngerineringtableguiScreen::new);
			MenuScreens.register(MythCraftModMenus.MOVEKEYBINDS.get(), MovekeybindsScreen::new);
		});
	}
}
