import dagger.Component;

@Component(modules = {
        GameObjectModule.class,
        ScriptModule.class,
        AttributesSharer.class
})
public interface AppComponent {
}
