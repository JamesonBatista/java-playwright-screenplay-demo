package interactions;

import screen.Actor;
import screen.Interactions;
import screen.Question;
import screen.Task;

public class Text implements Interactions {
    private String selector;
    private String text;

    public static Text contain(String selector, String option) {
        Text t = new Text();
        t.selector = selector;
        t.text = option;
        return t;
    }

    @Override
    public void performAs(Actor actor) {
        Question.textContains(selector, text);
    }

}
