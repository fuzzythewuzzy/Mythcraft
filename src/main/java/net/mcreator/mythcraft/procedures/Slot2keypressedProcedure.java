package net.mcreator.mythcraft.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.mythcraft.network.MythCraftModVariables;
import net.mcreator.mythcraft.init.MythCraftModMobEffects;

public class Slot2keypressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(MythCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MythCraftModVariables.PlayerVariables())).slot2).equals("Lighting Cloak") && entity instanceof ServerPlayer _plr0
				&& _plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("myth_craft:lightingcloack_reliazed"))).isDone()) {
			LightingclickkeybindProcedure.execute(entity);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MythCraftModMobEffects.SLOT_2COOLDOWN.get(), 200, 1));
		}
		if (((entity.getCapability(MythCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MythCraftModVariables.PlayerVariables())).slot2).equals("Crimson Claws") && entity instanceof ServerPlayer _plr2
				&& _plr2.level() instanceof ServerLevel && _plr2.getAdvancements().getOrStartProgress(_plr2.server.getAdvancements().getAdvancement(new ResourceLocation("myth_craft:glass_half_full"))).isDone()) {
			CrimsionclawkeybindProcedure.execute(world, x, y, z, entity);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MythCraftModMobEffects.SLOT_2COOLDOWN.get(), 250, 1));
		}
		if (((entity.getCapability(MythCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MythCraftModVariables.PlayerVariables())).slot2).equals("Sanguine Healing") && entity instanceof ServerPlayer _plr4
				&& _plr4.level() instanceof ServerLevel && _plr4.getAdvancements().getOrStartProgress(_plr4.server.getAdvancements().getAdvancement(new ResourceLocation("myth_craft:fullglass"))).isDone()) {
			SaguinehealingkeybindProcedure.execute(world, entity);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MythCraftModMobEffects.SLOT_2COOLDOWN.get(), 350, 1));
		}
		if (((entity.getCapability(MythCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MythCraftModVariables.PlayerVariables())).slot2).equals("")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(""), true);
		}
		if (((entity.getCapability(MythCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MythCraftModVariables.PlayerVariables())).slot2).equals("Eclipse Strike") && entity instanceof ServerPlayer _plr7
				&& _plr7.level() instanceof ServerLevel && _plr7.getAdvancements().getOrStartProgress(_plr7.server.getAdvancements().getAdvancement(new ResourceLocation("myth_craft:shadow_chian"))).isDone()
				&& !(entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(MythCraftModMobEffects.SLOT_2COOLDOWN.get()))) {
			EclispestrikekeybindProcedure.execute(world, x, y, z, entity);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MythCraftModMobEffects.SLOT_2COOLDOWN.get(), 350, 1));
		}
		if (((entity.getCapability(MythCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MythCraftModVariables.PlayerVariables())).slot2).equals("Umbral Step") && entity instanceof ServerPlayer _plr10
				&& _plr10.level() instanceof ServerLevel && _plr10.getAdvancements().getOrStartProgress(_plr10.server.getAdvancements().getAdvancement(new ResourceLocation("myth_craft:umbralsteppes"))).isDone()
				&& !(entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(MythCraftModMobEffects.SLOT_2COOLDOWN.get()))) {
			UmbralstepkeybinProcedure.execute(world, x, y, z, entity);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MythCraftModMobEffects.SLOT_2COOLDOWN.get(), 400, 1));
		}
	}
}
