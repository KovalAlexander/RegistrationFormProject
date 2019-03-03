package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormResponsePage extends ParentPage {

    @FindBy(xpath = ".//div[@class='freebirdFormviewerViewResponseConfirmContentContainer']")
    private WebElement areaFormResponse;

    final String link_SendOneMoreResponse = ".//a[contains(text(),'Отправить ещё один ответ')]";

    @FindBy(xpath = link_SendOneMoreResponse)
    private WebElement linkSendOneMoreResponse;

    public FormResponsePage(WebDriver webDriver) {
        super(webDriver, config.relativeURLResponsePage);
    }

    public boolean isSuccessfullyResponseDisplayed() {
        return actionsWithElements.isElementDisplayed(areaFormResponse);
    }

    public String getTextInAreaFormResponse() {
        return actionsWithElements.getElementText(areaFormResponse);
    }

    public boolean checkThatSendOneMoreResponseIsLink() {
        if (actionsWithElements.isPresentXpath(link_SendOneMoreResponse)) {
            return true;
        }
        return false;
    }

    @Step
    public void clickOnSendOneMoreResponseLink() {
        actionsWithElements.clickOnElement(linkSendOneMoreResponse);
    }
}
