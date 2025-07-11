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
        return gameObjectSet.stream().flatMap(gobj ->
                gobj.getScripts()
                        .stream().map(script ->
                        {
                            Map<String, Attribute<?>> stringToAttr = script.getAttributes()
                                    .stream().map(sattr ->
                                            gobj.getAttributes()
                                                    .stream()
                                                    .filter(gattr -> Objects.equals(gattr.key, sattr.key))
                                                    .findFirst().orElseThrow())
                                    .collect(Collectors.toMap(attr -> attr.key, Function.identity()));
                            return Map.entry(script,
                                    Map.entry(
                                            gobj,
                                            stringToAttr
                                    ));
                        })
        ).collect(Collectors.groupingBy(
                Map.Entry::getKey,
                Collectors.mapping(Map.Entry::getValue, Collectors.toSet())));
    }
}
