import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;

@Module
public abstract class ScriptModule {
    @Binds
    @IntoSet
    abstract Script myScript(MyScript script);
}
