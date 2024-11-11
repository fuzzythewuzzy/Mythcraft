package net.mcreator.mythcraft.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.mythcraft.network.MythCraftModVariables;

public class Slot1OnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(MythCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MythCraftModVariables.PlayerVariables())).slot1).equals("Lighting Cloak") && entity instanceof ServerPlayer _plr0
				&& _plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("myth_craft:lightingcloack_reliazed"))).isDone()) {
			LightingclickkeybindProcedure.execute(entity);
		}
		if (((entity.getCapability(MythCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MythCraftModVariables.PlayerVariables())).slot1).equals("Crimson Claws") && entity instanceof ServerPlayer _plr1
				&& _plr1.level() instanceof ServerLevel && _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("myth_craft:glass_half_full"))).isDone()) {
			CrimsionclawkeybindProcedure.execute(world, x, y, z, entity);
		}
		if (((entity.getCapability(MythCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MythCraftModVariables.PlayerVariables())).slot1).equals("Sanguine Healing") && entity instanceof ServerPlayer _plr2
				&& _plr2.level() instanceof ServerLevel && _plr2.getAdvancements().getOrStartProgress(_plr2.server.getAdvancements().getAdvancement(new ResourceLocation("myth_craft:fullglass"))).isDone()) {
			SaguinehealingkeybindProcedure.execute(world, entity);
		}
		if (((entity.getCapability(MythCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MythCraftModVariables.PlayerVariables())).slot1).equals("")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(""), true);
		}
		if (((entity.getCapability(MythCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MythCraftModVariables.PlayerVariables())).slot1).equals("Eclipse Strike") && entity instanceof ServerPlayer _plr4
				&& _plr4.level() instanceof ServerLevel && _plr4.getAdvancements().getOrStartProgress(_plr4.server.getAdvancements().getAdvancement(new ResourceLocation("myth_craft:shadow_chian"))).isDone()) {
			EclispestrikekeybindProcedure.execute(world, x, y, z, entity);
		}
		if (((entity.getCapability(MythCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MythCraftModVariables.PlayerVariables())).slot1).equals("Umbral Step") && entity instanceof ServerPlayer _plr5
				&& _plr5.level() instanceof ServerLevel && _plr5.getAdvancements().getOrStartProgress(_plr5.server.getAdvancements().getAdvancement(new ResourceLocation("myth_craft:umbralsteppes"))).isDone()) {
			UmbralstepkeybinProcedure.execute(world, x, y, z, entity);
		}
	}
}
