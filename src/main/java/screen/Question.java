package screen;

public class Question {

    private Question() {}

    public static String text(Actor actor, String selector) {
        return actor.getPage().textContent(selector).trim();
    }

    public static boolean isVisible(Actor actor, String selector) {
        return actor.getPage().isVisible(selector);
    }

    public static String attribute(Actor actor, String selector, String attributeName) {
        return actor.getPage().getAttribute(selector, attributeName);
    }
}

