import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.function.Supplier;

@Singleton
public class MyScript extends Script {
    @Inject
    public MyScript() {
    }

    @Override
    Supplier<Update> update() {
        return () -> new Script.Update() {
            {
                name = gameAttribute("name", "");
            }
            Attribute<String> name;
            public void execute() {
                System.out.println("Hello " + name.value);
            }
        };
    }
}
