package com.builtbroken.farmtech.content.items;

import com.builtbroken.mc.lib.transform.vector.Pos;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Dark on 6/12/2015.
 */
public class ItemWateringCan extends Item
{

    @Override
    public void onUsingTick(ItemStack stack, EntityPlayer player, int count)
    {
        MovingObjectPosition ray_hit = getMovingObjectPositionFromPlayer(player.worldObj, player, true);
        if (ray_hit != null && ray_hit.typeOfHit != MovingObjectPosition.MovingObjectType.MISS) {
            Pos hit = ray_hit.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK ? new Pos(ray_hit) : new Pos(ray_hit.entityHit);
            waterLocation(player.worldObj, hit, 2);
            generateSprinklerEffect(player.worldObj, hit, ray_hit.sideHit, 2);
        }
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int par6, int par7, float par8, float par9, float par10)
    {
        Pos hit = new Pos(x + 0.5D, y + 0.5D, par6 + 0.5D);
        waterLocation(world, hit, 2);
        generateSprinklerEffect(world, hit, par7, 2);
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        player.setItemInUse(stack, getMaxItemUseDuration(stack));
        return stack;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 72000;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.none;
    }

    /**
     * Generates a sprinkler like effect
     * @param worldObj
     * @param hit
     * @param side
     * @param size
     */
    //TODO move to helper to reuse
    public static void generateSprinklerEffect(World worldObj, Pos hit, int side, int size)
    {
        if (worldObj.isRemote)
        {
            //TODO maybe increase random distance based on size
            Pos spawn_pos = new Pos(ForgeDirection.getOrientation(side)).multiply(0.1).add(hit);
            for (int i = 0; i < 20; i++)
            {
                worldObj.spawnParticle("splash", spawn_pos.x() + worldObj.rand.nextGaussian() * 0.6D * size, spawn_pos.y(), spawn_pos.z() + worldObj.rand.nextGaussian() * 0.6D * size, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    /**
     * Updates plant like objects in an area to give the effect of adding water
     * @param worldObj - world
     * @param center - location hit / center of the effect
     * @param size - size of the effect
     */
    //TODO move to helper to reuse
    public static void waterLocation(World worldObj, Pos center, int size)
    {
        //TODO maybe only get blocks in a radius, or can be pathed by the player?
        for (int x = center.xi() - size; x <= center.xi() + size; x++)
        {
            for (int y = center.yi() - size; y <= center.yi() + size; y++)
            {
                for (int z = center.zi() - size; z <= center.zi() + size; z++)
                {
                    Block block = worldObj.getBlock(x, y, z);
                    //TODO turn into an effect map<BlockData, Effect> to save time adding edge cases for blocks
                    if (!worldObj.isAirBlock(x, y, z))
                    {
                        if (block == Blocks.fire)
                        {
                            worldObj.setBlockToAir(x, y, z);
                        } else if ((block == Blocks.farmland) && (worldObj.getBlockMetadata(x, y, z) < 7))
                        {
                            worldObj.setBlockMetadataWithNotify(x, y, z, 7, 2);
                        } else if (block == Blocks.wheat)
                        {
                            worldObj.scheduleBlockUpdate(x, y, z, block, worldObj.rand.nextInt(30));
                        } else if ((block instanceof BlockSapling) && block.getTickRandomly())
                        {
                            worldObj.scheduleBlockUpdate(x, y, z, block, worldObj.rand.nextInt(50));
                        } else if ((block instanceof IPlantable || block instanceof IGrowable) && block.getTickRandomly())
                        {
                            worldObj.scheduleBlockUpdate(x, y, z, block, worldObj.rand.nextInt(30));
                        }
                    }
                }
            }
        }
    }

}
