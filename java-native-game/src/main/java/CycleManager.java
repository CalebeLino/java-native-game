import jakarta.inject.Inject;

import java.util.Map;
import java.util.Set;

public class CycleManager {
    AttributesSharer attributesSharer;
    Map<Script, Set<Map.Entry<GameObject, Set<Attribute<String>>>>> sharedAttributes;
    Set<Script> scripts;

    @Inject
    public CycleManager(AttributesSharer attributesSharer, Set<Script> scripts) {
        this.attributesSharer = attributesSharer;
        this.scripts = scripts;
    }

    public void performActivation() {
        scripts.forEach(Script::activate);
        sharedAttributes = attributesSharer.sharedAttributes();
    }

    public void performUpdate() {

    }
}
