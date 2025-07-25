package com.calebe;

import com.calebe.engine.game.Attribute;
import com.calebe.engine.game.GameObject;
import jakarta.inject.Inject;

public class MyOtherGameObject extends GameObject {
    Attribute<Integer> health;
    Attribute<String> name;
    MyScript myScript;

    @Inject
    public MyOtherGameObject(MyScript myScript) {
        name = gameAttribute("name", "My Other GameObject");
        health = gameAttribute("health", 10);
        myScript = gameScript(myScript); // doesn't need to assign, but it looks better that way idk
    }
}
