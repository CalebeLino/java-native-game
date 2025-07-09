import dagger.Component;
import jakarta.inject.Singleton;

@Singleton
@Component(modules = {
        GameObjectModule.class,
        ScriptModule.class
})
public interface AppComponent {
    CycleManager cycleManager();
}
