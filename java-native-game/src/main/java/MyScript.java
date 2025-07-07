import dagger.Subcomponent;
import jakarta.inject.Inject;

public class MyScript implements Script {
    public static class MyUpdate implements Update {
        String name;
        @Inject
        public MyUpdate(String name) {
            this.name = name;
        }
        @Override
        public void execute() {
            System.out.println("hello " + name);
        }
    }
}
