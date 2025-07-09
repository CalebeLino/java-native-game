import dagger.Component;

@Component(modules = {
        GameObjectModule.class,
        ScriptModule.class
})
public interface AppComponent {
    CycleManager cycleManager();
}
