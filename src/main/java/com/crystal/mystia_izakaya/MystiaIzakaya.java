package com.crystal.mystia_izakaya;

import com.crystal.mystia_izakaya.event.CommonEvent;
import com.crystal.mystia_izakaya.network.MystiaNetwork;
import com.crystal.mystia_izakaya.registry.*;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(MystiaIzakaya.MODID)
public class MystiaIzakaya
{
    public static final String MODID = "mystia_izakaya";
    public static final Logger LOGGER = LogUtils.getLogger();

    public MystiaIzakaya(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(CommonEvent::commonSetup);

        BlockRegistry.BLOCKS.register(modEventBus);
        BlockEntityRegistry.BLOCK_ENTITY_TYPES.register(modEventBus);
        ItemRegistry.ITEMS.register(modEventBus);
        GroupRegistry.CREATIVE_MODE_TABS.register(modEventBus);
        EntityRegistry.ENTITY_TYPES.register(modEventBus);
        MenuRegistry.MENU_TYPE.register(modEventBus);
        RecipeTypeRegistry.RECIPE_TYPES.register(modEventBus);
        RecipeTypeRegistry.RECIPE_SERIALIZERS.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        modEventBus.addListener(MystiaNetwork::registerPacket);
    }
}
