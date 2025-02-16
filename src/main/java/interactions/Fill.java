package interactions;

import screen.Actor;
import screen.Interactions;
import screen.Task;

public class Fill implements Interactions {
    private final String selector;
    private final String value;

    public Fill(String selector, String value) {
        this.selector = selector;
        this.value = value;
    }

    public static Fill field(String selector, String value) {
        return new Fill(selector, value);
    }

    @Override
    public void performAs(Actor actor) {
        actor.getPage().fill(selector, value);
    }
}
