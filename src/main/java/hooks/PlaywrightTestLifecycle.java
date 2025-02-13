package hooks;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.extension.*;
import screen.Actor;

import java.util.List;

import static utils.ConfigManager.getProperty;

public class PlaywrightTestLifecycle implements BeforeAllCallback, AfterAllCallback {

    protected static Playwright playwright;
    protected static Browser browser;
    public static Page page;
    public static Actor actor;

    public static Actor getActor() {
        return actor;
    }

    @Override
    public void beforeAll(ExtensionContext context) {
        playwright = Playwright.create();
        page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
                        .setArgs(List.of("--start-maximized"))).newContext(new Browser.NewContextOptions().setViewportSize(null))
                .newPage();

        page.navigate(getProperty("baseUrl"));
        actor = new Actor(page);
    }

    @Override
    public void afterAll(ExtensionContext context) {
        if (playwright != null) playwright.close();
    }
}
