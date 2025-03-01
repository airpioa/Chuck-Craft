package net.airpioa.chuckcraft.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.airpioa.chuckcraft.world.inventory.ChuckUIMenu;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ChuckUIScreen extends AbstractContainerScreen<ChuckUIMenu> {
	private final static HashMap<String, Object> guistate = ChuckUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_open_chuck_folder;

	public ChuckUIScreen(ChuckUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 200;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("chuck_craft:textures/screens/chuck_ui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("chuck_craft:textures/screens/chuck-logo2023w_2.png"), this.leftPos + 9, this.topPos + 6, 0, 0, 20, 20, 20, 20);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.chuck_craft.chuck_ui.label_chuck_settings"), 36, 6, -10027213, false);
	}

	@Override
	public void init() {
		super.init();
		button_open_chuck_folder = Button.builder(Component.translatable("gui.chuck_craft.chuck_ui.button_open_chuck_folder"), e -> {
		}).bounds(this.leftPos + 36, this.topPos + 33, 113, 20).build();
		guistate.put("button:button_open_chuck_folder", button_open_chuck_folder);
		this.addRenderableWidget(button_open_chuck_folder);
	}
}
