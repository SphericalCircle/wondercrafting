package com.ball.wondercrafting.world.feature;

import com.ball.wondercrafting.core.init.BlockInit;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;

import java.util.Random;

public class NetherCrateFeature extends Feature<ProbabilityConfig> {
    private static final BlockState CRATE = BlockInit.NETHER_CRATE.get().getDefaultState();

    public NetherCrateFeature(Codec<ProbabilityConfig> codec) {
        super(codec);
    }

    public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, ProbabilityConfig config) {
        int i = 0;
        BlockPos.Mutable blockpos$mutable = pos.toMutable();
        BlockPos.Mutable blockpos$mutable1 = pos.toMutable();
        if (reader.isAirBlock(blockpos$mutable)) {
            if (reader.getBlockState(blockpos$mutable.down())==Blocks.GRAVEL.getDefaultState()||reader.getBlockState(blockpos$mutable.down())==Blocks.NETHERRACK.getDefaultState()
                    ||reader.getBlockState(blockpos$mutable.down())==Blocks.SOUL_SOIL.getDefaultState()||reader.getBlockState(blockpos$mutable.down())==Blocks.BLACKSTONE.getDefaultState()
                    ||reader.getBlockState(blockpos$mutable.down())==Blocks.BASALT.getDefaultState()||reader.getBlockState(blockpos$mutable.down())==Blocks.CRIMSON_NYLIUM.getDefaultState()
                    ||reader.getBlockState(blockpos$mutable.down())==Blocks.WARPED_NYLIUM.getDefaultState()) {
                int j = rand.nextInt(12) + 5;
                if (rand.nextFloat() < config.probability) {
                    int k = rand.nextInt(4) + 1;
                }

                for(int l1 = 0; l1 < j && reader.isAirBlock(blockpos$mutable); ++l1) {
                    reader.setBlockState(blockpos$mutable, CRATE, 2);
                }
            }

            ++i;
        }

        return i > 0;
    }
}