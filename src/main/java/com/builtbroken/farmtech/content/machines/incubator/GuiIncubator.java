package com.builtbroken.farmtech.content.machines.incubator;

import com.builtbroken.mc.prefab.gui.GuiContainerBase;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by robert on 2/27/2015.
 */
public class GuiIncubator extends GuiContainerBase
{
    TileEggIncubator machine;

    public GuiIncubator(EntityPlayer player, TileEggIncubator machine)
    {
        super(new ContainerIncubator(player, machine));
        this.machine = machine;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
    {
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {
        super.drawGuiContainerBackgroundLayer(p_146976_1_, p_146976_2_, p_146976_3_);
        for(int i = 0; i < 12; i++)
        {
            drawSlot(inventorySlots.getSlot(i));
        }
    }
}
