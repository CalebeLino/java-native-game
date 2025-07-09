import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import jakarta.inject.Inject;

import java.util.Map;

public class MyGameObject extends GameObject {
    Attribute<String> name;
    MyScript myScript;

    @Inject
    public MyGameObject(MyScript myScript) {
        name = gameAttribute("name", "My GameObject");
        myScript = gameScript(myScript); // doesn't need to assign, but it looks better that way idk
    }
}
