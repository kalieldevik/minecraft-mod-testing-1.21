package net.kali.mcmodtesting.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kali.mcmodtesting.MinecraftModTesting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item EXAMPLE_ITEM = register(
            new Item(new Item.Settings().maxCount(16)),
            "example_item"
    );

    // accepts instance of an item and a string identifier
    // this method will create an item with the provided identifier and register it with the game's item registry
    private static Item register(Item item, String id) {
        // create identifier for item
        Identifier itemID = Identifier.of(MinecraftModTesting.MOD_ID, id);

        //register the items
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

        //return registered item
        return registeredItem;
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((itemGroup) -> itemGroup.add(ModItems.EXAMPLE_ITEM));
    }

}
