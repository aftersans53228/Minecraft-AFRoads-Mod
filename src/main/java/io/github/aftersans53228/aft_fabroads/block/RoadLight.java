package io.github.aftersans53228.aft_fabroads.block;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry.RoadTool;

public  class RoadLight extends BlockWithEntity implements BlockEntityProvider {
    public static final IntProperty LightType = IntProperty.of("type",0,1);
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;


    public RoadLight(){
        super(FabricBlockSettings.of(Material.METAL).hardness(1.5f).nonOpaque());
        setDefaultState(getStateManager().getDefaultState().with(LightType, 0));
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(LightType);
        stateManager.add(Properties.HORIZONTAL_FACING);
    }
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getMainHandStack().getItem()== RoadTool){
            if(state.get(LightType)==0) {
                world.setBlockState(pos, state.with(LightType,1));

            }
            else{
                if(state.get(LightType)==1){
                    world.setBlockState(pos, state.with(LightType,0));
                }
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        return switch (dir) {
            case NORTH -> VoxelShapes.cuboid(0.3125, 0.44375, 0, 0.6875, 0.6125, 0.89375);
            case SOUTH -> VoxelShapes.cuboid(0.3125, 0.44375, 0.10625, 0.6875, 0.6125, 1);
            case WEST -> VoxelShapes.cuboid(0, 0.44375, 0.3125, 0.6875, 0.6125, 0.6875);
            case EAST -> VoxelShapes.cuboid(0.10625, 0.44375, 0.3125, 1, 0.6125, 0.6875);
            default -> VoxelShapes.fullCube();
        };
    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }
    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)state.with(FACING, rotation.rotate(state.get(FACING)));
    }
    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }
    @Override
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.aft_fabroads.road_light"));
    }
/*
    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        for(int i=1;i<15;i++){
            if(world.getBlockState(pos.down(i)).getBlock().equals(Blocks.AIR)){
                break;
            };
        }

    }*/

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new RoadLightEntity(pos, state);
    }
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
