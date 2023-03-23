package src;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ItemStoreImpl implements ItemStore {

    private final Map<String, Item> itemsById = new HashMap<>();
    private final Map<String, Set<Item>> itemsByTag = new HashMap<>();

    @Override
    public void put(Item item) {
        // Add or replace the item in the itemsById map
        itemsById.put(item.getID(), item);

        // Add the item to the itemsByTag map
        itemsByTag.computeIfAbsent(item.getTag(), k -> new HashSet<>()).add(item);
    }

    @Override
    public Item get(String id) {
        return itemsById.get(id);
    }

    @Override
    public void dropAllByTag(String tag) {
        // Get the set of items with the specified tag
        Set<Item> itemsWithTag = itemsByTag.get(tag);

        if (itemsWithTag != null) {
            // Remove each item from the itemsById map
            for (Item item : itemsWithTag) {
                itemsById.remove(item.getID());
            }

            // Remove the set of items from the itemsByTag map
            itemsByTag.remove(tag);
        }
    }

    @Override
    public int size() {
        return itemsById.size();
    }
}
