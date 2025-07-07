import jakarta.inject.Inject;

public class GameObject {
    String name;
    MyScript myScript;

    @Inject
    public GameObject(MyScript myScript) {
        this.myScript = myScript;
    }
}
