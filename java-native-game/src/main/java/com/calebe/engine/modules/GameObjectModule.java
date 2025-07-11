package com.calebe.engine.modules;

import com.calebe.MyGameObject;
import com.calebe.MyOtherGameObject;
import com.calebe.engine.game.GameObject;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;

@Module
public abstract class GameObjectModule {
    @Binds
    @IntoSet
    abstract GameObject myGameObject(MyGameObject myGameObject);

    @Binds
    @IntoSet
    abstract GameObject otherGameObject(MyOtherGameObject otherGameObject);
}
