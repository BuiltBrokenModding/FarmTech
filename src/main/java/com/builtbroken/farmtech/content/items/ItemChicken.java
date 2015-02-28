package com.builtbroken.farmtech.content.items;

import com.builtbroken.farmtech.FarmTech;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

/** Version of the chicken as an item in the player's inventory.
 * Created by robert on 2/26/2015.
 */
public class ItemChicken extends Item
{
    public ItemChicken()
    {
        this.setMaxStackSize(1);
        this.setUnlocalizedName(FarmTech.PREFIX + "chicken");
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean b)
    {

    }

    @Override @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int d)
    {
        return Items.feather.getIconFromDamage(d);
    }

    @Override @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
    }
}
