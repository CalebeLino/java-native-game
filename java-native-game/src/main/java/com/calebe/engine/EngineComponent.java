package com.calebe.engine;

import com.calebe.engine.modules.GameObjectModule;
import com.calebe.engine.modules.ScriptModule;
import dagger.Component;
import jakarta.inject.Singleton;

@Singleton
@Component(modules = {
        GameObjectModule.class,
        ScriptModule.class
})
public interface EngineComponent {
    CycleManager cycleManager();
}
