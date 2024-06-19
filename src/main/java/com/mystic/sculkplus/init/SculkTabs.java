package com.mystic.sculkplus.init;

import com.mystic.sculkplus.SculkPlus;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SculkTabs {
    public static final List<Supplier<? extends ItemLike>> MAIN_ITEMS = new ArrayList<>();
    public static final List<Supplier<? extends ItemLike>> MAIN_BLOCKS = new ArrayList<>();

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SculkPlus.MODID);
    public static final RegistryObject<CreativeModeTab> MAIN = CREATIVE_MODE_TABS.register("main", () -> CreativeModeTab.builder()
            .title(Component.literal("Sculk++"))
            .withSearchBar()
            .displayItems((parameters, pOutput) -> {
                MAIN_BLOCKS.forEach(itemLike -> pOutput.accept(itemLike.get()));
                MAIN_ITEMS.forEach(itemLike -> pOutput.accept(itemLike.get()));
            }).build());

    public static <T extends Item> RegistryObject<T> addToMainTab (RegistryObject<T> itemLike) {
        MAIN_BLOCKS.add(itemLike);
        return itemLike;
    }

    public static <T extends Item> RegistryObject<T> addToMainTabItems (RegistryObject<T> itemLike) {
        MAIN_ITEMS.add(itemLike);
        return itemLike;
    }

    public static void init(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }
}
