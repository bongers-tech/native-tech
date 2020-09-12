/*
 *     Copyright © 2020 bongers-tech
 *     This file is part of NativeTech.
 *
 *     NativeTech is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     NativeTech is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with NativeTech. If not, see <http://www.gnu.org/licenses/>.
 */
package tech.bongers.nativetech.client.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import tech.bongers.nativetech.common.container.CompactorContainer;
import tech.bongers.nativetech.common.util.Reference;

import static tech.bongers.nativetech.common.util.NativeProperties.COMPACTOR;
import static tech.bongers.nativetech.common.util.NativeProperties.PATH_GUI;

public class CompactorScreen extends ContainerScreen<CompactorContainer> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, PATH_GUI + COMPACTOR + ".png");

    public CompactorScreen(final CompactorContainer container, final PlayerInventory inv, final ITextComponent titleIn) {
        super(container, inv, titleIn);
    }

    @Override
    public void render(final MatrixStack stack, final int mouseX, final int mouseY, final float partialTicks) {
        this.renderBackground(stack);
        super.render(stack, mouseX, mouseY, partialTicks);
        this.func_230459_a_(stack, mouseX, mouseY); // @mcp: func_230459_a_ = renderHoveredToolTip
    }

    @Override
    public void drawGuiContainerBackgroundLayer(final MatrixStack stack, final float partialTicks, final int mouseX, final int mouseY) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        getMinecraft().getTextureManager().bindTexture(TEXTURE);
        blit(stack, guiLeft, guiTop, 0, 0, xSize, ySize);

        //Progression arrow
        int progression = container.getProcessScaled();
        blit(stack, guiLeft + 76, guiTop + 37, 176, 0, progression + 1, 16);
    }
}