import jakarta.inject.Inject;

import java.util.function.Supplier;

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
                System.out.println("Hello " + name);
            }
        };
    }
}
