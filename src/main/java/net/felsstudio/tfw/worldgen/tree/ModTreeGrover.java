package net.felsstudio.tfw.worldgen.tree;

import net.felsstudio.tfw.TheFelasWorld;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrover {
   public static final TreeGrower GARGIA = new TreeGrower(TheFelasWorld.MOD_ID + ":gargia",
           Optional.empty(),Optional.empty(),Optional.empty());
}
