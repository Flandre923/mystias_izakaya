package com.crystal.mystia_izakaya.client.item;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.utils.CookerTypeEnum;
import com.crystal.mystia_izakaya.utils.FoodTagEnum;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CookedMealItem extends Item {
    public final CookerTypeEnum cookerTypeEnum;
    public final float cookingTime;
    public final int level;
    public final Item[] ingredients;
    public final FoodTagEnum[] positiveTag;
    public final FoodTagEnum[] negativeTag;

    public CookedMealItem(CookerTypeEnum cookerTypeEnum, int level, float cookingTime, Item[] items, FoodTagEnum[] foodTagEnums){
        this(cookerTypeEnum,level,cookingTime,items,foodTagEnums,new FoodTagEnum[]{});
    }

    public CookedMealItem(CookerTypeEnum cookerTypeEnum, int level, float cookingTime, Item[] items,FoodTagEnum[] positiveTag, FoodTagEnum[] negativeTag) {
        super(new Properties().food(new FoodProperties.Builder()
                .saturationModifier(0.5F)
                .nutrition(level * 2)
                .alwaysEdible()
                .build()));
        this.cookerTypeEnum = cookerTypeEnum;
        this.cookingTime = cookingTime;
        this.level = level;
        this.ingredients = items;
        this.positiveTag = positiveTag;
        this.negativeTag = negativeTag;
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        Arrays.stream(positiveTag).toList().stream().filter(Objects::nonNull)
                .forEach(foodTagEnum -> pTooltipComponents.add(Component.translatable(MystiaIzakaya.MODID + "." + foodTagEnum.name()).withColor(Color.GREEN.getRGB())));
        Arrays.stream(negativeTag).toList().stream().filter(Objects::nonNull)
                .forEach(foodTagEnum -> pTooltipComponents.add(Component.translatable(MystiaIzakaya.MODID + "." + foodTagEnum.name()).withColor(Color.RED.getRGB())));
    }
}
