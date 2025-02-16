package hooks;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import screen.Actor;

import java.util.List;

import static utils.ConfigManager.getCurrentDateTime;
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
        page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(getProperty("setHeadless"))
                        .setArgs(List.of("--start-maximized"))).newContext(new Browser.NewContextOptions().setViewportSize(null))
                .newPage();

        page.navigate(getProperty("baseUrl").toString());
        actor = new Actor(page);
    }

    @Override
    public void afterAll(ExtensionContext context) {
        page.screenshot(new Page.ScreenshotOptions().setPath(java.nio.file.Paths.get("screenshots/" + getCurrentDateTime() + ".png")));
        if (playwright != null) playwright.close();
    }

}
