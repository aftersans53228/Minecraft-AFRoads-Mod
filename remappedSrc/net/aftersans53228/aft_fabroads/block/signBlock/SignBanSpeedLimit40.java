package net.aftersans53228.aft_fabroads.block.signBlock;

import net.aftersans53228.aft_fabroads.block.VOXEL.SignEast;
import net.aftersans53228.aft_fabroads.block.VOXEL.SignNorth;
import net.aftersans53228.aft_fabroads.block.VOXEL.SignSouth;
import net.aftersans53228.aft_fabroads.block.VOXEL.SignWest;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class SignBanSpeedLimit40 extends HorizontalFacingBlock {

    public SignBanSpeedLimit40(){
        super(FabricBlockSettings.of(Material.STONE).hardness(0.1f).nonOpaque());
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
    }
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        switch(dir) {
            case NORTH:
                return SignNorth.getShape();
            case SOUTH:
                return SignSouth.getShape();
            case EAST:
                return SignEast.getShape();
            case WEST:
                return SignWest.getShape();
            default:
                return VoxelShapes.fullCube();
        }
    }
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }
}
