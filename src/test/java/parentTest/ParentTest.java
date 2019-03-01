package parentTest;

import factory.ConfigFactory;
import factory.ModelsFactory;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import libs.Config;
import models.User;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegistrationFormPage;
import pages.FormResponsePage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {

    protected Logger logger = Logger.getLogger(getClass());
    protected User user;
    protected WebDriver webDriver;
    protected Config config = ConfigFactory.getConfig();
    protected RegistrationFormPage registrationFormPage;
    protected FormResponsePage formResponsePage;

    @Before
    public void setUp() {
        user = ModelsFactory.getUser();
        File file = new File(config.driverPath);
        System.setProperty(config.driverName, file.getAbsolutePath());
        webDriver = new ChromeDriver();
        sleep(100);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(config.timeForDefaultWait, TimeUnit.SECONDS);
        registrationFormPage = new RegistrationFormPage(webDriver);
        formResponsePage = new FormResponsePage(webDriver);
    }

    /**
     * Check expected result with with indication expected and actual result
     * @param message
     * @param actualResult
     * @param expectedResult
     */
    @Step
    public void checkExpectedResult(String message, boolean actualResult, boolean expectedResult) {
        Assert.assertEquals(message, expectedResult, actualResult);
    }

    /**
     * Check expected result with with verify actual result (expected - always true)
     * @param message
     * @param actualResult
     */
    @Step
    public void checkExpectedResult(String message, boolean actualResult) {
        checkExpectedResult(message, actualResult, true);
    }

    @Step
    public void checkExpectedResult(String message, String actualResult, String expectedResult) {
        Assert.assertEquals(message, expectedResult, actualResult);
    }

    @Step
    public void checkExpectedResult(String message, Double actualResult, Double expectedResult) {
        Assert.assertEquals(message, expectedResult, actualResult);
    }

    @Step
    public void checkExpectedResult(String message, Integer actualResult, Integer expectedResult) {
        Assert.assertEquals(message, expectedResult, actualResult);
    }

    /**
     * Method make screenshots for failed tests and quit browser
     */
    @Rule
    public TestWatcher watchman = new TestWatcher() {
        String fileName;

        @Override
        protected void failed(Throwable e, Description description) {
            screenshot();
        }

        @Attachment(value = "Page screenshot", type = "image/png")
        public byte[] saveScreenshot(byte[] screenShot) {
            return screenShot;
        }

        public void screenshot() {
            if (webDriver == null) {
                logger.info("Driver for screenshot not found");
                return;
            }
            saveScreenshot(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES));
        }

        @Override
        protected void finished(Description description) {
            logger.info(String.format("Finished test: %s::%s", description.getClassName(), description.getMethodName()));
            webDriver.quit();
        }
    };

    /**
     * Thread sleep
     * @param milliseconds
     */
    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
