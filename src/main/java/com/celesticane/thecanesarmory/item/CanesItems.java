package com.celesticane.thecanesarmory.item;

import com.celesticane.thecanesarmory.CanesArmory;
import com.celesticane.thecanesarmory.item.custom.CompoundItem;
import com.celesticane.thecanesarmory.item.custom.DiamondShieldItem;
import com.celesticane.thecanesarmory.item.custom.FuelItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CanesItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CanesArmory.MODID);

    public static final DeferredItem<Item> PECULIAR_SHARD = ITEMS.register("peculiar_shard", () -> new FuelItem(new Item.Properties().stacksTo(89), 618));
    public static final DeferredItem<Item> PREPOSTEROUS_COMPOUND = ITEMS.register("preposterous_compound", () -> new CompoundItem(new Item.Properties().stacksTo(89).food(CanesFoodProperties.PREPOSTEROUS_COMPOUND)));

    public static final DeferredItem<Item> TEMPLATE_BLANK = ITEMS.register("smithing_template_blank", () -> new Item(new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> CANES_TEMPLATE_ITEM = ITEMS.register("canes_upgrade_smithing_template", CanesSmithingTemplates::createCanesUpgradeTemplate);
    public static final DeferredItem<Item> ENCORIUM_TEMPLATE_ITEM = ITEMS.register("encorium_upgrade_smithing_template", CanesSmithingTemplates::createEncoriumUpgradeTemplate);
    public static final DeferredItem<Item> CURIOUS_SMITHING_TEMPLATE = ITEMS.register("curious_armor_trim", () -> SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(CanesArmory.MODID, "curious")));

    public static final DeferredItem<SwordItem> OBSIDIAN_SWORD = ITEMS.register("obsidian_sword", () -> new SwordItem(CanesToolTiers.OBSIDIAN, new Item.Properties().attributes(SwordItem.createAttributes(CanesToolTiers.OBSIDIAN, 3, -2.4f))));
    public static final DeferredItem<DiamondShieldItem> DIAMOND_SHIELD = ITEMS.register("diamond_shield", () -> new DiamondShieldItem(new Item.Properties().durability(1208)/*.component(DataComponents.BANNER_PATTERNS, BannerPatternLayers.EMPTY)*/));

    public static final DeferredItem<Item> ENCORIUM_INGOT = ITEMS.register("encorium_ingot", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));
    public static final DeferredItem<SwordItem> ENCORIUM_SWORD = ITEMS.register("encorium_sword", () -> new SwordItem(CanesToolTiers.ENCORIUM, new Item.Properties().attributes(SwordItem.createAttributes(CanesToolTiers.ENCORIUM, 3, -2.4f)).fireResistant().rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<ShovelItem> ENCORIUM_SHOVEL = ITEMS.register("encorium_shovel", () -> new ShovelItem(CanesToolTiers.ENCORIUM, new Item.Properties().attributes(SwordItem.createAttributes(CanesToolTiers.ENCORIUM, 1.5f, -3.0f)).fireResistant().rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<PickaxeItem> ENCORIUM_PICKAXE = ITEMS.register("encorium_pickaxe", () -> new PickaxeItem(CanesToolTiers.ENCORIUM, new Item.Properties().attributes(SwordItem.createAttributes(CanesToolTiers.ENCORIUM, 1, -2.8f)).fireResistant().rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<AxeItem> ENCORIUM_AXE = ITEMS.register("encorium_axe", () -> new AxeItem(CanesToolTiers.ENCORIUM, new Item.Properties().attributes(SwordItem.createAttributes(CanesToolTiers.ENCORIUM, 5, -3.0f)).fireResistant().rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<HoeItem> ENCORIUM_HOE = ITEMS.register("encorium_hoe", () -> new HoeItem(CanesToolTiers.ENCORIUM, new Item.Properties().attributes(SwordItem.createAttributes(CanesToolTiers.ENCORIUM, -4, 0.0f)).fireResistant().rarity(Rarity.UNCOMMON)));

    public static final DeferredItem<ArmorItem> ENCORIUM_HELMET = ITEMS.register("encorium_helmet", () -> new ArmorItem(CanesArmorMaterials.ENCORIUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(45)).fireResistant().rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<ArmorItem> ENCORIUM_CHESTPLATE = ITEMS.register("encorium_chestplate", () -> new ArmorItem(CanesArmorMaterials.ENCORIUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(45)).fireResistant().rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<ArmorItem> ENCORIUM_LEGGINGS = ITEMS.register("encorium_leggings", () -> new ArmorItem(CanesArmorMaterials.ENCORIUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(45)).fireResistant().rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<ArmorItem> ENCORIUM_BOOTS = ITEMS.register("encorium_boots", () -> new ArmorItem(CanesArmorMaterials.ENCORIUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(45)).fireResistant().rarity(Rarity.UNCOMMON)));

    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
