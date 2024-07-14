package com.crystal.mystia_izakaya.data;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.registry.ItemRegistry;
import com.crystal.mystia_izakaya.utils.FoodTagEnum;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.Arrays;

public class ModLanguageEN extends LanguageProvider {
    public ModLanguageEN(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {
        this.add("itemGroup.mystias_izakaya", "Mystia's Izakaya");
        this.add("gui.mystias_izakaya.level", "Level");
        this.add("gui.mystias_izakaya.cooking_time", "Cooking Time");
        this.add("gui.mystias_izakaya.tags", "Tags");
        this.add("gui.mystias_izakaya.meal.jei", "Mystia's Izakaya");

        this.add(ItemRegistry.MystiaFishingRod.get(), "Mystia's Fishing Rod");
        this.add(ItemRegistry.Grill_Block.get(), "Grill Block");
        this.add(ItemRegistry.Boiling_Pot.get(), "Boiling Pot");
        this.add(ItemRegistry.Frying_Pan.get(), "Frying Pan");
        this.add(ItemRegistry.Steamer.get(), "Steamer");
        this.add(ItemRegistry.Cutting_Board.get(), "Cutting Board");

        this.add(ItemRegistry.Trout.get(), "Trout");
        this.add(ItemRegistry.Lamprey.get(), "Lamprey");
        this.add(ItemRegistry.Salmon.get(), "Salmon");
        this.add(ItemRegistry.Tuna.get(), "Tuna");
        this.add(ItemRegistry.Premium_Tuna.get(), "Premium Tuna");
        this.add(ItemRegistry.Pufferfish.get(), "Pufferfish");
        this.add(ItemRegistry.Shrimp.get(), "Shrimp");
        this.add(ItemRegistry.Octopus.get(), "Octopus");
        this.add(ItemRegistry.Sea_Urchin.get(), "Sea Urchin");
        this.add(ItemRegistry.Crab.get(), "Crab");

        this.add(ItemRegistry.Pork.get(),"Pork");
        this.add(ItemRegistry.Beef.get(),"Beef");
        this.add(ItemRegistry.Venison.get(),"Venison");
        this.add(ItemRegistry.Boar_Meat.get(),"Boar Meat");
        this.add(ItemRegistry.Iberico_Pork.get(),"Iberico Pork");
        this.add(ItemRegistry.Wagyo_Beef.get(),"Wagyo Beef");

        this.add(ItemRegistry.Tofu.get(), "Tofu");
        this.add(ItemRegistry.Potato.get(), "Potato");
        this.add(ItemRegistry.Onion.get(), "Onion");
        this.add(ItemRegistry.Pumpkin.get(), "Pumpkin");
        this.add(ItemRegistry.Radish.get(), "Radish");
        this.add(ItemRegistry.Seaweed.get(), "Seaweed");
        this.add(ItemRegistry.Mushroom.get(), "Mushroom");
        this.add(ItemRegistry.Truffle.get(), "Truffle");
        this.add(ItemRegistry.Bamboo_Shoot.get(),"Bamboo Shoot");
        this.add(ItemRegistry.Cucumber.get(), "Cucumber");
        this.add(ItemRegistry.Chestnut.get(), "Chestnut");
        this.add(ItemRegistry.Red_Toom.get(), "Red Toom");
        this.add(ItemRegistry.Tomato.get(), "Tomato");
        this.add(ItemRegistry.Broceoli.get(), "Broceoli");

        this.add(ItemRegistry.Grilled_Lamprey.get(),"Grilled Lamprey");

        Arrays.stream(FoodTagEnum.values()).toList()
                .forEach(foodTagEnum -> this.add(MystiaIzakaya.MODID + "." + foodTagEnum.name(), foodTagEnum.name()));
    }
}
