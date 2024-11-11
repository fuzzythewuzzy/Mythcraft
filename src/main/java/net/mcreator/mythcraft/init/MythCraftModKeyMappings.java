
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mythcraft.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.mythcraft.network.Slot2Message;
import net.mcreator.mythcraft.network.Slot1Message;
import net.mcreator.mythcraft.network.OpenguiMessage;
import net.mcreator.mythcraft.network.FightingstanceMessage;
import net.mcreator.mythcraft.MythCraftMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class MythCraftModKeyMappings {
	public static final KeyMapping FIGHTINGSTANCE = new KeyMapping("key.myth_craft.fightingstance", GLFW.GLFW_KEY_C, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				MythCraftMod.PACKET_HANDLER.sendToServer(new FightingstanceMessage(0, 0));
				FightingstanceMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SLOT_1 = new KeyMapping("key.myth_craft.slot_1", GLFW.GLFW_KEY_Z, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				MythCraftMod.PACKET_HANDLER.sendToServer(new Slot1Message(0, 0));
				Slot1Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping OPENGUI = new KeyMapping("key.myth_craft.opengui", GLFW.GLFW_KEY_EQUAL, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				MythCraftMod.PACKET_HANDLER.sendToServer(new OpenguiMessage(0, 0));
				OpenguiMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SLOT_2 = new KeyMapping("key.myth_craft.slot_2", GLFW.GLFW_KEY_X, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				MythCraftMod.PACKET_HANDLER.sendToServer(new Slot2Message(0, 0));
				Slot2Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(FIGHTINGSTANCE);
		event.register(SLOT_1);
		event.register(OPENGUI);
		event.register(SLOT_2);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				FIGHTINGSTANCE.consumeClick();
				SLOT_1.consumeClick();
				OPENGUI.consumeClick();
				SLOT_2.consumeClick();
			}
		}
	}
}
