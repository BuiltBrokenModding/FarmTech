package com.builtbroken.farmtech.content.tile.machines.incubator;

import com.builtbroken.mc.api.tile.IInventoryProvider;
import com.builtbroken.mc.prefab.tile.module.TileModuleInventory;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by robert on 2/26/2015.
 */
public class InvIncubator extends TileModuleInventory
{
    public static int[] open_slots = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    public InvIncubator(IInventoryProvider inv)
    {
        super(inv, 12);
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack)
    {
        return true;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int var1)
    {
        return open_slots;
    }

    @Override
    public boolean canInsertItem(int i, ItemStack itemstack, int j)
    {
        return itemstack.getItem() == Items.egg;
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemstack, int j)
    {
        return itemstack.getItem() != Items.egg;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 1;
    }
}
