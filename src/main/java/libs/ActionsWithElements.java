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

    public void continueEnterTextInToElement(WebElement element, String text) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(text);
            logger.info(text + " was saccessfully entered to Input");
        } catch (Exception e) {
            logger.error("Can not enter text in to " + element + e);
            Assert.fail("Can not enter text in to " + element + e);
        }
    }


    public void clickMouseLeftButton(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            Action clickMouseLeftButton = actions.click(element).build();
            clickMouseLeftButton.perform();
            logger.info(element + " was successfully clicked");
        } catch (Exception e) {
            logger.error("Can not click to " + element + e);
            Assert.fail("Can not click to " + element + e);
        }
    }

    public void clearElement(WebElement element) {
        try {
            element.clear();
            logger.info(element + " successfully cleared");
        } catch (Exception e) {
            logger.error(element + " can not cleared " + e);
            Assert.fail(element + " can not cleared " + e);
        }
    }

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

    public boolean isElementEnabled(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isTwoElementsDisplayed(WebElement element1, WebElement element2) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element1));
            wait.until(ExpectedConditions.visibilityOf(element2));
            return element1.isDisplayed() && element2.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementSelected(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isSelected();
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * Select By Text From DD
     *
     * @param element
     * @param text
     */
    public void selectTextFromDD(WebElement element, String text) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            select = new Select(element);
            select.selectByVisibleText(text);
            logger.info(text + " was successfully selected");
        } catch (Exception e) {
            logger.error("Can not work with Element " + text + " " + e);
            Assert.fail("Can not work with Element " + text + " " + e);
        }
    }

    /**
     * Select By Value From DD
     *
     * @param element
     * @param text
     */
    public void selectValueFromDD(WebElement element, String text) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            select = new Select(element);
            select.selectByValue(text);
            logger.info(text + " was successfully selected");
        } catch (Exception e) {
            logger.error("Can not work with Element " + text + " " + e);
            Assert.fail("Can not work with Element " + text + " " + e);
        }
    }

    public void submit(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.submit();
            logger.info(element + " was successfully submitted");
        } catch (Exception e) {
            logger.error("Can not submit " + element + " " + e);
            Assert.fail("Can not submit " + element + " " + e);
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

    public void clickWithJS(WebElement element) {
        try {
            executor.executeScript("arguments[0].click();", element);
            logger.info(element + " was successfully clicked");
        } catch (Exception e) {
            logger.error("Can not click to " + element + " " + e);
            Assert.fail("Can not click to " + element + " " + e);
        }
    }

    /**
     * Так как JS может нажимать на элемент даже если он не отображается, то мы проверяем отображение другого элемента, связанного с элементом, который нужно нажать
     *
     * @param element1 (проверка отображения)
     * @param element2 (нужно нажать)
     */

    public void clickWithJSThenVisibilityAnotherElement(WebElement element1, WebElement element2) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element1));
            executor.executeScript("arguments[0].click();", element2);
            logger.info(element2 + " was successfully clicked");
        } catch (Exception e) {
            logger.error("Can not click to " + element2 + " " + e);
            Assert.fail("Can not click to " + element2 + " " + e);
        }
    }

    public void mouseOverElement(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            Action mouseOveElement = actions.moveToElement(element).build();
            mouseOveElement.perform();
            logger.info("Mouse successfully moved over to " + element);
        } catch (Exception e) {
            logger.error("Mouse can not moved over to " + element + " " + e);
            Assert.fail("Mouse can not moved over to " + element + " " + e);
        }
    }

    public void refreshPage() {
        try {
            webDriver.navigate().refresh();
        } catch (Exception e) {
            logger.error("Can not refresh page " + e);
        }
    }

    public void navigateToURL(String URL) {
        try {
            webDriver.navigate().to(URL);
            logger.info("Successfully navigated to " + URL);
        } catch (Exception e) {
            logger.error("Can not navigated to " + URL + " " + e);
            Assert.fail("Can not navigated to " + URL + " " + e);
        }
    }


    /**
     * Get element's CSS color in the HEX format
     *
     * @param element
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

    public String getElementAttributeValue(WebElement element, String attribute) {
        String value = element.getAttribute(attribute);
        return value;
    }

    public String getElementText(WebElement element) {
        String text = element.getText();
        return text;
    }

    public void waitUntilElementDisplayed(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
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
     * Set needed state
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

    public boolean isPresentXpath(String xpath) {
        try {
            if (webDriver.findElement(By.xpath(xpath)).isDisplayed())
                return true;
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPresentXpathWithSleep(String xpath) {
        try {
            Thread.sleep(250);
            if (webDriver.findElement(By.xpath(xpath)).isDisplayed())
                return true;
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
//            Thread.sleep(250);
            if (element.isDisplayed())
                return true;
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isURLDisplayed(String URL) {
        try {
            Thread.sleep(250);
            if (webDriver.getCurrentUrl().equals(URL))
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

    public boolean isElementVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitUntilXPathPresent(String xpath, int seconds) {
        int time = seconds;
        int period = 1;
        int count = 0;

        try {
            while (count <= time) {
                if (isPresentXpath(xpath)) {
                    sleep(100);
                    return;
                } else {
                    count += period;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementDisplayed(WebElement element, int seconds) {
        int time = seconds;
        int period = 1;
        int count = 0;

        try {
            while (count <= time) {
                if (isElementPresent(element)) {
                    sleep(100);
                    return;
                } else {
                    count += period;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementEnabled(WebElement element, int seconds) {
        int time = seconds;
        int period = 1;
        int count = 0;

        try {
            while (count <= time) {
                if (isElementEnabled(element)) {
                    sleep(100);
                    return;
                } else {
                    count += period;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitURL(String URL, int seconds) {
        int time = seconds;
        int period = 1;
        int count = 0;

        try {
            while (count <= time) {
                if (isURLDisplayed(URL)) {
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
