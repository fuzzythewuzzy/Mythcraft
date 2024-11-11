package net.mcreator.mythcraft.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.mythcraft.init.MythCraftModMobEffects;

public class LightingclickkeybindProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		boolean lcactive = false;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MythCraftModMobEffects.LC.get(), 500, 1, false, false));
	}
}
