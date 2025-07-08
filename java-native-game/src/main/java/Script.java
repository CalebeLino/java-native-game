import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class Script extends AttributeHolder {
    Update update;
    Update update() {
        return update;
    }
    void activate() {
        update = update();
    }

    public interface Update {
        void execute();
    }

    public Update getUpdate() {
        return update;
    }
}
