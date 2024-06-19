package com.mystic.sculkplus.init;

import com.mystic.sculkplus.SculkPlus;
import com.mystic.sculkplus.blocks.ColoredSculk;
import com.mystic.sculkplus.blocks.SculkTorch;
import com.mystic.sculkplus.blocks.SculkWallTorch;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SculkPlus.MODID);

    public static final Map<DyeColor, RegistryObject<Block>> COLORED_SCULK = new HashMap<>();

    public static final RegistryObject<SculkTorch> SCULK_TORCH = registerOnlyBlock("sculk_torch", SculkTorch::new);
    public static final RegistryObject<SculkWallTorch> SCULK_WALL_TORCH = registerOnlyBlock("sculk_wall_torch", SculkWallTorch::new);

    private static <B extends Block, I extends BlockItem> RegistryObject<B> registerMainTabBlock(String name, Supplier<B> block, Function<RegistryObject<B>, Supplier<I>> item) {
        var reg = BLOCKS.register(name, block);
        SculkTabs.addToMainTab(ItemInit.ITEMS.register(name, () -> item.apply(reg).get()));
        return reg;
    }

    private static <B extends Block, C extends Block, I extends BlockItem> RegistryObject<C> registerMainTabBlock(String name, Supplier<B> block, Function<B, C> blockFunction, Function<C, I> item) {
        var reg = BLOCKS.register(name, () -> blockFunction.apply(block.get()));
        SculkTabs.addToMainTab(ItemInit
                .ITEMS.register(name, () ->
                        item.apply(reg.get())));
        return reg;
    }

    public static void init(IEventBus bus) {
        BLOCKS.register(bus);
    }

    private static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<B> block) {
        return registerMainTabBlock(name, block, b -> () -> new BlockItem(b.get(), new Item.Properties()));
    }

    public static <B extends Block> RegistryObject<B> registerOnlyBlock(String name, Supplier<B> block) {
        return BLOCKS.register(name, block);
    }

    static {
        Function<DyeColor, Supplier<Block>> blockSupplier = (dyeColor) -> ColoredSculk::new;
        for (DyeColor color : DyeColor.values()) {
            COLORED_SCULK.put(color, registerBlock(color.getSerializedName() + "_sculk", blockSupplier.apply(color)));
        }
    }
}
