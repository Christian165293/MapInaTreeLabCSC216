package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SplayTreeTest {
    @Test
    public void testInsertAndGet() {
        SplayTree<KeyValuePair> tree = new SplayTree<>();
        KeyValuePair pair1 = new KeyValuePair("key1", "value1");
        KeyValuePair pair2 = new KeyValuePair("key2", "value2");

        tree.insert(pair1);
        tree.insert(pair2);

        assertEquals("value1", tree.get(pair1)); // Check value for key1
        assertEquals("value2", tree.get(pair2)); // Check value for key2
        assertEquals("", tree.get(new KeyValuePair("nonexistent", ""))); // Non-existent key
    }

    @Test
    public void testDelete() {
        SplayTree<KeyValuePair> tree = new SplayTree<>();
        KeyValuePair pair1 = new KeyValuePair("key1", "value1");
        KeyValuePair pair2 = new KeyValuePair("key2", "value2");

        tree.insert(pair1);
        tree.insert(pair2);

        tree.delete(pair1);
        assertEquals("", tree.get(pair1)); // Deleted key
        assertEquals("value2", tree.get(pair2)); // Other key still exists

        tree.delete(pair2);
        assertEquals("", tree.get(pair2)); // Both keys deleted
    }

    @Test
    public void testSplayOperation() {
        SplayTree<KeyValuePair> tree = new SplayTree<>();
        KeyValuePair pair1 = new KeyValuePair("key1", "value1");
        KeyValuePair pair2 = new KeyValuePair("key2", "value2");
        KeyValuePair pair3 = new KeyValuePair("key3", "value3");

        tree.insert(pair1);
        tree.insert(pair2);
        tree.insert(pair3);

        // Access pair2, which should splay it to the root
        assertEquals("value2", tree.get(pair2));

        // Access pair1, which should splay it to the root
        assertEquals("value1", tree.get(pair1));
    }
}