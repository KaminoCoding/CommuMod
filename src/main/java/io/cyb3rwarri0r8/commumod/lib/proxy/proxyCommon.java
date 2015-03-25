package io.cyb3rwarri0r8.commumod.lib.proxy;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;
import io.cyb3rwarri0r8.commumod.lib.handler.ModGuiHandler;
import io.cyb3rwarri0r8.commumod.entity.EntityMiner;
import io.cyb3rwarri0r8.commumod.entity.TileEntityPurifier;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by noah on 5/27/14.
 */
public abstract class proxyCommon{



    public void registerRenderers()
    {

    }



    public void preinit(){

    }

    public void registerSounds()
    {

    }

    public void registerEntitySpawn(){
        BiomeGenBase[] allBiomes = Iterators.toArray(Iterators.filter(Iterators.forArray(BiomeGenBase.getBiomeGenArray()), Predicates.notNull()), BiomeGenBase.class);
        System.out.println("Registering natural spawns");
        EntityRegistry.addSpawn(EntityMiner.class, 10, 3, 10, EnumCreatureType.CREATURE, BiomeGenBase.extremeHills);
        EntityRegistry.addSpawn(EntityMiner.class, 40, 3, 10, EnumCreatureType.CREATURE, BiomeGenBase.extremeHillsEdge);
        EntityRegistry.addSpawn(EntityMiner.class, 40, 3, 10, EnumCreatureType.CREATURE, BiomeGenBase.extremeHillsPlus);

    }

    public static void registerTileEntities()
    {
        //TODO Fix the tileEntity registry problems here
        GameRegistry.registerTileEntity(TileEntityPurifier.class, Reference.MODID + ":purifierTileEntity");
    }

    public void registerNetwork()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(main.instance, new ModGuiHandler());
    }

}
