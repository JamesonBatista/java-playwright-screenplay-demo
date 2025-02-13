package interactions;

import screen.Actor;
import screen.Task;

public class Click implements Task {
    private final String selector;

    private Click(String selector) {
        this.selector = selector;
    }

    public static Click on(String selector) {
        return new Click(selector);
    }

    @Override
    public void performAs(Actor actor) {
        actor.getPage().click(selector);
    }
}