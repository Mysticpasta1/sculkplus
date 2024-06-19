package com.mystic.sculkplus;

import com.mystic.sculkplus.init.BlockInit;
import com.mystic.sculkplus.init.ItemInit;
import com.mystic.sculkplus.init.SculkTabs;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.stream.Stream;

import static com.mystic.sculkplus.init.BlockInit.COLORED_SCULK;

@Mod(SculkPlus.MODID)
public class SculkPlus {

    public static final String MODID = "sculkplus";

    public SculkPlus() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BlockInit.init(bus);
        ItemInit.init(bus);
        SculkTabs.init(bus);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            registerBlockRenderLayers(RenderType.cutout(),
                    BlockInit.SCULK_TORCH.get(),
                    BlockInit.SCULK_WALL_TORCH.get());
        }

        private static void registerBlockRenderLayers(RenderType layer, Block... blocks) {
            Stream.of(blocks).forEach(block -> ItemBlockRenderTypes.setRenderLayer(block, layer));
        }

        @OnlyIn(Dist.CLIENT)
        @SubscribeEvent
        public static void registerItemColor(RegisterColorHandlersEvent.Item event) {
            ItemColors blockColors = event.getItemColors();

            ItemColor WHITE = (arg, i) -> 0xf9fffe;
            ItemColor ORANGE = (arg, i) -> 0xf9801d;
            ItemColor MAGENTA = (arg, i) -> 0xc74ebd;
            ItemColor LIGHT_BLUE = (arg, i) -> 0x3ab3da;
            ItemColor YELLOW = (arg, i) -> 0xfed83d;
            ItemColor LIME = (arg, i) -> 0x80c71f;
            ItemColor PINK = (arg, i) -> 0xf38baa;
            ItemColor GRAY = (arg, i) -> 0x474f52;
            ItemColor LIGHT_GRAY = (arg, i) -> 0x9d9d97;
            ItemColor CYAN = (arg, i) -> 0x169c9c;
            ItemColor PURPLE = (arg, i) -> 0x8932b8;
            ItemColor BLUE = (arg, i) -> 0x3c44aa;
            ItemColor BROWN = (arg, i) -> 0x835432;
            ItemColor GREEN = (arg, i) -> 0x5e7c16;
            ItemColor RED = (arg, i) -> 0xb02e26;
            ItemColor BLACK = (arg, i) -> 0x1d1d21;
            
            blockColors.register(WHITE, COLORED_SCULK.get(DyeColor.WHITE).get());
            blockColors.register(ORANGE, COLORED_SCULK.get(DyeColor.ORANGE).get());
            blockColors.register(MAGENTA, COLORED_SCULK.get(DyeColor.MAGENTA).get());
            blockColors.register(LIGHT_BLUE, COLORED_SCULK.get(DyeColor.LIGHT_BLUE).get());
            blockColors.register(YELLOW, COLORED_SCULK.get(DyeColor.YELLOW).get());
            blockColors.register(LIME, COLORED_SCULK.get(DyeColor.LIME).get());
            blockColors.register(PINK, COLORED_SCULK.get(DyeColor.PINK).get());
            blockColors.register(GRAY, COLORED_SCULK.get(DyeColor.GRAY).get());
            blockColors.register(LIGHT_GRAY, COLORED_SCULK.get(DyeColor.LIGHT_GRAY).get());
            blockColors.register(CYAN, COLORED_SCULK.get(DyeColor.CYAN).get());
            blockColors.register(PURPLE, COLORED_SCULK.get(DyeColor.PURPLE).get());
            blockColors.register(BLUE, COLORED_SCULK.get(DyeColor.BLUE).get());
            blockColors.register(BROWN, COLORED_SCULK.get(DyeColor.BROWN).get());
            blockColors.register(GREEN, COLORED_SCULK.get(DyeColor.GREEN).get());
            blockColors.register(RED, COLORED_SCULK.get(DyeColor.RED).get());
            blockColors.register(BLACK, COLORED_SCULK.get(DyeColor.BLACK).get());
        }
        
        @OnlyIn(Dist.CLIENT)
        @SubscribeEvent
        public static void registerBlockColor(RegisterColorHandlersEvent.Block event) {
            BlockColors blockColors = event.getBlockColors();

            BlockColor WHITE = (arg, arg2, arg3, i) -> 0xf9fffe;
            BlockColor ORANGE = (arg, arg2, arg3, i) -> 0xf9801d;
            BlockColor MAGENTA = (arg, arg2, arg3, i) -> 0xc74ebd;
            BlockColor LIGHT_BLUE = (arg, arg2, arg3, i) -> 0x3ab3da;
            BlockColor YELLOW = (arg, arg2, arg3, i) -> 0xfed83d;
            BlockColor LIME = (arg, arg2, arg3, i) -> 0x80c71f;
            BlockColor PINK = (arg, arg2, arg3, i) -> 0xf38baa;
            BlockColor GRAY = (arg, arg2, arg3, i) -> 0x474f52;
            BlockColor LIGHT_GRAY = (arg, arg2, arg3, i) -> 0x9d9d97;
            BlockColor CYAN = (arg, arg2, arg3, i) -> 0x169c9c;
            BlockColor PURPLE = (arg, arg2, arg3, i) -> 0x8932b8;
            BlockColor BLUE = (arg, arg2, arg3, i) -> 0x3c44aa;
            BlockColor BROWN = (arg, arg2, arg3, i) -> 0x835432;
            BlockColor GREEN = (arg, arg2, arg3, i) -> 0x5e7c16;
            BlockColor RED = (arg, arg2, arg3, i) -> 0xb02e26;
            BlockColor BLACK = (arg, arg2, arg3, i) -> 0x1d1d21;

            blockColors.register(WHITE, COLORED_SCULK.get(DyeColor.WHITE).get());
            blockColors.register(ORANGE, COLORED_SCULK.get(DyeColor.ORANGE).get());
            blockColors.register(MAGENTA, COLORED_SCULK.get(DyeColor.MAGENTA).get());
            blockColors.register(LIGHT_BLUE, COLORED_SCULK.get(DyeColor.LIGHT_BLUE).get());
            blockColors.register(YELLOW, COLORED_SCULK.get(DyeColor.YELLOW).get());
            blockColors.register(LIME, COLORED_SCULK.get(DyeColor.LIME).get());
            blockColors.register(PINK, COLORED_SCULK.get(DyeColor.PINK).get());
            blockColors.register(GRAY, COLORED_SCULK.get(DyeColor.GRAY).get());
            blockColors.register(LIGHT_GRAY, COLORED_SCULK.get(DyeColor.LIGHT_GRAY).get());
            blockColors.register(CYAN, COLORED_SCULK.get(DyeColor.CYAN).get());
            blockColors.register(PURPLE, COLORED_SCULK.get(DyeColor.PURPLE).get());
            blockColors.register(BLUE, COLORED_SCULK.get(DyeColor.BLUE).get());
            blockColors.register(BROWN, COLORED_SCULK.get(DyeColor.BROWN).get());
            blockColors.register(GREEN, COLORED_SCULK.get(DyeColor.GREEN).get());
            blockColors.register(RED, COLORED_SCULK.get(DyeColor.RED).get());
            blockColors.register(BLACK, COLORED_SCULK.get(DyeColor.BLACK).get());
        }
    }
}
