package com.calebe.engine;

import com.calebe.engine.game.GameObject;
import dagger.Module;
import dagger.Provides;

import java.util.Set;

@Module
public abstract class TestEngineModule {
    @Provides
    Set<GameObject> provideGameObjects(TestEngineContext testEngineContext) {
        return testEngineContext.gameObjects();
    }
}
