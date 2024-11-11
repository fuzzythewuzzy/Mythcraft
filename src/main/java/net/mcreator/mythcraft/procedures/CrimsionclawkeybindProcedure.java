package net.mcreator.mythcraft.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.mythcraft.network.MythCraftModVariables;
import net.mcreator.mythcraft.init.MythCraftModItems;

public class CrimsionclawkeybindProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 7);
		if (entity instanceof LivingEntity _entity) {
			ItemStack _setstack = new ItemStack(MythCraftModItems.BLOOD_SYCTHE.get()).copy();
			_setstack.setCount(1);
			_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
			if (_entity instanceof Player _player)
				_player.getInventory().setChanged();
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("myth_craft:bloodsplash")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("myth_craft:bloodsplash")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		{
			double _setval = (entity.getCapability(MythCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MythCraftModVariables.PlayerVariables())).Bloodlevel - 15;
			entity.getCapability(MythCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Bloodlevel = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
