package com.calebe;

import com.calebe.engine.game.Attribute;
import com.calebe.engine.game.GameObject;
import jakarta.inject.Inject;

public class MyGameObject extends GameObject {
    Attribute<String> name;
    Attribute<Integer> health;
    MyScript myScript;

    @Inject
    public MyGameObject(MyScript myScript) {
        name = gameAttribute("name", "My GameObject");
        health = gameAttribute("health", 100);
        myScript = gameScript(myScript); // doesn't need to assign, but it looks better that way idk
    }
}
