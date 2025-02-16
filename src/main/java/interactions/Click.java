package interactions;

import screen.Actor;
import screen.Interactions;

public class Click implements Interactions {
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