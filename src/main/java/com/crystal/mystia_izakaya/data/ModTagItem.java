package com.crystal.mystia_izakaya.data;

import com.crystal.mystia_izakaya.registry.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static com.crystal.mystia_izakaya.utils.UtilStaticMethod.resourceLocation;

public class ModTagItem extends ItemTagsProvider {
    public static final TagKey<Item> COOKED_MEAL = TagKey.create(Registries.ITEM,resourceLocation("cooked_meal"));
    public static final TagKey<Item> FOOD_INGREDIENTS = TagKey.create(Registries.ITEM,resourceLocation("food_ingredients"));

    public ModTagItem(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        this.tag(ItemTags.FISHING_ENCHANTABLE).add(ItemRegistry.MystiaFishingRod.value());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Crab.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Grill_Block.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Trout.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Lamprey.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Salmon.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Tuna.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Premium_Tuna.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Pufferfish.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Shrimp.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Octopus.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Sea_Urchin.get());

        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Pork.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Beef.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Venison.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Boar_Meat.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Iberico_Pork.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Wagyo_Beef.get());

        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Tofu.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Potato.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Onion.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Pumpkin.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Radish.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Seaweed.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Mushroom.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Truffle.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Bamboo_Shoot.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Cucumber.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Chestnut.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Red_Toon.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Tomato.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Broceoli.get());

        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Egg.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Ginko_Nut.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Cicada_Slough.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Dew.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Flour.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Sticky_Rice.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Ice_Cube.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Grapes.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Cream.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Lemon.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Lotus_Seed.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Pine_Nut.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Red_Bean.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Cocoa_Bean.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Snow_Fungus.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Peach.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Honey.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Udunmbara.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Butter.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Bamboo.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Lunar_Herb.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Chili.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Black_Salt.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Bingdi_Lotus.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Cheese.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Sweet_Potato.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Plum.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Flower.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Creeping_Fig.get());

        //this.tag(COOKED_MEAL).add(ItemRegistry.Grilled_Lamprey.getKey());
    }
}
