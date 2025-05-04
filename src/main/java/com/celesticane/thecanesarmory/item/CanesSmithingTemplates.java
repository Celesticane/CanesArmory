package com.celesticane.thecanesarmory.item;

import com.celesticane.thecanesarmory.CanesArmory;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;

import java.awt.*;
import java.util.List;

public class CanesSmithingTemplates extends SmithingTemplateItem {
    private static final ChatFormatting TITLE_FORMAT;
    private static final ChatFormatting DESCRIPTION_FORMAT;
    private static final net.minecraft.network.chat.Component CANES_UPGRADE;
    private static final net.minecraft.network.chat.Component ENCORIUM_UPGRADE;
    private static final net.minecraft.network.chat.Component CANES_UPGRADE_APPLIES_TO;
    private static final net.minecraft.network.chat.Component CANES_UPGRADE_INGREDIENTS;
    private static final net.minecraft.network.chat.Component CANES_UPGRADE_BASE_SLOT_DESCRIPTION;
    private static final net.minecraft.network.chat.Component CANES_UPGRADE_ADDITIONS_SLOT_DESCRIPTION;
    private static final net.minecraft.network.chat.Component ENCORIUM_UPGRADE_APPLIES_TO;
    private static final net.minecraft.network.chat.Component ENCORIUM_UPGRADE_INGREDIENTS;
    private static final net.minecraft.network.chat.Component ENCORIUM_UPGRADE_BASE_SLOT_DESCRIPTION;
    private static final net.minecraft.network.chat.Component ENCORIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION;
    private static final ResourceLocation EMPTY_SLOT_HELMET;
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE;
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS;
    private static final ResourceLocation EMPTY_SLOT_BOOTS;
    private static final ResourceLocation EMPTY_SLOT_HOE;
    private static final ResourceLocation EMPTY_SLOT_AXE;
    private static final ResourceLocation EMPTY_SLOT_SWORD;
    private static final ResourceLocation EMPTY_SLOT_SHOVEL;
    private static final ResourceLocation EMPTY_SLOT_PICKAXE;
    private static final ResourceLocation EMPTY_SLOT_INGOT;

    public CanesSmithingTemplates(net.minecraft.network.chat.Component appliesTo, net.minecraft.network.chat.Component ingredients, net.minecraft.network.chat.Component upgradeDescription, net.minecraft.network.chat.Component baseSlotDescription, net.minecraft.network.chat.Component additionsSlotDescription, List<ResourceLocation> baseSlotEmptyIcons, List<ResourceLocation> additionalSlotEmptyIcons, FeatureFlag... requiredFeatures) {
        super(appliesTo, ingredients, upgradeDescription, baseSlotDescription, additionsSlotDescription, baseSlotEmptyIcons, additionalSlotEmptyIcons, requiredFeatures);
    }

    public static SmithingTemplateItem createEncoriumUpgradeTemplate() {
        return new SmithingTemplateItem(ENCORIUM_UPGRADE_APPLIES_TO, ENCORIUM_UPGRADE_INGREDIENTS, ENCORIUM_UPGRADE, ENCORIUM_UPGRADE_BASE_SLOT_DESCRIPTION, ENCORIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createUpgradeIconList(), createEncoriumUpgradeMaterialList());
    }

    public static SmithingTemplateItem createCanesUpgradeTemplate() {
        return new SmithingTemplateItem(CANES_UPGRADE_APPLIES_TO, CANES_UPGRADE_INGREDIENTS, CANES_UPGRADE, CANES_UPGRADE_BASE_SLOT_DESCRIPTION, CANES_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createUpgradeIconList(), createCanesUpgradeMaterialList());
    }

    private static List<ResourceLocation> createUpgradeIconList() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_SWORD, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_AXE, EMPTY_SLOT_BOOTS, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL);
    }

    private static List<ResourceLocation> createEncoriumUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_INGOT);
    }
    private static List<ResourceLocation> createCanesUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_INGOT);
    }


    static {
        TITLE_FORMAT = ChatFormatting.GRAY;
        DESCRIPTION_FORMAT = ChatFormatting.BLUE;
        //INGREDIENTS_TITLE = net.minecraft.network.chat.Component.translatable(Util.makeDescriptionId("item", ResourceLocation.withDefaultNamespace("smithing_template.ingredients"))).withStyle(TITLE_FORMAT);
        //APPLIES_TO_TITLE = net.minecraft.network.chat.Component.translatable(Util.makeDescriptionId("item", ResourceLocation.withDefaultNamespace("smithing_template.applies_to"))).withStyle(TITLE_FORMAT);
        ENCORIUM_UPGRADE = net.minecraft.network.chat.Component.translatable(Util.makeDescriptionId("upgrade", ResourceLocation.withDefaultNamespace("encorium_upgrade"))).withStyle(TITLE_FORMAT);
        CANES_UPGRADE = net.minecraft.network.chat.Component.translatable(Util.makeDescriptionId("upgrade", ResourceLocation.withDefaultNamespace("canes_upgrade"))).withStyle(TITLE_FORMAT);
        CANES_UPGRADE_APPLIES_TO = net.minecraft.network.chat.Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(CanesArmory.MODID,"smithing_template.canes_upgrade.applies_to"))).withStyle(DESCRIPTION_FORMAT);
        CANES_UPGRADE_INGREDIENTS = net.minecraft.network.chat.Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(CanesArmory.MODID,"smithing_template.canes_upgrade.ingredients"))).withStyle(DESCRIPTION_FORMAT);
        CANES_UPGRADE_BASE_SLOT_DESCRIPTION = net.minecraft.network.chat.Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(CanesArmory.MODID,"smithing_template.canes_upgrade.base_slot_description")));
        CANES_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = net.minecraft.network.chat.Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(CanesArmory.MODID,"smithing_template.canes_upgrade.additions_slot_description")));
        ENCORIUM_UPGRADE_APPLIES_TO = net.minecraft.network.chat.Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(CanesArmory.MODID,"smithing_template.encorium_upgrade.applies_to"))).withStyle(DESCRIPTION_FORMAT);
        ENCORIUM_UPGRADE_INGREDIENTS = net.minecraft.network.chat.Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(CanesArmory.MODID, "smithing_template.encorium_upgrade.ingredients"))).withStyle(DESCRIPTION_FORMAT);
        ENCORIUM_UPGRADE_BASE_SLOT_DESCRIPTION = net.minecraft.network.chat.Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(CanesArmory.MODID,"smithing_template.encorium_upgrade.base_slot_description")));
        ENCORIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = net.minecraft.network.chat.Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(CanesArmory.MODID, "smithing_template.encorium_upgrade.additions_slot_description")));
        EMPTY_SLOT_HELMET = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_helmet");
        EMPTY_SLOT_CHESTPLATE = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_chestplate");
        EMPTY_SLOT_LEGGINGS = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_leggings");
        EMPTY_SLOT_BOOTS = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_boots");
        EMPTY_SLOT_HOE = ResourceLocation.withDefaultNamespace("item/empty_slot_hoe");
        EMPTY_SLOT_AXE = ResourceLocation.withDefaultNamespace("item/empty_slot_axe");
        EMPTY_SLOT_SWORD = ResourceLocation.withDefaultNamespace("item/empty_slot_sword");
        EMPTY_SLOT_SHOVEL = ResourceLocation.withDefaultNamespace("item/empty_slot_shovel");
        EMPTY_SLOT_PICKAXE = ResourceLocation.withDefaultNamespace("item/empty_slot_pickaxe");
        EMPTY_SLOT_INGOT = ResourceLocation.withDefaultNamespace("item/empty_slot_ingot");
    }
}
