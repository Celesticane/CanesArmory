package com.celesticane.thecanesarmory.enchantment.custom;


import com.mojang.serialization.MapCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

public record SculkHarvestEnchEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<SculkHarvestEnchEffect> CODEC = MapCodec.unit(SculkHarvestEnchEffect::new);

    @Override
    public void apply(ServerLevel serverLevel, int enchLevel, EnchantedItemInUse inUse, Entity entity, Vec3 vec3) {
        if (enchLevel > 0) {
            for(int i = 0; i < enchLevel; i++) {
                EntityType.EXPERIENCE_ORB.spawn(serverLevel, entity.getOnPos(), MobSpawnType.TRIGGERED);
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
