package com.builtbroken.farmtech.content.machines.incubator;

import com.builtbroken.farmtech.FarmTech;
import com.builtbroken.mc.api.tile.IGuiTile;
import com.builtbroken.mc.lib.transform.vector.Pos;
import com.builtbroken.mc.prefab.tile.Tile;
import com.builtbroken.mc.prefab.tile.TileModuleMachine;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by robert on 2/26/2015.
 */
public class TileEggIncubator extends TileModuleMachine implements IGuiTile
{
    protected int[] egg_times;
    protected static int max_cook_time = 6000;

    public TileEggIncubator()
    {
        super("EggIncubator", Material.wood);
        this.inventory_module = new InvIncubator(this);
        modules.add(inventory_module);
        egg_times = new int[this.getSizeInventory()];
    }

    @Override
    public void update()
    {
        super.update();
        if(ticks % 3 == 0)
        {
            for(int i = 0; i < egg_times.length; i++)
            {
                if(getStackInSlot(i) != null && getStackInSlot(i).getItem() == Items.egg)
                {
                    egg_times[i] = egg_times[i] + 3;
                    if(egg_times[i] >= max_cook_time)
                    {
                        setInventorySlotContents(0, new ItemStack(FarmTech.itemChicken));
                    }
                }
                else
                {
                    egg_times[i] = 0;
                }
            }
        }
    }

    @Override
    protected boolean onPlayerRightClick(EntityPlayer player, int side, Pos hit)
    {
        if(isServer())
        {
            openGui(player, FarmTech.INSTANCE);
        }
        return true;
    }

    @Override
    public Tile newTile()
    {
        return new TileEggIncubator();
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player)
    {
        return new ContainerIncubator(player, this);
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player)
    {
        return new GuiIncubator(player, this);
    }
}
