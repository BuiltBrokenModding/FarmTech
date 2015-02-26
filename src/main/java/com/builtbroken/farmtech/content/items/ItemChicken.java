package com.builtbroken.farmtech.content.items;

import com.builtbroken.farmtech.FarmTech;
import net.minecraft.item.Item;

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
}
