package com.calebe.engine;

import com.calebe.engine.game.GameObject;
import com.calebe.engine.game.Script;

import java.util.HashSet;
import java.util.Set;

public record TestEngineContext(Set<GameObject> gameObjects, Set<Script> scripts) {
}
