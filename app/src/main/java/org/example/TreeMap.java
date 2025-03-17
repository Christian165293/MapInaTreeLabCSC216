package org.example;

public class TreeMap {

    private final SplayTree<KeyValuePair> tree;

    public TreeMap() {
        tree = new SplayTree<>();
    }

    public void insert(String inKey, String inValue) {
        KeyValuePair pair = new KeyValuePair(inKey, inValue);
        tree.insert(pair);
    }

    public String get(String key) {
        KeyValuePair dummy = new KeyValuePair(key, "");
        return tree.get(dummy);
    }

    public void delete(String key) {
        KeyValuePair dummy = new KeyValuePair(key, "");
        tree.delete(dummy);
    }
}
