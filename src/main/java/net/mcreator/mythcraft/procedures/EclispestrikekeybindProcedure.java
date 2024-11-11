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

import java.util.List;
import java.util.Comparator;

public class EclispestrikekeybindProcedure {

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null || !(world instanceof Level level))
            return;

        final Vec3 _center = new Vec3(x, y, z);
        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3), e -> true).stream()
                .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();

        for (Entity entityiterator : _entfound) {
            if (entityiterator != entity && entityiterator instanceof LivingEntity _entity) {
                _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 255, false, false));
            }
        }

        // Create a large flat circle of particles centered on the entity that triggered the ability
        if (world instanceof ServerLevel _level) {
            double radius = 3.0; // Radius of the circle
            int particleCount = 30; // Number of particles in the circle

            for (int i = 0; i < particleCount; i++) {
                double angle = 2 * Math.PI * i / particleCount;
                double offsetX = radius * Math.cos(angle);
                double offsetZ = radius * Math.sin(angle);
                _level.sendParticles(ParticleTypes.LARGE_SMOKE, x + offsetX, y, z + offsetZ, 1, 0, 0, 0, 0.01);
            }

            // Play sound effect at the center
            _level.playSound(null, x, y, z, SoundEvents.ANVIL_LAND, SoundSource.PLAYERS, 1.0F, 1.0F);
        }
    }
}
