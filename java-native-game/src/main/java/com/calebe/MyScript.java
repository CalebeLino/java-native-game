package com.calebe;

import com.calebe.engine.game.Attribute;
import com.calebe.engine.game.Script;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.function.Supplier;

@Singleton
public class MyScript extends Script {
    @Inject
    public MyScript() {
    }

    @Override
    public Supplier<Update> update() {
        return () -> new Script.Update() {
            {
                name = gameAttribute("name", "");
                health = gameAttribute("health", 0);
            }
            Attribute<String> name;
            Attribute<Integer> health;
            public void execute() {
                System.out.println("Hello " + name.value + ", your health is " + health.value);
            }
        };
    }
}
