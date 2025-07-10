package com.calebe;

import com.calebe.engine.game.Attribute;
import com.calebe.engine.game.GameObject;
import com.calebe.engine.game.GameObjectHandler;
import jakarta.inject.Inject;

public class MyGameObject extends GameObject {
    Attribute<String> name;
    MyScript myScript;

    @Inject
    public MyGameObject(GameObjectHandler gameObjectHandler) {
        super(gameObjectHandler);
        name = gameAttribute("name", "My GameObject");
        myScript = gameScript(myScript); // doesn't need to assign, but it looks better that way idk
    }
}
