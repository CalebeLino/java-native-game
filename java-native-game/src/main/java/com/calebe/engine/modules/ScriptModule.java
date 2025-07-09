package com.calebe.engine.modules;

import com.calebe.MyScript;
import com.calebe.engine.game.Script;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import jakarta.inject.Singleton;

@Module
public abstract class ScriptModule {
    @Binds
    @Singleton
    @IntoSet
    abstract Script myScript(MyScript script);
}
