package com.builtbroken.farmtech;

import com.builtbroken.farmtech.content.items.ItemChicken;
import com.builtbroken.farmtech.content.machines.incubator.TileEggIncubator;
import com.builtbroken.mc.lib.mod.AbstractMod;
import com.builtbroken.mc.lib.mod.ModCreativeTab;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by robert on 11/18/2014.
 */
@Mod(modid = FarmTech.DOMAIN, name = FarmTech.NAME, version = FarmTech.VERSION, dependencies = "required-after:VoltzEngine")
public final class FarmTech extends AbstractMod
{
    /** Name of the channel and mod ID. */
    public static final String NAME = "FarmTech";
    public static final String DOMAIN = "farmtech";
    public static final String PREFIX = DOMAIN + ":";

    /** The version of WatchYourStep. */
    public static final String MAJOR_VERSION = "@MAJOR@";
    public static final String MINOR_VERSION = "@MINOR@";
    public static final String REVISION_VERSION = "@REVIS@";
    public static final String BUILD_VERSION = "@BUILD@";
    public static final String VERSION = MAJOR_VERSION + "." + MINOR_VERSION + "." + REVISION_VERSION + "." + BUILD_VERSION;

    public static final String ASSETS_PATH = "/assets/farmtech/";
    public static final String TEXTURE_PATH = "textures/";
    public static final String GUI_PATH = TEXTURE_PATH + "gui/";
    public static final String MODEL_PREFIX = "models/";
    public static final String MODEL_DIRECTORY = ASSETS_PATH + MODEL_PREFIX;

    public static final String MODEL_TEXTURE_PATH = TEXTURE_PATH + MODEL_PREFIX;
    public static final String BLOCK_PATH = TEXTURE_PATH + "blocks/";
    public static final String ITEM_PATH = TEXTURE_PATH + "items/";

    @Mod.Instance(DOMAIN)
    public static FarmTech INSTANCE;

    @SidedProxy(clientSide = "com.builtbroken.farmtech.ClientProxy", serverSide = "com.builtbroken.farmtech.CommonProxy")
    public static CommonProxy proxy;

    public static ModCreativeTab CREATIVE_TAB;

    public static Item itemChicken;

    public static Block blockEggIncubator;

    public FarmTech()
    {
        super(DOMAIN);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
        CREATIVE_TAB = new ModCreativeTab("farmtech");
        CREATIVE_TAB.itemStack = new ItemStack(Items.feather);
        getManager().setTab(CREATIVE_TAB);

        itemChicken = getManager().newItem(ItemChicken.class);

        blockEggIncubator = getManager().newBlock(TileEggIncubator.class);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        super.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        super.postInit(event);
    }

    @Override
    public CommonProxy getProxy()
    {
        return proxy;
    }
}
