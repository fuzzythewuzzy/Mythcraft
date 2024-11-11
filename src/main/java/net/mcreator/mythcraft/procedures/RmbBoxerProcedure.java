package net.mcreator.mythcraft.procedures;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.mythcraft.network.MythCraftModVariables;
import net.mcreator.mythcraft.init.MythCraftModMobEffects;
import net.mcreator.mythcraft.MythCraftMod;

import javax.annotation.Nullable;

import java.util.function.Supplier;
import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber(value = {Dist.CLIENT})
public class RmbBoxerProcedure {
	@SubscribeEvent
	public static void onRightClick(PlayerInteractEvent.RightClickEmpty event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		MythCraftMod.PACKET_HANDLER.sendToServer(new RmbBoxerMessage());
		execute(event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RmbBoxerMessage {
		public RmbBoxerMessage() {
		}

		public RmbBoxerMessage(FriendlyByteBuf buffer) {
		}

		public static void buffer(RmbBoxerMessage message, FriendlyByteBuf buffer) {
		}

		public static void handler(RmbBoxerMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getSender().level().hasChunkAt(context.getSender().blockPosition()))
					return;
				execute(context.getSender().level(), context.getSender().getX(), context.getSender().getY(), context.getSender().getZ(), context.getSender());
			});
			context.setPacketHandled(true);
		}

		@SubscribeEvent
		public static void registerMessage(FMLCommonSetupEvent event) {
			MythCraftMod.addNetworkMessage(RmbBoxerMessage.class, RmbBoxerMessage::buffer, RmbBoxerMessage::new, RmbBoxerMessage::handler);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double particleRadius = 0;
		double particleAmount = 0;
		if ((entity.getCapability(MythCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MythCraftModVariables.PlayerVariables())).fightingstyle == 1
				&& !(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MythCraftModMobEffects.RMBBOXERCOOLDOWN.get()))) {
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream()
				.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
				.toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator != entity) {  // Ensure the initiating entity is not affected
					entityiterator.setDeltaMovement(new Vec3(
						entityiterator.getDeltaMovement().x(),
						entityiterator.getDeltaMovement().y() + 0.8,
						entityiterator.getDeltaMovement().z()
					));
				}
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MythCraftModMobEffects.RMBBOXERCOOLDOWN.get(), 60, 1, false, false));
		}
	}
}
