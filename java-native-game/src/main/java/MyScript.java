import dagger.Subcomponent;
import jakarta.inject.Inject;

import java.util.Set;

public class MyScript extends Script {
    @Inject
    public MyScript() {
    }

    @Override
    Script.Update update() {
        return new Script.Update() {
            {
                name = gameAttribute("name", "");
            }
            String name;
            public void execute() {
                System.out.println("Hello " + name);
            }
        };
    }
}
