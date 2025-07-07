import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import jakarta.inject.Inject;

import java.util.Map;

public class MyGameObject implements GameObject {
    String name;
    MyScript myScript;

    @Inject
    public MyGameObject(Attribute<String> name) {
        this.name = name.key("name").asValue();
    }
}
