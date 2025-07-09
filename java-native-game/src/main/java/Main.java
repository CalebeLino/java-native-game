public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        CycleManager cycleManager = DaggerAppComponent.create().cycleManager();
        cycleManager.performActivation();
        cycleManager.performUpdate();
    }
}