package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.ItemStoreImpl;
import src.ItemStore.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ItemStoreImplTest {
    private ItemStoreImpl itemStore;

    @BeforeEach
    public void setup() {
        itemStore = new ItemStoreImpl();
    }

    @Test
    public void testPutAndGet() {
        Item item1 = new TestItem("1", "tag1");
        Item item2 = new TestItem("2", "tag1");

        itemStore.put(item1);
        itemStore.put(item2);

        assertEquals(item1, itemStore.get("1"));
        assertEquals(item2, itemStore.get("2"));
    }

    @Test
    public void testDropAllByTag() {
        Item item1 = new TestItem("1", "tag1");
        Item item2 = new TestItem("2", "tag1");
        Item item3 = new TestItem("3", "tag2");

        itemStore.put(item1);
        itemStore.put(item2);
        itemStore.put(item3);

        itemStore.dropAllByTag("tag1");

        assertNull(itemStore.get("1"));
        assertNull(itemStore.get("2"));
        assertEquals(item3, itemStore.get("3"));
    }

    @Test
    public void testSize() {
        Item item1 = new TestItem("1", "tag1");
        Item item2 = new TestItem("2", "tag1");

        assertEquals(0, itemStore.size());

        itemStore.put(item1);
        assertEquals(1, itemStore.size());

        itemStore.put(item2);
        assertEquals(2, itemStore.size());

        itemStore.dropAllByTag("tag1");
        assertEquals(0, itemStore.size());
    }

    // Test implementation of the Item interface
    private static class TestItem implements Item {
        private final String id;
        private final String tag;

        public TestItem(String id, String tag) {
            this.id = id;
            this.tag = tag;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getTag() {
            return tag;
        }
    }
}
