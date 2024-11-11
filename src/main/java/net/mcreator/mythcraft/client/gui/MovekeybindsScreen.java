package net.mcreator.mythcraft.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.mythcraft.world.inventory.MovekeybindsMenu;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MovekeybindsScreen extends AbstractContainerScreen<MovekeybindsMenu> {
	private final static HashMap<String, Object> guistate = MovekeybindsMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox slot1;
	EditBox slot2;

	public MovekeybindsScreen(MovekeybindsMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("myth_craft:textures/screens/movekeybinds.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		slot1.render(guiGraphics, mouseX, mouseY, partialTicks);
		slot2.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (slot1.isFocused())
			return slot1.keyPressed(key, b, c);
		if (slot2.isFocused())
			return slot2.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		slot1.tick();
		slot2.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String slot1Value = slot1.getValue();
		String slot2Value = slot2.getValue();
		super.resize(minecraft, width, height);
		slot1.setValue(slot1Value);
		slot2.setValue(slot2Value);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		slot1 = new EditBox(this.font, this.leftPos + 6, this.topPos + 17, 118, 18, Component.translatable("gui.myth_craft.movekeybinds.slot1")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.myth_craft.movekeybinds.slot1").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.myth_craft.movekeybinds.slot1").getString());
				else
					setSuggestion(null);
			}
		};
		slot1.setSuggestion(Component.translatable("gui.myth_craft.movekeybinds.slot1").getString());
		slot1.setMaxLength(32767);
		guistate.put("text:slot1", slot1);
		this.addWidget(this.slot1);
		slot2 = new EditBox(this.font, this.leftPos + 6, this.topPos + 49, 118, 18, Component.translatable("gui.myth_craft.movekeybinds.slot2")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.myth_craft.movekeybinds.slot2").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.myth_craft.movekeybinds.slot2").getString());
				else
					setSuggestion(null);
			}
		};
		slot2.setSuggestion(Component.translatable("gui.myth_craft.movekeybinds.slot2").getString());
		slot2.setMaxLength(32767);
		guistate.put("text:slot2", slot2);
		this.addWidget(this.slot2);
	}
}
