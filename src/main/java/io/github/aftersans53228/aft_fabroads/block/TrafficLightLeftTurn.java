package io.github.aftersans53228.aft_fabroads.block;

import io.github.aftersans53228.aft_fabroads.block.block_entites.TrafficLightEntity;
import io.github.aftersans53228.aft_fabroads.block.block_entites.TrafficLightLeftTurnEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
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

public  class TrafficLightLeftTurn extends TrafficLight {
    public TrafficLightLeftTurn(){
        super();
    }
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TrafficLightLeftTurnEntity(pos, state);
    }
}
