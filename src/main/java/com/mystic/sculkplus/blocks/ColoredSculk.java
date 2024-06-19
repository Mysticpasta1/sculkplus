package com.mystic.sculkplus.blocks;

import net.minecraft.world.level.block.SculkBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ColoredSculk extends SculkBlock {
    public ColoredSculk() {
        super(BlockBehaviour.Properties.of().strength(0.2F).sound(SoundType.SCULK));
    }
}
