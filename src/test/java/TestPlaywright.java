import hooks.PlaywrightTestLifecycle;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import pages.Login;

@ExtendWith(PlaywrightTestLifecycle.class)
public class TestPlaywright extends PlaywrightTestLifecycle {
    @Test
    public void initialTest() throws InterruptedException {
        actor.attemptsTo(Login.withDefaultCredentials());

        Thread.sleep(3000);
    }
}
