import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class GameObject {
    List<Attribute> attributes = new LinkedList<>();
    <T> T publishAttribute(String key, T value) {
        attributes.add(new Attribute<>(hashCode(), key, value));
        return value;
    }
    public List<Attribute> getAttributes() {
        return attributes;
    }
}
