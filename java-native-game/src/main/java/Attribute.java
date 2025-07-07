public class Attribute<T> {
    int gameObject;
    String key;
    T value;
    public Attribute(int gameObject, String key, T value) {
        this.gameObject = gameObject;
        this.key = key;
        this.value = value;
    }
    T asValue() {
        return value;
    }

    public Attribute<T> key(String key) {
        this.key = key;
        return this;
    }

    public Attribute<T> gameObject(int hashCode) {
        this.gameObject = hashCode;
        return this;
    }
}
