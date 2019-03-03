package libs;

import factory.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ActionsWithElements {

    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected static Config config = ConfigFactory.getConfig();
    Select select;
    WebDriverWait wait;
    Actions actions;
    JavascriptExecutor executor;

    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, config.timeForWaitElement);
        actions = new Actions(webDriver);
        executor = (JavascriptExecutor) webDriver;
    }

    public void clickOnElement(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info(element + " was successfully clicked");
        } catch (Exception e) {
            logger.error("Can not click to " + element + e);
            Assert.fail("Can not click to " + element + e);
        }
    }

    public void enterTextInToElement(WebElement element, String text) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was successfully entered to Input");
        } catch (Exception e) {
            logger.error("Can not enter text in to " + element + e);
            Assert.fail("Can not enter text in to " + element + e);
        }
    }

    /**
     * Enter text in the input with mask
     * @param element
     * @param text
     */
    public void enterTextInToElementWithMask(WebElement element, String text) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(text);
            logger.info(text + " was successfully entered to Input");
        } catch (Exception e) {
            logger.error("Can not enter text in to " + element + e);
            Assert.fail("Can not enter text in to " + element + e);
        }
    }

    /**
     * Press Ctrl+A in the element
     * @param element
     */
    public void highlightElementValue(WebElement element) {
        try {
            element.click();
            element.sendKeys(Keys.CONTROL + "a");
            logger.info("Ctrl + a successfully press");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Ctrl + a is not pressed " + e);
        }
    }

    public void pressDeleteButton() {
        try {
            Action pressDelete = actions.sendKeys(Keys.DELETE).build();
            pressDelete.perform();
            logger.info("Delete successfully press");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Delete is not pressed " + e);
        }
    }

    public void pressEndButton() {
        try {
            Action pressEnd = actions.sendKeys(Keys.END).build();
            pressEnd.perform();
            logger.info("END successfully press");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("END is not pressed " + e);
        }
    }

    public void pressBackSpaceButton() {
        try {
            Action pressBackSpace = actions.sendKeys(Keys.BACK_SPACE).build();
            pressBackSpace.perform();
            logger.info("Backspace successfully press");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Backspace is not pressed " + e);
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void pressEnterButton() {
        try {
            Action pressEnter = actions.sendKeys(Keys.ENTER).build();
            pressEnter.perform();
            logger.info("Enter is successfully press");
        } catch (Exception e) {
            logger.error("Enter was not press " + e);
            Assert.fail("Enter was not press " + e);
        }
    }

    /**
     *Get element's CSS style
     * @param element
     * @param style
     * @return
     */
    public String getElementColor(WebElement element, String style) {
        String color = element.getCssValue(style);
        String hexColor = Color.fromString(color).asHex();
        return hexColor;
    }

    /**
     * Get value from element
     *
     * @param element
     * @return
     */
    public String getElementValue(WebElement element) {
        try {
            String value = element.getAttribute("value");
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getElementText(WebElement element) {
        String text = element.getText();
        return text;
    }

    public void pressTabButton() {
        try {
            Action pressTab = actions.sendKeys(Keys.TAB).build();
            pressTab.perform();
            logger.info("TAB is successfully press");
        } catch (Exception e) {
            logger.error("TAB was not press " + e);
            Assert.fail("TAB was not press " + e);
        }
    }

    /**
     * Set needed state to checkbox
     *
     * @param element
     * @param state   (Only!!! check or uncheck)
     */

    public void setNeededStateToCheckBox(WebElement element, String state) {
        boolean checkState = state.toLowerCase().equals("check");
        boolean unCheckState = state.toLowerCase().equals("uncheck");
        if (checkState || unCheckState) {
            if (element.isSelected() && checkState) {
                logger.info("Checkbox is already checked");
            } else if (!element.isSelected() && unCheckState) {
                clickOnElement(element);
            } else if (!element.isSelected() && checkState) {
                clickOnElement(element);
            } else if (!element.isSelected() && unCheckState)
                logger.info("Checkbox is already unchecked");
        } else {
            logger.error("State should be check or uncheck");
            Assert.fail("State should be check or uncheck");
        }
    }

    /**
     * Get placeholder from element
     *
     * @param element
     * @return
     */
    public String getElementPlaceHolder(WebElement element) {
        String placeholder = element.getAttribute("aria-label");
        return placeholder;
    }

    /**
     * Check displaying XPath on the page
     *
     * @param xpath
     * @return
     */
    public boolean isPresentXpath(String xpath) {
        try {
            if (webDriver.findElement(By.xpath(xpath)).isDisplayed())
                return true;
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isTitleDisplayed(String title) {
        try {
            Thread.sleep(250);
            if (webDriver.getTitle().equals(title))
                return true;
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Thread sleep
     *
     * @param milliseconds
     */
    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Wait until title in browser tab displayed
     *
     * @param title
     * @param seconds
     */
    public void waitUntilTitleDisplayed(String title, int seconds) {
        int time = seconds;
        int period = 1;
        int count = 0;

        try {
            while (count <= time) {
                if (isTitleDisplayed(title)) {
                    sleep(100);
                    return;
                } else {
                    sleep(750);
                    count += period;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Formatting element date value
     *
     * @param element
     * @param formatDate
     * @return
     */
    public String formattingElementDate(WebElement element, String formatDate) {
        LocalDate date = LocalDate.parse(getElementValue(element));
        DateTimeFormatter format = DateTimeFormatter.ofPattern(formatDate);
        return date.format(format);
    }

    public void pressDownButton() {
        try {
            Action pressDown = actions.sendKeys(Keys.DOWN).build();
            pressDown.perform();
            logger.info("DOWN successfully press");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("DOWN is not pressed " + e);
        }
    }

    public void pressSpaceButton() {
        try {
            Action pressSpace = actions.sendKeys(Keys.SPACE).build();
            pressSpace.perform();
            logger.info("SPACE successfully press");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("SPACE is not pressed " + e);
        }
    }

    public void pressPageDownButton() {
        try {
            Action pressPageDown = actions.sendKeys(Keys.PAGE_DOWN).build();
            pressPageDown.perform();
            logger.info("PageDown successfully press");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("PageDown is not pressed " + e);
        }
    }
}
