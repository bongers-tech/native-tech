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
package tech.bongers.nativetech.common.gui.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.FurnaceFuelSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class RedstoneFuelSlot extends FurnaceFuelSlot {

    public RedstoneFuelSlot(IInventory inventory, int index, int xPosition, int yPosition) {
        super(null, inventory, index, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return stack.getItem() == Items.REDSTONE;
    }
}
