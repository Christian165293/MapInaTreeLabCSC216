package org.example;

public class KeyValuePair implements Comparable<KeyValuePair> {
    private final String key;
    private String value;

    public KeyValuePair(String inKey, String inValue) {
        this.key = inKey;
        this.value = inValue;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int compareTo(KeyValuePair other) {
        return this.key.compareTo(other.key);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        KeyValuePair that = (KeyValuePair) obj;
        return key.equals(that.key);
    }

}
