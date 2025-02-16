package interactions;

import screen.Actor;
import screen.Interactions;
import screen.Task;

public class Select implements Interactions {
    private String selector;
    private String option;


    public static Select from(String selector, String option) {
        Select select = new Select();
        select.selector = selector;
        select.option = option;
        return select;
    }

    @Override
    public void performAs(Actor actor) {
        actor.getPage().selectOption(selector, option);
    }
}
