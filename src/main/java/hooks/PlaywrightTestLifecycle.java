package hooks;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.extension.*;

public class PlaywrightTestLifecycle  implements BeforeAllCallback, AfterAllCallback{

    private static Playwright playwright;
    private static Browser browser;
    private static Page page;

    @Override
    public void   beforeAll(ExtensionContext context){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        page = browser.newPage();
    }
    @Override
    public void afterAll(ExtensionContext context){
        if(playwright != null) playwright.close();
    }
    public static Page getPage(){
        return page;
    }
}
