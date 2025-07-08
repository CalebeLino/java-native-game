import java.util.HashSet;
import java.util.Set;

public abstract class AttributeHolder {
    Set<Attribute<String>> attributes = new HashSet<>();
    String gameAttribute(String key, String initialValue) {
        attributes.add(new Attribute<>(hashCode(), key, initialValue));
        return initialValue;
    }

    public Set<Attribute<String>> getAttributes() {
        return attributes;
    }
}
