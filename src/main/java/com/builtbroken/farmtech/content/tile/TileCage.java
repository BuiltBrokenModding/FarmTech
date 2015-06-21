package com.builtbroken.farmtech.content.tile;

/** Small box that holds a chicken
 * Created by robert on 3/5/2015.
 */
public class TileCage
{

    public enum Tier
    {
        /* Simple cage that can hold a chicken */
        BASIC,
        /* Has feed and water container */
        IMPROVED,
        /** Can support basic water, feed, and collection automation */
        ADVANCED,
        /** Connects to other cages providing food, water, and collecting eggs */
        INDUSTRIAL
    }

    public enum CageMat
    {
        WOODEN,
        REED,
        IRON,
        STEEL
    }
}
