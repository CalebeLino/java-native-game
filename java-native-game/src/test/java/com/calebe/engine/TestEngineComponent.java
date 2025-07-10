package com.calebe.engine;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {TestEngineModule.class})
public interface TestEngineComponent {
    CycleManager cycleManager();

    @Component.Factory
    interface TestEngineComponentFactory {
        TestEngineComponent create(@BindsInstance TestEngineContext testEngineContext);
    }
}