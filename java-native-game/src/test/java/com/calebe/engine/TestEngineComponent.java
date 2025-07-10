package com.calebe.engine;

import dagger.Component;

@Component(modules = {TestEngineModule.class})
interface TestEngineComponent {
    CycleManager cycleManager();
}