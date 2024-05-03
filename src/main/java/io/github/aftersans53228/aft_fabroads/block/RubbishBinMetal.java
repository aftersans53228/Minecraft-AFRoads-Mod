package io.github.aftersans53228.aft_fabroads.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry.RoadToolAttribute;
import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry.RoadToolLinked;

public class RubbishBinMetal extends HorizontalFacingBlock {

    public RubbishBinMetal() {
        super(FabricBlockSettings.of(Material.METAL).hardness(1.5f));
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
    }
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!player.isCreative() && ! player.getMainHandStack().isEmpty()&& !player.getMainHandStack().getItem().equals(RoadToolAttribute) && !player.getMainHandStack().getItem().equals(RoadToolLinked)){
            player.getMainHandStack().setCount(0);
            if (!world.isClient) {
                world.playSound(
                        null, // 当不是null时给所有人放
                        pos, // 播放坐标
                        SoundEvents.BLOCK_AZALEA_LEAVES_PLACE, // 播放声音
                        SoundCategory.BLOCKS, // 播放类型
                        2f, //声音
                        1f // 音高倍增器
                );
            }
        }
        else{
            return ActionResult.PASS;
        }
        return ActionResult.SUCCESS;
    }
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        switch(dir) {
            case NORTH:
            case SOUTH:
                return VoxelShapes.cuboid(-0.11875, 0, 0.24375, 1.11875, 1.05625, 0.75625);
            case EAST:
            case WEST:
                return VoxelShapes.cuboid(0.24375, 0, -0.11875, 0.75625, 1.05625, 1.11875);
            default:
                return VoxelShapes.fullCube();
        }
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }
}
