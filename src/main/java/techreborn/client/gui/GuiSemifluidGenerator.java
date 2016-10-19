package techreborn.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;
import techreborn.client.container.energy.generator.ContainerSemifluidGenerator;
import techreborn.tiles.energy.generator.TileSemifluidGenerator;

public class GuiSemifluidGenerator extends GuiContainer {

    // TODO: use semifluid generator texture
    private static final ResourceLocation texture = new ResourceLocation("techreborn",
            "textures/gui/semifluid_generator.png");

    TileSemifluidGenerator tile;

    public GuiSemifluidGenerator(EntityPlayer player, TileSemifluidGenerator tile) {
        super(new ContainerSemifluidGenerator(tile, player));
        this.xSize = 176;
        this.ySize = 167;
        this.tile = tile;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }

    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
        String name = "Semifluid generator";
        this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6,
                4210752);
        this.fontRendererObj.drawString(I18n.translateToLocalFormatted("container.inventory", new Object[0]), 8,
                this.ySize - 96 + 2, 4210752);
        this.fontRendererObj.drawString("Liquid Amount", 10, 20, 16448255);
        this.fontRendererObj.drawString(tile.tank.getFluidAmount() + "", 10, 30, 16448255);
    }
}