import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AttributeHolder {
    Map<String, Attribute<String>> attributes = new HashMap<>();
    Attribute<String> gameAttribute(String key, String initialValue) {
        if(attributes.containsKey(key)) {
            return attributes.get(key);
        }
        Attribute<String> attr = new Attribute<>(hashCode(), key, initialValue);
        attributes.put(key, attr);
        return attr;
    }

    public Set<Attribute<String>> getAttributes() {
        return new HashSet<>(attributes.values());
    }

    public void setAttributes(Set<Attribute<String>> attributes) {
        this.attributes = attributes.stream().collect(Collectors.toMap(attr -> attr.key, Function.identity()));
    }
}
