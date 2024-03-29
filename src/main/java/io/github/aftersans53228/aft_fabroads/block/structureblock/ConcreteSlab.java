package io.github.aftersans53228.aft_fabroads.block.structureblock;

import io.github.aftersans53228.aft_fabroads.AFRoads;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.SlabType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsItemRegistry.RoadTool;

public class ConcreteSlab extends SlabBlock {
    public ConcreteSlab() {
        super(FabricBlockSettings.of(Material.STONE).hardness(1.8f).nonOpaque());
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getMainHandStack().getItem()== RoadTool){
            if (state.get(TYPE) == SlabType.BOTTOM) {
                world.setBlockState(pos, state.with(TYPE, SlabType.TOP));
                return ActionResult.SUCCESS;
            }
            if (state.get(TYPE) == SlabType.TOP) {
                world.setBlockState(pos, state.with(TYPE, SlabType.BOTTOM));
                return ActionResult.SUCCESS;
            }
            if (state.get(TYPE) == SlabType.DOUBLE) {
                player.sendMessage(new TranslatableText("item.aft_fabroads.tool2slab_tip"), true);
            }
        }
        return ActionResult.PASS;
    }
}
