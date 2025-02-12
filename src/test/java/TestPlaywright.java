import com.microsoft.playwright.*;
import hooks.PlaywrightTestLifecycle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(PlaywrightTestLifecycle.class)
public class TestPlaywright {
    @Test
    public void initialTest(){
        Page page = PlaywrightTestLifecycle.getPage();
        page.navigate("https://jamesonbatista.github.io/projectqatesterweb/index.html");
        System.out.println(page.title());
    }
}
