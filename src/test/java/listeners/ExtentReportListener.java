package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.microsoft.playwright.Page;
import hooks.PlaywrightTestLifecycle;
import org.junit.jupiter.api.extension.*;

import java.nio.file.Paths;


import static utils.ConfigManager.getCurrentDateTime;

public class ExtentReportListener implements TestWatcher, BeforeAllCallback, AfterAllCallback {
    private static ExtentReports extent;
    public static ExtentTest test;

    @Override
    public void beforeAll(ExtensionContext context) {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Automation Test Report");
        spark.config().setReportName("Playwright Automation Tests");

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        test = extent.createTest(context.getDisplayName());
        test.pass("Test passed successfully");
        test.pass("Screenshot:", MediaEntityBuilder.createScreenCaptureFromPath("../" + takeScreenshot().replace("\\", "/")).build());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        test = extent.createTest(context.getDisplayName());
        test.fail(cause, MediaEntityBuilder.createScreenCaptureFromPath("../" + takeScreenshot().replace("\\", "/")).build());
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        test = extent.createTest(context.getDisplayName());
        test.skip("Test aborted: " + cause.getMessage());
    }

    public String takeScreenshot() {
        String screenshotPath = "target/screenshots/" + getCurrentDateTime() + ".png";
        PlaywrightTestLifecycle.page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotPath)));
        return screenshotPath;
    }

    @Override
    public void afterAll(ExtensionContext context) {
        extent.flush();  // Salva o relatório ao final de todos os testes
    }

    public static void print() {
        String screenshotPath = "target/screenshots/" + getCurrentDateTime() + ".png";
        PlaywrightTestLifecycle.page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotPath)));
        try {
            test.info(getCurrentDateTime(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath.replace("\\", "/")).build());
        } catch (Exception e) {
            test.warning("Failed to attach screenshot: " + e.getMessage());
        }
    }
}
