package pages;

import interactions.Click;
import interactions.Fill;
import screen.Actor;
import screen.Task;

public class Login implements Task {

    public static final String USERNAME = "admin@admin.com";
    public static final String PASSWORD = "admin";

    public static Login withDefaultCredentials() {
        return new Login();
    }

    @Override
    public void performAs(Actor actor) {
        actor.attemptsTo(
                Click.on("a[href=\"login.html\"]"),
                Fill.field("#username", USERNAME),
                Fill.field("#password", PASSWORD),
                Click.on("button[type=\"submit\"]")
        );
    }
}
