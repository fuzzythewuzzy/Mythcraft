package net.mcreator.mythcraft.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;

import java.util.List;
import java.util.Comparator;

public class EclispeStrikeRightclickedProcedure {

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        if (entity == null || !(world instanceof Level level))
            return;

        // Set the cooldown for the item stack
        if (entity instanceof Player player) {
            player.getCooldowns().addCooldown(itemstack.getItem(), 350);
        }

        final Vec3 _center = new Vec3(x, y, z);
        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3), e -> true).stream()
                .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();

        for (Entity entityiterator : _entfound) {
            if (entityiterator != entity && entityiterator instanceof LivingEntity _entity) {
                _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 255, false, false));

                // Spawn smoke particles at the bottom of the affected entity
                if (world instanceof ServerLevel _level) {
                    Vec3 particlePos = entityiterator.position().subtract(0, entityiterator.getBbHeight() / 2, 0);
                    _level.sendParticles(ParticleTypes.LARGE_SMOKE, particlePos.x, particlePos.y, particlePos.z, 5, 0.1, 0.1, 0.1, 0.01);

                    // Play sound effect
                    _level.playSound(null, particlePos.x, particlePos.y, particlePos.z, SoundEvents.ANVIL_LAND, SoundSource.PLAYERS, 1.0F, 1.0F);
                }
            }
        }
    }
}
