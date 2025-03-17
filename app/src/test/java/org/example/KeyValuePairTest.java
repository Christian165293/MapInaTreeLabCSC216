package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KeyValuePairTest {
    @Test
    public void testCompareTo() {
        KeyValuePair pair1 = new KeyValuePair("key1", "value1");
        KeyValuePair pair2 = new KeyValuePair("key2", "value2");
        KeyValuePair pair3 = new KeyValuePair("key1", "value3");

        assertTrue(pair1.compareTo(pair2) < 0); // "key1" < "key2"
        assertTrue(pair2.compareTo(pair1) > 0); // "key2" > "key1"
        assertEquals(0, pair1.compareTo(pair3)); // "key1" == "key1"
    }

    @Test
    public void testEquals() {
        KeyValuePair pair1 = new KeyValuePair("key1", "value1");
        KeyValuePair pair2 = new KeyValuePair("key1", "value2");
        KeyValuePair pair3 = new KeyValuePair("key2", "value1");

        assertEquals(pair1, pair2); // Same key, different value
        assertNotEquals(pair1, pair3); // Different key
        assertNotEquals(null, pair1); // Null comparison
    }

    @Test
    public void testGettersAndSetters() {
        KeyValuePair pair = new KeyValuePair("key1", "value1");
        assertEquals("key1", pair.getKey());
        assertEquals("value1", pair.getValue());

        pair.setValue("newValue");
        assertEquals("newValue", pair.getValue());
    }
}