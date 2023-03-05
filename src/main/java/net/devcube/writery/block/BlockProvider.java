package net.devcube.writery.block;

import net.devcube.writery.item.ItemProvider;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockProvider {

    private BlockProvider(){}


    public static Block createBaseBlock(String modId, String name){
        Block block = new Block(FabricBlockSettings.of(Material.METAL));
        return createCustomBlock(modId, name, block);
    }

    public static Block createCustomBlock(String modId, String name, Block block){
        ItemProvider.createBlockItem(modId, name, block);
        return Registry.register(Registries.BLOCK, new Identifier(modId, name),
                new Block(FabricBlockSettings.of(Material.METAL)));
    }


}
