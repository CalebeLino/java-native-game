package com.calebe.engine;

import com.calebe.engine.game.GameObject;
import com.calebe.engine.game.Script;
import dagger.Module;
import dagger.Provides;

import java.util.Set;

@Module
public class TestEngineModule {
    @Provides
    public Set<GameObject> provideGameObjects(TestEngineContext testEngineContext) {
        return testEngineContext.gameObjects();
    }
    @Provides
    public Set<Script> provideScripts(TestEngineContext testEngineContext) {
        return testEngineContext.scripts();
    }
}
