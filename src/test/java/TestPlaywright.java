import hooks.PlaywrightTestLifecycle;
import listeners.ExtentReportListener;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import pages.*;

@ExtendWith(PlaywrightTestLifecycle.class)
@ExtendWith(ExtentReportListener.class)
public class TestPlaywright extends PlaywrightTestLifecycle {

    @Test
    public void initialTest() throws InterruptedException {
        actor.attemptsTo(Login.withDefaultCredentials(),
                Register.FillForm()
        );

        Thread.sleep(3000);
    }
}
