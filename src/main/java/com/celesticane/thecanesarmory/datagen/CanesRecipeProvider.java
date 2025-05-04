package com.celesticane.thecanesarmory.datagen;

import com.celesticane.thecanesarmory.CanesArmory;
import com.celesticane.thecanesarmory.block.CanesBlocks;
import com.celesticane.thecanesarmory.item.CanesItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class CanesRecipeProvider extends RecipeProvider {
    public CanesRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> PREPOSTEROUS_SMELTABLES = List.of(CanesItems.PECULIAR_SHARD, CanesBlocks.PECULIAR_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, CanesBlocks.ENCORIUM_BLOCK.get())
                .pattern("EEE")
                .pattern("EEE")
                .pattern("EEE")
                .define('E', CanesItems.ENCORIUM_INGOT.get())
                .unlockedBy("has_encorium", has(CanesItems.ENCORIUM_INGOT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, CanesBlocks.PREPOSTEROUS_BLOCK.get())
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', CanesItems.PREPOSTEROUS_COMPOUND.get())
                .unlockedBy("has_compound", has(CanesItems.PREPOSTEROUS_COMPOUND)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.ENDER_PEARL, 2)
                .pattern(" C ")
                .pattern("CPC")
                .pattern(" C ")
                .define('C', CanesItems.PREPOSTEROUS_COMPOUND.get())
                .define('P', Items.POPPED_CHORUS_FRUIT)
                .unlockedBy("has_compound", has(CanesItems.PREPOSTEROUS_COMPOUND)).save(recipeOutput, "thecanesarmory:preposterous_pearls");
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CanesBlocks.PECULIAR_SCAFFOLDING.get(), 5)
                .pattern("SSS")
                .pattern("C C")
                .pattern("SOS")
                .define('S', Blocks.SCAFFOLDING)
                .define('C', CanesItems.PREPOSTEROUS_COMPOUND.get())
                .define('O', Blocks.OBSIDIAN)
                .unlockedBy("has_compound", has(CanesItems.PREPOSTEROUS_COMPOUND)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CanesItems.ENCORIUM_TEMPLATE_ITEM.get())
                .pattern("ENE")
                .pattern("EBE")
                .pattern("ENE")
                .define('E', Blocks.END_STONE)
                .define('N', Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                .define('B', CanesItems.TEMPLATE_BLANK)
                .unlockedBy("has_blank", has(CanesItems.TEMPLATE_BLANK)).save(recipeOutput, "thecanesarmory:initial_encorium_upgrade_template");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CanesItems.CURIOUS_SMITHING_TEMPLATE.get())
                .pattern("DBD")
                .pattern("DCD")
                .pattern("DED")
                .define('D', Items.DIAMOND)
                .define('B', CanesItems.TEMPLATE_BLANK)
                .define('C', CanesBlocks.PREPOSTEROUS_BLOCK)
                .define('E', CanesBlocks.ENCORIUM_BLOCK)
                .unlockedBy("has_encorium_block", has(CanesBlocks.ENCORIUM_BLOCK)).save(recipeOutput, "thecanesarmory:initial_curious_armor_trim");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, CanesBlocks.ENDER_GLASS.get(), 8)
                .pattern("GPG")
                .pattern("PEP")
                .pattern("GPG")
                .define('G', Blocks.GLASS)
                .define('P', CanesItems.PREPOSTEROUS_COMPOUND)
                .define('E', Items.ENDER_EYE)
                .unlockedBy("has_compound", has(CanesItems.PREPOSTEROUS_COMPOUND.get())).save(recipeOutput);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CanesItems.ENCORIUM_INGOT.get(), 9)
                .requires(CanesBlocks.ENCORIUM_BLOCK)
                .unlockedBy("has_encorium_block", has(CanesBlocks.ENCORIUM_BLOCK)).save(recipeOutput, "thecanesarmory:encorium_from_block");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CanesItems.PREPOSTEROUS_COMPOUND.get(), 9)
                .requires(CanesBlocks.PREPOSTEROUS_BLOCK)
                .unlockedBy("has_preposterous_block", has(CanesBlocks.ENCORIUM_BLOCK)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CanesItems.ENCORIUM_INGOT.get())
                .requires(CanesItems.PREPOSTEROUS_COMPOUND, 4)
                .requires(Items.NETHERITE_INGOT, 2)
                .requires(Items.AMETHYST_SHARD, 2)
                .unlockedBy("has_compound", has(CanesItems.PREPOSTEROUS_COMPOUND)).save(recipeOutput);

        canesSmithing(recipeOutput, Items.STONE_SWORD, Items.OBSIDIAN, RecipeCategory.COMBAT,CanesItems.OBSIDIAN_SWORD.get());

        encoriumSmithing(recipeOutput, Items.NETHERITE_SWORD, RecipeCategory.COMBAT, CanesItems.ENCORIUM_SWORD.get());
        encoriumSmithing(recipeOutput, Items.NETHERITE_SHOVEL, RecipeCategory.TOOLS, CanesItems.ENCORIUM_SHOVEL.get());
        encoriumSmithing(recipeOutput, Items.NETHERITE_PICKAXE, RecipeCategory.TOOLS, CanesItems.ENCORIUM_PICKAXE.get());
        encoriumSmithing(recipeOutput, Items.NETHERITE_AXE, RecipeCategory.TOOLS, CanesItems.ENCORIUM_AXE.get());
        encoriumSmithing(recipeOutput, Items.NETHERITE_HOE, RecipeCategory.TOOLS, CanesItems.ENCORIUM_HOE.get());
        encoriumSmithing(recipeOutput, Items.NETHERITE_HELMET, RecipeCategory.COMBAT, CanesItems.ENCORIUM_HELMET.get());
        encoriumSmithing(recipeOutput, Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, CanesItems.ENCORIUM_CHESTPLATE.get());
        encoriumSmithing(recipeOutput, Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, CanesItems.ENCORIUM_LEGGINGS.get());
        encoriumSmithing(recipeOutput, Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, CanesItems.ENCORIUM_BOOTS.get());

        trimSmithing(recipeOutput,CanesItems.CURIOUS_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath(CanesArmory.MODID, "curious"));

        copySmithingTemplate(recipeOutput, CanesItems.CANES_TEMPLATE_ITEM.get(), Blocks.GOLD_BLOCK);
        copySmithingTemplate(recipeOutput, CanesItems.ENCORIUM_TEMPLATE_ITEM.get(), Blocks.END_STONE);
        copySmithingTemplate(recipeOutput, CanesItems.CURIOUS_SMITHING_TEMPLATE.get(), CanesBlocks.PREPOSTEROUS_BLOCK.get());


        oreSmelting(recipeOutput, PREPOSTEROUS_SMELTABLES, RecipeCategory.MISC, CanesItems.PREPOSTEROUS_COMPOUND.get(), 0.25f, 206, "compound");
        oreBlasting(recipeOutput, PREPOSTEROUS_SMELTABLES, RecipeCategory.MISC, CanesItems.PREPOSTEROUS_COMPOUND.get(), 0.25f, 103, "compound");

    }

    protected static void encoriumSmithing(RecipeOutput output, Item ingredientItem, RecipeCategory category, Item resultItem) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(CanesItems.ENCORIUM_TEMPLATE_ITEM), Ingredient.of(ingredientItem), Ingredient.of(CanesItems.ENCORIUM_INGOT.get()), category, resultItem)
                .unlocks("has_encorium_ingot", has(CanesItems.ENCORIUM_INGOT.get())).save(output, getItemName(resultItem) + "_smithing");

    }
    protected static void canesSmithing(RecipeOutput output, Item tool, Item ingredientItem, RecipeCategory category, Item resultItem) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(CanesItems.CANES_TEMPLATE_ITEM), Ingredient.of(tool), Ingredient.of(ingredientItem), category, resultItem)
                .unlocks("has_canes_template", has(CanesItems.CANES_TEMPLATE_ITEM.get())).save(output, getItemName(resultItem) + "_smithing");
    }

}
