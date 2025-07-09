package com.calebe.engine.game;

import java.util.function.Supplier;

public abstract class Script extends AttributeHolder {
    public abstract Supplier<Update> update();

    public interface Update {
        void execute();
    }
}
