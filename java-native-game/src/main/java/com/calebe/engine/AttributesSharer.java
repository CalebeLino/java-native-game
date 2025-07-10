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

public class AttributesSharer {
    Set<GameObject> gameObjectSet;

    @Inject
    public AttributesSharer(Set<GameObject> gameObjectSet) {
        this.gameObjectSet = gameObjectSet;
    }

    public Map<Script, Set<Map.Entry<GameObject, Map<String, Attribute<String>>>>> sharedAttributes() {
        return gameObjectSet.stream().flatMap(gobj ->
            gobj.getScripts()
                    .stream().map(script ->
                    Map.entry(script,
                        Map.entry(
                                gobj,
                                script.getAttributes()
                                .stream().map(sattr ->
                                    gobj.getAttributes()
                                            .stream()
                                            .filter(gattr -> Objects.equals(gattr.key, sattr.key))
                                            .findFirst().orElseThrow())
                                .collect(Collectors.toMap(attr -> attr.key, Function.identity()))
                        )))
        ).collect(Collectors.groupingBy(
                Map.Entry::getKey,
                Collectors.mapping(Map.Entry::getValue, Collectors.toSet())));
    }
}
