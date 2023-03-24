package io.github.aftersans53228.aft_fabroads.block.voxelshapes;

import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class Rns {
    public static VoxelShape getRnsWE(){
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0, 0.4375, 0.5625, 0.375, 0.5625));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.38125, 0.3125, 0.30625, 0.61875, 0.375, 0.6875));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.46875, 0.375, -0.63125, 0.53125, 1, 1.625));
        return shape;
    }
    public static VoxelShape getRnsNS(){
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4359375, 0, 0.4359375, 0.5609375, 0.375, 0.5609375));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3109375, 0.3125, 0.3796875, 0.6921875, 0.375, 0.6171875));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(-0.6265625, 0.375, 0.4671875, 1.6296875, 1, 0.5296875));
        return shape;
    }
}
