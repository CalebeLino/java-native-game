package com.calebe.engine.game;

public class Attribute<T> {
    public String key;
    public T value;
    public Attribute(String key, T value) {
        this.key = key;
        this.value = value;
    }
}
