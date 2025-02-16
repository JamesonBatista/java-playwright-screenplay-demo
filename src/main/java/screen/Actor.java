package screen;

import com.microsoft.playwright.Page;

import java.util.HashMap;
import java.util.Map;

import static hooks.PlaywrightTestLifecycle.page;

public class Actor {
    private final Page page;
    private final Map<String, Object> memory = new HashMap<>();

    public Actor(Page page) {
        this.page = page;
    }

    public void attemptsTo(Object... actions) {
        for (Object action : actions) {
            if (action instanceof Task) {
                ((Task) action).performAs(this);
            } else if (action instanceof Interactions) {
                ((Interactions) action).performAs(this);
            } else {
                throw new IllegalArgumentException("Invalid action provided: " + action);
            }
        }
    }

    public void remember(String key, Object value) {
        memory.put(key, value);
    }

    public Object recall(String key) {
        return memory.get(key);
    }

    public Page getPage() {
        return page;
    }
}