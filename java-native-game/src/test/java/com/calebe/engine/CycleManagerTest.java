package com.calebe.engine;

import com.calebe.engine.game.Attribute;
import com.calebe.engine.game.GameObject;
import com.calebe.engine.game.Script;
import org.junit.jupiter.api.BeforeAll;
import com.calebe.engine.DaggerTestEngineComponent;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CycleManagerTest {
    @Test
    void test_scripts_activation() {
        Script script = Mockito.mock(Script.class);
        GameObject gameObject = Mockito.mock(GameObject.class);

        Attribute<String> nameAttr = new Attribute<>("name", "");
        Mockito.when(script.update()).thenReturn(() -> new Script.Update() {
            {
                name = script.gameAttribute(nameAttr.key, nameAttr.value);
            }
            Attribute<String> name;
            @Override
            public void execute() {

            }
        });
        Mockito.when(gameObject.getAttributes()).thenReturn(Set.of(nameAttr));
        Mockito.when(gameObject.getScripts()).thenReturn(Set.of(script));

        CycleManager cycleManager = DaggerTestEngineComponent.factory()
                .create(new TestEngineContext(Set.of(gameObject), Set.of(script)))
                .cycleManager();

        cycleManager.performActivation();
        assertNotNull(cycleManager.sharedAttributes.get(script));
        assertEquals(gameObject, cycleManager.sharedAttributes.get(script).stream()
                .findFirst().map(Map.Entry::getKey).orElseThrow());
        assertEquals(nameAttr, cycleManager.sharedAttributes.get(script).stream()
                .findFirst().map(Map.Entry::getValue).map(m -> m.get(nameAttr.key)).orElseThrow());
    }
}