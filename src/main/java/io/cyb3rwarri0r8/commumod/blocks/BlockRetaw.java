package io.cyb3rwarri0r8.commumod.blocks;



/*
 *  CommuMod - A Minecraft Modification
 *  Copyright (C) ${YEAR} Cyb3rWarri0r8
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

import io.cyb3rwarri0r8.commumod.fluids.ModFluidBase;
import io.cyb3rwarri0r8.commumod.fluids.ModFluids;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.lib.helpers.ServerHelper;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;

public class BlockRetaw extends ModFluidBase
{


    private static boolean effect = true;
    private static boolean enableSourceCondense = true;
    private static boolean enableSourceFloat = true;
    private static int maxGlowstoneHeight = 120;
    public int LEVELS = 6;

    public static final Material materialRetaw = new MaterialLiquid(MapColor.emeraldColor);
    private World world;
    private BlockPos blockPos;
    private IBlockState blockState;

    public BlockRetaw(Fluid fluid, Material material) {
        super(ModFluids.retaw, materialRetaw, Reference.MODID + ":" + "retaw");
        setUnlocalizedName("retaw");
        setHardness(1F);
        setQuantaPerBlock(LEVELS);
        setTickRate(20);
    }




    @Override
    public boolean canDisplace(IBlockAccess world, BlockPos blockPos) {
        if (world.getBlockState(blockPos).getBlock().getMaterial().isLiquid()) return false;
        return super.canDisplace(world, blockPos);
    }


    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos blockPos, IBlockState blockState, Entity entity) {
        if (!effect) {
            return;
        }
        if (entity instanceof EntityLivingBase) {
            if (entity.motionY < -0.2) {
                entity.motionY *= 0.5;
                if (entity.fallDistance > 20) {
                    entity.fallDistance = 20;
                } else {
                    entity.fallDistance *= 0.95;
                }
            }
        }
        if (ServerHelper.isClientWorld(world)) {
            return;
        }
        if (world.getTotalWorldTime() % 8 == 0 && entity instanceof EntityLivingBase && !((EntityLivingBase) entity).isEntityUndead()) {
            ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 6 * 20, 0));
            ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.jump.id, 6 * 20, 0));
        }
    }

}
