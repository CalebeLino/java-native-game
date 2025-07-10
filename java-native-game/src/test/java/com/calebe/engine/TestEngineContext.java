package com.calebe.engine;

import com.calebe.engine.game.GameObject;
import com.calebe.engine.game.Script;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class TestEngineContext {
    private final Set<GameObject> gameObjects;
    private final Set<Script> scripts;

    public TestEngineContext() {
        this.gameObjects = new HashSet<>();
        this.scripts = new HashSet<>();
    }

    public TestEngineContext(Set<GameObject> gameObjects, Set<Script> scripts) {
        this();
        this.gameObjects.addAll(gameObjects);
        this.scripts.addAll(scripts);
    }

    public Set<GameObject> gameObjects() {
        return this.gameObjects;
    }

    public Set<Script> scripts() {
        return this.scripts;
    }
}
