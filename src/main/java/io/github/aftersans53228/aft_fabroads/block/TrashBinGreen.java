package io.github.aftersans53228.aft_fabroads.block;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import io.github.aftersans53228.aft_fabroads.item.RoadToolAttribute;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.List;

import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry.RoadTool;
import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry.RoadToolAttribute;
import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry.RoadToolLinked;

public class TrashBinGreen extends HorizontalFacingBlock {
    public static final BooleanProperty CR200j = BooleanProperty.of("cr200j");
    public TrashBinGreen() {
        super(FabricBlockSettings.of(Material.BAMBOO).hardness(1.5f));
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
        setDefaultState(getStateManager().getDefaultState().with(CR200j,false));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(CR200j);
        stateManager.add(Properties.HORIZONTAL_FACING);
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getMainHandStack().getItem().equals(RoadTool)){
            if (state.get(CR200j)) {
                world.setBlockState(pos, state.with(CR200j, false));
            } else {
                world.setBlockState(pos, state.with(CR200j, true));
            }
            return ActionResult.SUCCESS;
        }
        if ((! player.getMainHandStack().isEmpty())&& !player.getMainHandStack().getItem().equals(RoadToolAttribute) && !player.getMainHandStack().getItem().equals(RoadToolLinked)){
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
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        return VoxelShapes.cuboid(0.125, 0, 0.125, 0.875, 1.51875, 0.875);
    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }
    @Override
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add( new TranslatableText("item.aft_fabroads.trash_bin") );
    }
}
