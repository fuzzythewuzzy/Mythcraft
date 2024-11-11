package net.mcreator.mythcraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.EditBox;

import net.mcreator.mythcraft.network.MythCraftModVariables;

import java.util.HashMap;

public class MovekeybindsThisGUIIsClosedProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		{
			String _setval = guistate.containsKey("text:slot1") ? ((EditBox) guistate.get("text:slot1")).getValue() : "";
			entity.getCapability(MythCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.slot1 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = guistate.containsKey("text:slot2") ? ((EditBox) guistate.get("text:slot2")).getValue() : "";
			entity.getCapability(MythCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.slot2 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
