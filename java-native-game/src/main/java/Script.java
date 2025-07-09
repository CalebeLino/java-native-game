import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public abstract class Script extends AttributeHolder {
    abstract Supplier<Update> update();

    public interface Update {
        void execute();
    }
}
