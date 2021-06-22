package com.masterquentus.mythiccraft.util;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

import java.util.List;
import java.util.stream.Stream;

public class ModVoxelShapes {
    public static VoxelShape getPedistalShape(int tier){
        int index = Math.min(tier, PEDESTAL.size()) - 1;
        return PEDESTAL.get(index);
    }

    // will need for mob masher
    public static VoxelShape rotateShape(Direction from, Direction to, VoxelShape shape) {
        VoxelShape[] temp = new VoxelShape[]{ shape, VoxelShapes.empty() };

        int times = (to.get2DDataValue() - from.get2DDataValue() + 4) % 4;
        for (int i = 0; i < times; i++) {
            temp[0].forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> temp[1] = VoxelShapes.or(temp[1], VoxelShapes.create(new AxisAlignedBB(1-maxZ, minY, minX, 1-minZ, maxY, maxX))));
            temp[0] = temp[1];
            temp[1] = VoxelShapes.empty();
        }

        return temp[0];
    }

    public static final VoxelShape QUARRY = Stream.of(
            Block.box(7, 2.74, 5.31, 9, 8.74, 7.31),
            Block.box(0, 17, 0, 16, 28, 16),
            Block.box(7, 2.45, 7, 9, 15.54, 9),
            Block.box(4.70, 8, 7, 11.29, 10, 9),
            Block.box(7, 8, 4.70, 9, 10, 11.2961),
            Block.box(8.68, 10, 7, 10.68, 16, 9),
            Block.box(7, 10, 8.68, 9, 16, 10.68),
            Block.box(5.31, 10, 7, 7.31, 16, 9),
            Block.box(7, 10, 5.31, 9, 16, 7.33),
            Block.box(8.68, 1.99, 7, 10.68, 8, 9),
            Block.box(7, 2, 8.68, 9, 8, 10.68),
            Block.box(5.31, 2, 7, 7.31, 8, 9)
            // Block.box(0, 0, 0, 16, 29, 16)
    ).reduce(VoxelShapes::or).get();
    
    public static List<VoxelShape> PEDESTAL = ImmutableList.of(
        Stream.of(
                Block.box(11, 0, 0, 16, 1, 16),
                Block.box(1, 1, 1, 5, 15, 15),
                Block.box(0, 15, 0, 5, 16, 16),
                Block.box(0, 0, 0, 5, 1, 16),
                Block.box(5, 1, 1, 11, 15, 5),
                Block.box(5, 15, 0, 11, 16, 5),
                Block.box(5, 0, 0, 11, 1, 5),
                Block.box(5, 1, 11, 11, 15, 15),
                Block.box(5, 15, 11, 11, 16, 16),
                Block.box(5, 0, 11, 11, 1, 16),
                Block.box(11, 1, 1, 15, 15, 15),
                Block.box(11, 15, 0, 16, 16, 16)
                // Block.box(0, 0, 0, 16, 17, 16)
        ).reduce((v1, v2) -> {return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get(),
        Stream.of(
                Block.box(5, 1, 5, 11, 1, 11),
                Block.box(1, 1, 1, 5, 15, 15),
                Block.box(15, 6, 6.5, 16, 10, 10.5),
                Block.box(0, 6, 6.5, 1, 10, 10.5),
                Block.box(6, 6, 0, 10, 10, 1),
                Block.box(6, 6, 15, 10, 10, 16),
                Block.box(0, 15, 0, 5, 16, 16),
                Block.box(0, 0, 0, 5, 1, 16),
                Block.box(5, 1, 1, 11, 15, 5),
                Block.box(5, 15, 0, 11, 16, 5),
                Block.box(5, 0, 0, 11, 1, 5),
                Block.box(5, 1, 11, 11, 15, 15),
                Block.box(5, 15, 11, 11, 16, 16),
                Block.box(5, 0, 11, 11, 1, 16),
                Block.box(11, 1, 1, 15, 15, 15),
                Block.box(11, 15, 0, 16, 16, 16),
                Block.box(11, 0, 0, 16, 1, 16),
                Block.box(5, 15, 5, 11, 15, 11)
                // Block.box(0, 0, 0, 16, 16, 16)
        ).reduce((v1, v2) -> {return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get(),
        Stream.of(
                Block.box(3, 2, 2, 13, 3, 3),
                Block.box(3, 2, 3, 13, 2, 13),
                Block.box(3, 14, 3, 13, 14, 13),
                Block.box(0, 2, 13, 3, 14, 16),
                Block.box(0, 2, 0, 3, 14, 3),
                Block.box(13, 2, 0, 16, 14, 3),
                Block.box(13, 2, 13, 16, 14, 16),
                Block.box(-2, 8, 12, 4, 8, 18),
                Block.box(-2, 8, -2, 4, 8, 4),
                Block.box(12, 8, -2, 18, 8, 4),
                Block.box(12, 8, 12, 18, 8, 18),
                Block.box(-0.5, 0, 12.5, 3.5, 2, 16.5),
                Block.box(-0.5, 0, -0.5, 3.5, 2, 3.5),
                Block.box(12.5, 0, -0.5, 16.5, 2, 3.5),
                Block.box(12.5, 0, 12.5, 16.5, 2, 16.5),
                Block.box(-0.5, 14, 12.5, 3.5, 16, 16.5),
                Block.box(-0.5, 14, -0.5, 3.5, 16, 3.5),
                Block.box(12.5, 14, -0.5, 16.5, 16, 3.5),
                Block.box(12.5, 14, 12.5, 16.5, 16, 16.5),
                Block.box(0, 5, 3, 1, 11, 13),
                Block.box(2, 13, 3, 3, 14, 13),
                Block.box(2, 2, 3, 3, 3, 13),
                Block.box(15, 5, 3, 16, 11, 13),
                Block.box(13, 13, 3, 14, 14, 13),
                Block.box(13, 2, 3, 14, 3, 13),
                Block.box(3, 5, 15, 13, 11, 16),
                Block.box(3, 5, 0, 13, 11, 1),
                Block.box(3, 13, 13, 13, 14, 14),
                Block.box(3, 2, 13, 13, 3, 14),
                Block.box(3, 13, 2, 13, 14, 3)
               // Block.box(-2, 0, -2, 18, 17, 18)
        ).reduce((v1, v2) -> {return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get(),
        Stream.of(
                Block.box(13, 2, 3, 14, 3, 13),
                Block.box(3, 25, 3, 13, 25, 13),
                Block.box(3, 13.5, 3, 13, 13.5, 13),
                Block.box(3, 2, 3, 13, 2, 13),
                Block.box(0, 2, 13, 3, 26, 16),
                Block.box(0, 2, 0, 3, 26, 3),
                Block.box(13, 2, 0, 16, 26, 3),
                Block.box(13, 2, 13, 16, 26, 16),
                Block.box(-4, 8, -4, 20, 8, 20),
                Block.box(-4, 19, -4, 20, 19, 20),
                Block.box(-0.5, 0, 12.5, 3.5, 2, 16.5),
                Block.box(12.5, 0, 12.5, 16.5, 2, 16.5),
                Block.box(-0.5, 0, -0.5, 3.5, 2, 3.5),
                Block.box(12.5, 0, -0.5, 16.5, 2, 3.5),
                Block.box(-0.5, 25, 12.5, 3.5, 27, 16.5),
                Block.box(12.5, 25, 12.5, 16.5, 27, 16.5),
                Block.box(-0.5, 25, -0.5, 3.5, 27, 3.5),
                Block.box(12.5, 25, -0.5, 16.5, 27, 3.5),
                Block.box(3, 16, 15, 13, 22, 16),
                Block.box(0, 16, 3, 1, 22, 13),
                Block.box(3, 16, 0, 13, 22, 1),
                Block.box(15, 16, 3, 16, 22, 13),
                Block.box(3, 6, 15, 13, 12, 16),
                Block.box(0, 6, 3, 1, 12, 13),
                Block.box(3, 6, 0, 13, 12, 1),
                Block.box(15, 6, 3, 16, 12, 13),
                Block.box(3, 24, 13, 13, 25, 14),
                Block.box(2, 24, 3, 3, 25, 13),
                Block.box(3, 24, 2, 13, 25, 3),
                Block.box(13, 24, 3, 14, 25, 13),
                Block.box(3, 13, 13, 13, 14, 14),
                Block.box(2, 13, 3, 3, 14, 13),
                Block.box(3, 13, 2, 13, 14, 3),
                Block.box(13, 13, 3, 14, 14, 13),
                Block.box(3, 2, 13, 13, 3, 14),
                Block.box(2, 2, 3, 3, 3, 13),
                Block.box(3, 2, 2, 13, 3, 3)
                // Block.box(-4, 0, -4, 20, 28, 20)
        ).reduce((v1, v2) -> {return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get()
    );

    public static VoxelShape MOB_MASHER_CLOSED = Stream.of(
            Block.box(0, 13, 7, 16, 13, 9),
            Block.box(0, 0, -6, 16, 16, 2),
            Block.box(0, 0, 14, 16, 16, 22),
            Block.box(0, 0, 6, 16, 16, 8),
            Block.box(0, 0, 8, 16, 16, 10),
            Block.box(6, 6, 2, 10, 10, 6),
            Block.box(6, 6, 10, 10, 10, 14),
            Block.box(3, 0, 6, 3, 16, 8),
            Block.box(13, 0, 7, 13, 16, 9),
            Block.box(0, 3, 7, 16, 3, 9),
            Block.box(13, 0, 6, 13, 16, 8),
            Block.box(3, 0, 7, 3, 16, 9),
            Block.box(0, 13, 6, 16, 13, 8),
            Block.box(17.75, 0, -7, -1.25, 17, 23)
    ).reduce((v1, v2) -> {return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

    public static VoxelShape MOB_MASHER_OPEN = Stream.of(
            Block.box(0, 13, 10, 16, 13, 12),
            Block.box(0, 0, -6, 16, 16, 2),
            Block.box(0, 0, 14, 16, 16, 22),
            Block.box(0, 0, 2, 16, 16, 4),
            Block.box(0, 0, 12, 16, 16, 14),
            Block.box(6, 6, -2, 10, 10, 2),
            Block.box(6, 6, 14, 10, 10, 18),
            Block.box(3, 0, 4, 3, 16, 6),
            Block.box(13, 0, 10, 13, 16, 12),
            Block.box(0, 3, 4, 16, 3, 6),
            Block.box(0, 3, 10, 16, 3, 12),
            Block.box(13, 0, 4, 13, 16, 6),
            Block.box(3, 0, 10, 3, 16, 12),
            Block.box(0, 13, 4, 16, 13, 6)
            ).reduce((v1, v2) -> {return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();
}
