package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TreeMapTest {
    @Test
    public void testInsertAndGet() {
        TreeMap map = new TreeMap();
        map.insert("key1", "value1");
        map.insert("key2", "value2");

        assertEquals("value1", map.get("key1"));
        assertEquals("value2", map.get("key2"));
        assertEquals("", map.get("nonexistent")); // Non-existent key
    }

    @Test
    public void testDelete() {
        TreeMap map = new TreeMap();
        map.insert("key1", "value1");
        map.insert("key2", "value2");

        map.delete("key1");
        assertEquals("", map.get("key1")); // Deleted key
        assertEquals("value2", map.get("key2")); // Other key still exists

        map.delete("key2");
        assertEquals("", map.get("key2")); // Both keys deleted
    }

    @Test
    public void testUpdateValue() {
        TreeMap map = new TreeMap();
        map.insert("key1", "value1");
        map.insert("key1", "newValue"); // Update value for existing key

        assertEquals("newValue", map.get("key1"));
    }
}