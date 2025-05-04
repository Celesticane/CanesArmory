package com.celesticane.thecanesarmory.item.custom;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShieldItem;

public class DiamondShieldItem extends ShieldItem {
    public DiamondShieldItem(Properties properties) {
        super(properties);
    }

    public static final float MINIMUM_DURABILITY_DAMAGE = 2.0F;
    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 36000;
    }
    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.is(Items.DIAMOND) || super.isValidRepairItem(toRepair, repair);
    }
}
