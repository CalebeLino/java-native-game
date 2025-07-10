package com.calebe.engine.game;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AttributeHolder {
    Map<String, Attribute<String>> attributes = new HashMap<>();
    public Attribute<String> gameAttribute(String key, String initialValue) {
        if(attributes.containsKey(key)) {
            return attributes.get(key);
        }
        Attribute<String> attr = new Attribute<>(key, initialValue);
        attributes.put(key, attr);
        return attr;
    }

    public Set<Attribute<String>> getAttributes() {
        return new HashSet<>(attributes.values());
    }

    public void setAttributes(Map<String, Attribute<String>> attributes) {
        this.attributes = attributes;
    }
}
