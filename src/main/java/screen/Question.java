package screen;

import static hooks.PlaywrightTestLifecycle.actor;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Question {

    private Question() {
    }

    public static String text(String selector) {
        return actor.getPage().textContent(selector).trim();
    }

    public static boolean isVisible(String selector) {
        return actor.getPage().isVisible(selector);
    }

    public static String attribute(String selector, String attributeName) {
        return actor.getPage().getAttribute(selector, attributeName);
    }

    public static void textContains(String selector, String expectedSubstring) {
        String actualText = actor.getPage().textContent(selector).trim();
        assertTrue(actualText.contains(expectedSubstring),
                "Esperava-se que o texto contivesse: '" + expectedSubstring + "', mas o texto atual é: '" + actualText + "'");
    }

}

