package com.builtbroken.farmtech.content.tile.machines.incubator;

import com.builtbroken.mc.prefab.gui.ContainerBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;

/**
 * Created by robert on 2/27/2015.
 */
public class ContainerIncubator extends ContainerBase
{
    public ContainerIncubator(EntityPlayer player, TileEggIncubator machine)
    {
        super(player, machine);

        int x = 53;
        int y = 17;
        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 4; ++j)
            {
                this.addSlotToContainer(new Slot(machine, j + i * 3, x + j * 18, y + i * 18));
            }
        }
        this.addPlayerInventory(player);
    }
}
