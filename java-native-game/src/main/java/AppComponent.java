import dagger.Component;

@Component(modules = {
        GameObjectModule.class,
        ScriptModule.class,
        SharedAttributesModule.class
})
public interface AppComponent {
}
