package io.github.aftersans53228.aft_fabroads.block.voxelshapes;

import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import java.util.ArrayList;
import java.util.List;

public class RailingsFacing {
    public static List<VoxelShape> getExpresswayRailings(){
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(0,VoxelShapes.cuboid(0.125f, 0.0f, 0.0f, 0.875f, 1.5f, 1.0f));
        shapes.add(1,VoxelShapes.cuboid(0.0f, 0.0f, 0.125f, 1.0f, 1.5f, 0.875f));
        return shapes;
    }
    public static List<VoxelShape> getExpresswayBase(){
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(0,VoxelShapes.cuboid(0.125f, 0.0f, 0.0f, 0.875f, 1f, 1.0f));
        shapes.add(1,VoxelShapes.cuboid(0.0f, 0.0f, 0.125f, 1.0f, 1f, 0.875f));
        return shapes;
    }
    public static List<VoxelShape> getExpresswayGreenPanels(){
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(0,VoxelShapes.cuboid(0.125f, 0.0f, 0.0f, 0.875f, 2f, 1.0f));
        shapes.add(1,VoxelShapes.cuboid(0.0f, 0.0f, 0.125f, 1.0f, 2f, 0.875f));
        return shapes;
    }
    public static List<VoxelShape> getPavement(){
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(0,VoxelShapes.cuboid(0.0625, 0.0f, 0.0f, 0.9375, 1.35f, 1.0f));
        shapes.add(1,VoxelShapes.cuboid(0.0f, 0.0f, 0.0625, 1.0f, 1.3f, 0.9375));
        return shapes;
    }
    public static List<VoxelShape> getRoad(){
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(0,VoxelShapes.cuboid(0.3125f, 0.0f, 0.0f, 0.6875f, 1.3f, 1.0f));
        shapes.add(1,VoxelShapes.cuboid(0.0f, 0.0f, 0.3125f, 1.0f, 1.3f, 0.6875f));
        return shapes;
    }
    public static List<VoxelShape> getGrayPanelsVertical(){
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(0,VoxelShapes.cuboid(0.4f, 0.0f, 0.0f, 0.6f, 1f, 1.0f));
        shapes.add(1,VoxelShapes.cuboid(0.4f, 0.0f, 0.0f, 0.6f, 1f, 1.0f));
        shapes.add(2,VoxelShapes.cuboid(0.0f, 0.0f, 0.4f, 1.0f, 1f, 0.6f));
        shapes.add(3,VoxelShapes.cuboid(0.0f, 0.0f, 0.4f, 1.0f, 1f, 0.6f));
        return shapes;
    }
    public static List<VoxelShape> getGrayPanelsCorner1(){
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(0,VoxelShapes.cuboid(0.4f, 0.0f, 0.0f, 0.6f, 0.625f, 1.0f));
        shapes.add(1,VoxelShapes.cuboid(0.4f, 0.0f, 0.0f, 0.6f, 0.625f, 1.0f));
        shapes.add(2,VoxelShapes.cuboid(0.0f, 0.0f, 0.4f, 1.0f, 0.625f, 0.6f));
        shapes.add(3,VoxelShapes.cuboid(0.0f, 0.0f, 0.4f, 1.0f, 0.625f, 0.6f));
        return shapes;
    }
    public static List<VoxelShape> getGrayPanelsCorner2(){
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(0,VoxelShapes.cuboid(0f, 0.0f, 0.0f, 0.6f, 0.625f, 1.0f));
        shapes.add(1,VoxelShapes.cuboid(0.4f, 0.0f, 0.0f, 1f, 0.625f, 1.0f));
        shapes.add(2,VoxelShapes.cuboid(0.0f, 0.0f, 0f, 1.0f, 0.625f, 0.6f));
        shapes.add(3,VoxelShapes.cuboid(0.0f, 0.0f, 0.4f, 1.0f, 0.625f, 1f));
        return shapes;
    }
    public static List<VoxelShape> getGrayPanelsHorizontal(){
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(0,VoxelShapes.cuboid(0f, 0.4375f, 0.0f, 1f, 0.5f, 1f));
        shapes.add(1,VoxelShapes.cuboid(0f, 0.4375f, 0.0f, 1f, 0.5f, 1f));
        shapes.add(2,VoxelShapes.cuboid(0f, 0.4375f, 0f, 1.0f, 0.5f, 1f));
        shapes.add(3,VoxelShapes.cuboid(0f, 0.4375f, 0f, 1.0f, 0.5f, 1f));
        return shapes;
    }
}
