package com.calebe.engine.game;

import java.util.*;

public abstract class GameObject extends AttributeHolder {
    private final GameObjectHandler gameObjectHandler;

    protected GameObject(GameObjectHandler gameObjectHandler) {
        this.gameObjectHandler = gameObjectHandler;
    }
    protected <T extends Script> T gameScript(T script) {
        scripts.add(script);
        return script;
    }
}
