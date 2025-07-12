package com.calebe.engine;

import com.calebe.engine.game.Attribute;
import com.calebe.engine.game.GameObject;
import com.calebe.engine.game.Script;
import jakarta.inject.Inject;

import java.util.Map;
import java.util.Set;

public class CycleManager {
    AttributesSharer attributesSharer;
    Map<Script, Set<Map.Entry<GameObject, Map<String, Attribute<?>>>>> sharedAttributes;
    Set<Script> scripts;

    @Inject
    public CycleManager(AttributesSharer attributesSharer, Set<Script> scripts) {
        this.attributesSharer = attributesSharer;
        this.scripts = scripts;
    }

    public void performActivation() {
        scripts.forEach(script -> script.update().get());
        sharedAttributes = attributesSharer.sharedAttributes();
    }

    public void performUpdate() {
        if(sharedAttributes == null) {
            return;
        }
        scripts.forEach(script -> {
            sharedAttributes.get(script)
                    .forEach(gobjAttr -> {
                        script.setAttributes(gobjAttr.getValue());
                        script.update().get().execute();
                    });
        });
    }
}
