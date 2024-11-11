
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mythcraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.mythcraft.world.inventory.MovekeybindsMenu;
import net.mcreator.mythcraft.world.inventory.EngerineringtableguiMenu;
import net.mcreator.mythcraft.MythCraftMod;

public class MythCraftModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MythCraftMod.MODID);
	public static final RegistryObject<MenuType<EngerineringtableguiMenu>> ENGERINERINGTABLEGUI = REGISTRY.register("engerineringtablegui", () -> IForgeMenuType.create(EngerineringtableguiMenu::new));
	public static final RegistryObject<MenuType<MovekeybindsMenu>> MOVEKEYBINDS = REGISTRY.register("movekeybinds", () -> IForgeMenuType.create(MovekeybindsMenu::new));
}
