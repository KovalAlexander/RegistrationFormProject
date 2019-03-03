package pages;

import factory.ConfigFactory;
import factory.ModelsFactory;
import io.qameta.allure.Step;
import libs.ActionsWithElements;
import libs.Config;
import models.User;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


abstract public class ParentPage {
    public User user;
    WebDriver webDriver;
    Logger logger;
    ActionsWithElements actionsWithElements;
    WebDriverWait wait;
    protected static Config config = ConfigFactory.getConfig();
    String baseUrl;
    String expectedURL;

    public ParentPage(WebDriver webDriver, String relativeURL) {
        user = ModelsFactory.getUser();
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        actionsWithElements = new ActionsWithElements(webDriver);
        logger = Logger.getLogger(getClass());
        baseUrl = config.baseURL;
        expectedURL = baseUrl + relativeURL;
        wait = new WebDriverWait(webDriver, config.timeForWaitElement);
    }


    public String getCurrentURL() {
        return webDriver.getCurrentUrl();
    }

    /**
     * Compare actual URL with expected one
     */
    @Step
    public void checkURL() {
        try {
            wait.until(ExpectedConditions.urlToBe(expectedURL));
            Assert.assertEquals("URL is not expected", expectedURL, getCurrentURL());
        } catch (Exception e) {
            logger.error("Can not work with URL " + e);
            Assert.fail("Can not work with URL " + e);
        }
    }

    /**
     * Thread sleep
     *
     * @param millisecond
     */
    public void sleep(int millisecond) {
        actionsWithElements.sleep(millisecond);
    }

}
