import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;

import javax.inject.Inject;
import java.util.Set;
import java.util.stream.Collectors;

@Module
public class AttributeModule {
    @Provides
    @IntoSet
    Attribute<String> getStringAttribute(GameObject gameObject) {
        return new Attribute<>(gameObject.hashCode(), "", "");
    }
}
