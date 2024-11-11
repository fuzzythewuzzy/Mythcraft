package net.mcreator.mythcraft.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.mythcraft.network.MythCraftModVariables;

public class BloodPlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(MythCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MythCraftModVariables.PlayerVariables())).Clan == 2) {
			{
				double _setval = (entity.getCapability(MythCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MythCraftModVariables.PlayerVariables())).Bloodlevel + 2;
				entity.getCapability(MythCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Bloodlevel = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
