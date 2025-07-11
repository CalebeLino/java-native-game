package com.calebe.engine.game;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AttributeHolder {
    Map<String, Attribute<?>> attributes = new HashMap<>();

    @SuppressWarnings("unchecked")
    public <T> Attribute<T> gameAttribute(String key, T initialValue) {
        Attribute<?> attr = attributes.computeIfAbsent(key, k -> new Attribute<>(key, initialValue));
        return (Attribute<T>) attr;
    }

    public Set<Attribute<String>> getAttributes() {
        return new HashSet<>(attributes.values());
    }

    public void setAttributes(Map<String, Attribute<?>> attributes) {
        this.attributes.putAll(attributes);
    }
}
