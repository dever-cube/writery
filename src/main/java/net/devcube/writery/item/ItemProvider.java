package net.devcube.writery.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemProvider {

    private ItemProvider(){}

    private static boolean validStringValue(String value){
        return value == null || value.isBlank();
    }

    private static void validateIdAndName(String modID, String name) throws IllegalArgumentException{
        if(validStringValue(modID))
            throw new IllegalArgumentException("Mod's id can't be null or empty string");
        if(validStringValue(name))
            throw new IllegalArgumentException("Item's name can't be null or empty string");
    }

    private static Item createItem(String modID, String name, FabricItemSettings settings) throws IllegalArgumentException{
        validateIdAndName(modID, name);
        return Registry.register(Registries.ITEM,
                new Identifier(modID, name),
                new Item(settings));
    }

    public static Item createIngredientItem(String modID, String name) throws IllegalArgumentException{
        return createItem(modID, name, new FabricItemSettings());
    }
}
