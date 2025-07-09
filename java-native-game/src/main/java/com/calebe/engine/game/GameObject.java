package com.calebe.engine.game;

import java.util.*;

public abstract class GameObject extends AttributeHolder {
    Set<Script> scripts = new HashSet<>();
    protected <T extends Script> T gameScript(T script) {
        scripts.add(script);
        return script;
    }

    public Set<Script> getScripts() {
        return scripts;
    }
    //maybe turn this pattern into some interface or abstract class with generic type
}
