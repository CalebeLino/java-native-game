package com.calebe.engine;

import com.calebe.engine.game.Attribute;
import com.calebe.engine.game.GameObject;
import com.calebe.engine.game.Script;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AttributesSharerTest {
    @Test
    void correctly_share_map_of_attributes() {
        GameObject gobj = Mockito.mock(GameObject.class);
        Script script = Mockito.mock(Script.class);

        Attribute<String> name = new Attribute<>("name", "");
        Mockito.when(gobj.getScripts()).thenReturn(Set.of(script));
        Mockito.when(gobj.getAttributes()).thenReturn(Set.of(name));
        Mockito.when(script.getAttributes()).thenReturn(Set.of(new Attribute<>(name.key, name.value)));

        AttributesSharer attributesSharer = new AttributesSharer(Set.of(gobj));
        var res = attributesSharer.sharedAttributes();

        assertEquals(gobj, res.get(script).stream().findFirst().get().getKey());
        assertEquals(name, res.get(script).stream().findFirst().get().getValue().get(name.key));
    }

    @Test
    void requested_attribute_not_provided_by_gameobject() {
        GameObject gobj = Mockito.mock(GameObject.class);
        Script script = Mockito.mock(Script.class);

        Attribute<Integer> name = new Attribute<>("name", 0);
        Mockito.when(gobj.getScripts()).thenReturn(Set.of(script));
        Mockito.when(gobj.getAttributes()).thenReturn(Set.of(new Attribute<>(name.key, "")));
        Mockito.when(script.getAttributes()).thenReturn(Set.of(name));

        AttributesSharer attributesSharer = new AttributesSharer(Set.of(gobj));
        assertThrows(
                AttributeNotFoundException.class,
                attributesSharer::sharedAttributes,
                "Attribute \"" + name.key +
                        "\" witht type " + name.value.getClass().getSimpleName() + " not found");
    }
}
