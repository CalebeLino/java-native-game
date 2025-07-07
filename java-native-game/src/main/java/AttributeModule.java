import dagger.Module;
import dagger.Provides;

import java.util.Set;
import java.util.stream.Collectors;

@Module
public class AttributeModule {
    @Provides
    Set<Attribute> getAttributes(Set<GameObject> gameObjects) {
        return gameObjects.stream()
                .flatMap(gobj -> gobj.getAttributes().stream())
                .collect(Collectors.toSet());
    }
}
