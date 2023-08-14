import java.util.ArrayList;
import java.util.List;

public class AppMediator {
    private List<AppComponent> components = new ArrayList<>();

    public void addComponent(AppComponent component) {
        components.add(component);
    }

    public void notify(AppComponent sender, Object event) {
        for (AppComponent component : components) {
            if (component != sender) {
                component.handleEvent(event);
            }
        }
    }
}
