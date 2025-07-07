import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import jakarta.inject.Inject;

import java.util.Map;

@Module
public class MyGameObject extends GameObject {
    String name;
    MyScript myScript;

    @Inject
    public MyGameObject() {
        name = publishAttribute("name", "");
    }
}
