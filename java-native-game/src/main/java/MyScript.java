import dagger.Subcomponent;
import jakarta.inject.Inject;

import java.util.Set;

public class MyScript implements Script {
    String name;
    @Inject
    public MyScript(Attribute<String> name) {
        this.name = name.key("name").asValue();
    }
}
