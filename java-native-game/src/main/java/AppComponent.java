import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {
        AttributeModule.class
})
public interface AppComponent {
    Script script();

    @Component.Factory
    interface Factory {
        AppComponent create(@BindsInstance GameObject gameObject);
    }
}
