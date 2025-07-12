package com.calebe.engine;

import com.calebe.engine.game.Attribute;
import com.calebe.engine.game.GameObject;
import com.calebe.engine.game.Script;
import jakarta.inject.Inject;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AttributesSharer {
    Set<GameObject> gameObjectSet;

    @Inject
    public AttributesSharer(Set<GameObject> gameObjectSet) {
        this.gameObjectSet = gameObjectSet;
    }

    public Map<Script, Set<Map.Entry<GameObject, Map<String, Attribute<?>>>>> sharedAttributes() {
        return gameObjectSet.stream().flatMap(AttributesSharer::reverseMapScriptAttributes)
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toSet()))
                );
    }

    private static Stream<Map.Entry<Script, Map.Entry<GameObject, Map<String, Attribute<?>>>>> reverseMapScriptAttributes(GameObject gobj) {
        return gobj.getScripts()
                .stream().map(script -> Map.entry(
                        script,
                        Map.entry(gobj, scriptRequiredAttributes(gobj, script)))
                );
    }

    private static Map<String, Attribute<?>> scriptRequiredAttributes(GameObject gobj, Script script) {
        return script.getAttributes()
                .stream().map(sattr ->
                        gobj.getAttributes()
                                .stream()
                                .filter(gattr ->
                                        Objects.equals(gattr.key, sattr.key) &&
                                        gattr.value.getClass() == sattr.value.getClass())
                                .findFirst()
                                .orElseThrow(() -> new AttributeNotFoundException(
                                        "Attribute \"" + sattr.key + "\" with type " + sattr.value.getClass().getSimpleName() + " not found")))
                .collect(Collectors.toMap(attr -> attr.key, Function.identity()));
    }
}
