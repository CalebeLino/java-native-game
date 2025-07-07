import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;

@Module
abstract class GameObjectModule {
    @Binds
    @IntoSet
    abstract GameObject myGameObject(MyGameObject myGameObject);
}
