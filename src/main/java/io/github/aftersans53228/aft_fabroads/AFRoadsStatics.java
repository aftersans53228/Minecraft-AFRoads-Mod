package io.github.aftersans53228.aft_fabroads;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import static io.github.aftersans53228.aft_fabroads.regsitry.AFRoadsBlockRegistry.*;

/**
 * @author aftersans53228
 */
public abstract class AFRoadsStatics {
    public static final String MOD_ID = "aft_fabroads";
    public static final String MOD_VERSION = "1.0.3Dev-Update1-Build1";
    public static final String MINECRAFT_VERSION = "1.17.x";
    public static final List<Block> PILLAR_BLOCKS = new ArrayList<>();
    public static final List<Block> CAN_PILLAR_CONNECT = new ArrayList<>();
    public static final List<Block> TRAFFIC_LIGHTS = new ArrayList<>();
    public static final List<Block> CAN_LINK_BLOCK_PARENT = new ArrayList<>();
    public static final List<Block> CAN_LINK_BLOCK_SUB = new ArrayList<>();
}
