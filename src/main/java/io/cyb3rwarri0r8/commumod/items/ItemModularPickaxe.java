package io.cyb3rwarri0r8.commumod.items;




import io.cyb3rwarri0r8.commumod.lib.Reference;
import net.minecraft.item.ItemPickaxe;

public class ItemModularPickaxe extends ItemPickaxe {

    public ItemModularPickaxe(ToolMaterial material)
    {
        super(material);

        setUnlocalizedName("modularPickaxe");
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
//        setCreativeTab(Commumod.modTab);

    }




}
