package pages;

import io.qameta.allure.Step;
import libs.DateConverter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationFormPage extends ParentPage {

    @FindBy(xpath = "//div[@class='quantumWizButtonEl quantumWizButtonPaperbuttonEl quantumWizButtonPaperbuttonFlat " +
            "quantumWizButtonPaperbuttonDark quantumWizButtonPaperbutton2El2 freebirdFormviewerViewNavigationSubmitButton']//span[contains(text(),'Отправить')]")
    private WebElement buttonSend;

    @FindBy(name = "emailAddress")
    private WebElement inputEmailAddress;

    @FindBy(xpath = ".//input[@type='date']")
    private WebElement inputDate;

    @FindBy(xpath = ".//input[@aria-label= 'Имя']")
    private WebElement inputName;

    @FindBy(xpath = ".//div[@class='quantumWizMenuPaperselectOptionList']")
    private WebElement ddGender;

    @FindBy(xpath = ".//content[contains(text(),'Выбрать')])")
    private WebElement optionSelect;

    @FindBy(xpath = ".//div[@aria-label = 'Нормально']")
    private WebElement checkBoxNormall;

    @FindBy(xpath = ".//a[contains(text(),'Отправить ещё один ответ')]")
    private WebElement linkSendOneMoreResponse;

    @FindBy(id = "i2")
    private WebElement validationMessageOfEmailField;

    @FindBy(xpath = ".//div[@class='freebirdFormviewerViewItemsItemItem freebirdFormviewerViewItemsTextTextItem freebirdFormviewerViewEmailCollectionField HasError']")
    private WebElement redEmailSection;

    @FindBy(xpath = ".//div[@class='freebirdFormviewerViewItemsItemItem freebirdFormviewerViewItemsTextTextItem freebirdFormviewerViewEmailCollectionField']")
    private WebElement sectionEmail;

    @FindBy(xpath = ".//div[@title='Адрес электронной почты']//div[@class='quantumWizTextinputPaperinputUnderline exportUnderline']")
    private WebElement emailfieldLine;

    @FindBy(xpath = ".//input[@type='date']")
    private WebElement inputBirthDate;

    @FindBy(xpath = ".//div[@id='i.err.1236342938']")
    private WebElement validationMessageOfBirthDateField;

    @FindBy(xpath = ".//div[@class= 'freebirdFormviewerViewItemsItemItem HasError' and @data-item-id= '1236342938']")
    private WebElement redBirthDateSection;

    @FindBy(xpath = ".//div[@class='freebirdFormviewerViewItemsItemItem' and @data-item-id= '1236342938']")
    private WebElement sectionBirthDate;

    @FindBy(xpath = ".//div[@id='i.err.1645109785']")
    private WebElement validationMessageOfNameField;

    @FindBy(xpath = ".//div[@class='freebirdFormviewerViewItemsItemItem freebirdFormviewerViewItemsTextTextItem' and @data-item-id='1645109785']")
    private WebElement sectionName;

    @FindBy(xpath = ".//div[@class='freebirdFormviewerViewItemsItemItem freebirdFormviewerViewItemsTextTextItem HasError' and @data-item-id='1645109785']")
    private WebElement redNameSection;

    @FindBy(xpath = ".//div[@class = 'freebirdFormviewerViewItemsItemErrorMessage' and @id = 'i.err.454110266']")
    private WebElement validationMessageOfGenderField;

    @FindBy(xpath = ".//div[@class = 'freebirdFormviewerViewItemsItemItem HasError' and @data-item-id = '454110266']")
    private WebElement redGenderSection;

    @FindBy(xpath = ".//content[contains(text(),'Мужской')]")
    private WebElement optionMale;

    @FindBy(xpath = ".//div[@class = 'freebirdFormviewerViewItemsItemItem' and @data-item-id = '454110266']")
    private WebElement sectionGender;

    @FindBy(xpath = ".//input[@type = 'text' and @aria-label = 'Другой ответ']")
    private WebElement inputAnother;

    @FindBy(xpath = ".//div[@class = 'freebirdFormviewerViewItemsItemErrorMessage' and @id = 'i.err.1001784558']")
    private WebElement validationMessageOfMoodSection;

    @FindBy(xpath = ".//div[@class='freebirdFormviewerViewItemsItemItem HasError' and @data-item-id = '1001784558']")
    private WebElement redMoodSection;

    @FindBy(xpath = ".//div[@class='freebirdFormviewerViewItemsItemItem' and @data-item-id = '1001784558']")
    private WebElement sectionMood;

    @FindBy(xpath = ".//div[@class='freebirdFormviewerViewHeaderTitle exportFormTitle freebirdCustomFont' and contains(text(),'Форма регистрации')]")
    private WebElement headerText;

    @FindBy(xpath = ".//div[@class='freebirdFormviewerViewHeaderDescription' and contains(text(),'Тест форма')]")
    private WebElement nameForm;

    @FindBy(xpath = ".//div[@class='freebirdFormviewerViewHeaderRequiredLegend' and contains(text(), 'Обязательно')]")
    private WebElement textRequired;

    public RegistrationFormPage(WebDriver webDriver) {
        super(webDriver, config.relativeURLRegistrationForm);
    }

    /**
     * Open browser and navigate to registration form
     */
    @Step
    public void openRegistrationForm() {
        try {
            webDriver.get(config.googleFormURL);
            logger.info("Registration form was opened");
        } catch (Exception e) {
            logger.error("Can not open Registration form " + e);
            Assert.fail("Can not open Registration form " + e);
        }
    }

    /**
     * Get current title in the tab browser
     *
     * @return
     */
    @Step
    public String getCurrentTitle() {
        return webDriver.getTitle();
    }

    /**
     * Compare current URL and Expected URL
     */
    @Step
    public void checkTitle() {
        try {
            actionsWithElements.waitUntilTitleDisplayed(config.title, 3);
            Assert.assertEquals("Title is not expected", config.title, getCurrentTitle());
        } catch (Exception e) {
            logger.error("Can not get title " + e);
            Assert.fail("Can not get title " + e);
        }
    }

    @Step
    public boolean isSendButtonDisplayed() {
        return actionsWithElements.isElementDisplayed(buttonSend);
    }

    @Step
    public void enterEmail(String email) {
        actionsWithElements.enterTextInToElement(inputEmailAddress, email);
    }

    @Step
    public void enterValidEmail() {
        enterEmail(user.getValidEmail());
    }

    @Step
    public void enterValidBirthDate() {
        actionsWithElements.enterTextInToElementWithMask(inputDate, DateConverter.getYesterdayDate());
    }

    @Step
    public void enterBirthDate(String date) {
        actionsWithElements.enterTextInToElementWithMask(inputDate, date);
    }

    @Step
    public void setCorrectBirthDate() {
        enterBirthDate(DateConverter.getYesterdayDate());
    }

    @Step
    public void enterName(String name) {
        actionsWithElements.enterTextInToElement(inputName, name);
    }

    @Step
    public void enterValidName() {
        enterName(user.getName());
    }

    public WebElement genderOptions(String genderOption) {
        return webDriver.findElement(By.xpath(".//div[@class='exportSelectPopup quantumWizMenuPaperselectPopup']//content[contains(text(), '" + genderOption + "')]"));
    }

    @Step
    public void selectGender(String genderOption) {
        actionsWithElements.clickOnElement(ddGender);
        actionsWithElements.clickOnElement(genderOptions(genderOption));
        sleep(100);
    }

    @Step
    public void clickSendButton() {
        actionsWithElements.clickOnElement(buttonSend);
    }

    @Step
    public void submitForm() {
        enterValidEmail();
        enterBirthDate(DateConverter.getYesterdayDate());
        enterName(user.getName());
        selectGender("Мужской");
        actionsWithElements.setNeededStateToCheckBox(checkBoxMood("Нормально"), "check");
        clickSendButton();
    }

    @Step
    public void pressTabButton() {
        actionsWithElements.pressTabButton();
    }

    public String getEmailValue() {
        return actionsWithElements.getElementValue(inputEmailAddress);
    }

    @Step
    public boolean isValidationMessageOfEmailFieldDisplayed() {
        return actionsWithElements.isElementDisplayed(validationMessageOfEmailField);
    }

    @Step
    public boolean isRedEmailSectionDisplayed() {
        return actionsWithElements.isElementDisplayed(redEmailSection);
    }

    @Step
    public void setCursorInEmailField() {
        actionsWithElements.clickOnElement(inputEmailAddress);
    }

    public String getValidationMessageTextOfEmailField() {
        return actionsWithElements.getElementText(validationMessageOfEmailField);
    }

    @Step
    public boolean isNotRedEmailSectionDisplayed() {
        return actionsWithElements.isElementDisplayed(sectionEmail);
    }

    @Step
    public void clearEmailField() {
        actionsWithElements.highlightElementValue(inputEmailAddress);
        actionsWithElements.pressDeleteButton();
    }

    public String getPlaceHolderOfEmailField() {
        return actionsWithElements.getElementPlaceHolder(inputEmailAddress);
    }

    public String getColorEmailFieldLine() {
        return actionsWithElements.getElementColor(emailfieldLine, "background-color");
    }

    /**
     * Get birth date value in the "dd.MM.uuuu" format
     *
     * @return
     */
    public String getBirthDateValue() {
        return actionsWithElements.formattingElementDate(inputBirthDate, "dd.MM.uuuu");
    }

    /**
     * Get birth date value as is (uuuu-MM-dd format)
     */
    public String getBirthDate() {
        return actionsWithElements.getElementValue(inputBirthDate);
    }

    public String getYearValue() {
        return actionsWithElements.getElementValue(inputBirthDate).split("-")[0];
    }

    @Step
    public boolean isValidationMessageOfBirthDateFieldDisplayed() {
        return actionsWithElements.isElementDisplayed(validationMessageOfBirthDateField);
    }

    @Step
    public boolean isRedBirthDateSectionDisplayed() {
        return actionsWithElements.isElementDisplayed(redBirthDateSection);
    }

    public String getValidationMessageTextOfBirthDateField() {
        return actionsWithElements.getElementText(validationMessageOfBirthDateField);
    }

    @Step
    public void setCursorInBirthDateField() {
        actionsWithElements.clickOnElement(inputBirthDate);
    }

    @Step
    public boolean isNotRedBirthDateSectionDisplayed() {
        return actionsWithElements.isElementDisplayed(sectionBirthDate);
    }

    @Step
    public void moveFocusFromBirthDateField() {
        actionsWithElements.clickOnElement(inputName);
    }

    @Step
    public boolean isValidationMessageOfNameFieldDisplayed() {
        return actionsWithElements.isElementDisplayed(validationMessageOfNameField);
    }

    @Step
    public boolean isNotRedNameSectionDisplayed() {
        return actionsWithElements.isElementDisplayed(sectionName);
    }

    public String getValidationMessageTextOfNameField() {
        return actionsWithElements.getElementText(validationMessageOfNameField);
    }

    @Step
    public boolean isRedNameSectionDisplayed() {
        return actionsWithElements.isElementDisplayed(redNameSection);
    }

    @Step
    public void setCursorInNameField() {
        actionsWithElements.clickOnElement(inputName);
    }

    @Step
    public void pressBackSpaceButton() {
        actionsWithElements.pressBackSpaceButton();
    }

    @Step
    public void deleteLastSymbol() {
        actionsWithElements.clickOnElement(inputName);
        actionsWithElements.pressEndButton();
    }

    @Step
    public boolean isValidationMessageOfGenderFieldDisplayed() {
        return actionsWithElements.isElementDisplayed(validationMessageOfGenderField);
    }

    public String getValidationMessageTextOfGenderField() {
        return actionsWithElements.getElementText(validationMessageOfGenderField);
    }

    @Step
    public boolean isRedGenderSectionDisplayed() {
        return actionsWithElements.isElementDisplayed(redGenderSection);
    }

    public String checkSelectedGender() {
        sleep(500);
        return actionsWithElements.getElementText(ddGender);
    }

    @Step
    public boolean isNotRedGenderSectionDisplayed() {
        return actionsWithElements.isElementDisplayed(sectionGender);
    }

    public String getNameValue() {
        return actionsWithElements.getElementValue(inputName);
    }

    @Step
    public void pressDownButton() {
        actionsWithElements.pressDownButton();
        sleep(250);
    }

    @Step
    public void pressEnterButton() {
        actionsWithElements.pressEnterButton();
    }

    @Step
    public void pressSpaceButton() {
        actionsWithElements.pressSpaceButton();
    }

    public WebElement checkBoxMood(String moodOption) {
        return webDriver.findElement(By.xpath(".//div[@aria-label= '" + moodOption + "']"));
    }

    public void setStateOfMoodCheckBox(String option, String state) {
        actionsWithElements.setNeededStateToCheckBox(checkBoxMood(option), state);
    }

    /**
     * Check state of the option ckeckbox
     *
     * @param option
     * @param expectedState
     * @return
     */
    public boolean isMoodOptionChecked(String option, boolean expectedState) {
        return actionsWithElements.isPresentXpath(".//div[@aria-label = '" + option + "' and @aria-checked = '" + expectedState + "']");
    }

    @Step
    public void enterAnotherValue(String value) {
        actionsWithElements.enterTextInToElementWithMask(inputAnother, value);
    }

    public String getAnotherValue() {
        return actionsWithElements.getElementValue(inputAnother);
    }

    public void pressPageDownButton() {
        actionsWithElements.pressPageDownButton();
        sleep(1000);
    }

    @Step
    public boolean isValidationMessageOfAnotherFieldDisplayed() {
        return actionsWithElements.isElementDisplayed(validationMessageOfMoodSection);
    }

    @Step
    public boolean isRedMoodSectionDisplayed() {
        return actionsWithElements.isElementDisplayed(redMoodSection);
    }

    public String getValidationMessageTextOfMoodSection() {
        return actionsWithElements.getElementText(validationMessageOfMoodSection);
    }

    @Step
    public boolean isNotRedMoodSectionDisplayed() {
        return actionsWithElements.isElementDisplayed(sectionMood);
    }

    public void clearAnotherField() {
        actionsWithElements.highlightElementValue(inputAnother);
        actionsWithElements.pressDeleteButton();
    }

    public void changeAnotherValue(String value) {
        clearAnotherField();
        enterAnotherValue(value);
    }

    @Step
    public boolean isValidationMessageOfMoodFieldDisplayed() {
        return actionsWithElements.isElementDisplayed(validationMessageOfMoodSection);
    }

    @Step
    public boolean isHeaderElementsDisplayed() {
        return actionsWithElements.isElementDisplayed(headerText) &&
                actionsWithElements.isElementDisplayed(nameForm) &&
                actionsWithElements.isElementDisplayed(textRequired);
    }

    public String getRequiredTextColor() {
        return actionsWithElements.getElementColor(textRequired, "color");
    }

    @Step
    public boolean isAllSectionsPresent() {
        return isNotRedEmailSectionDisplayed() &&
                isNotRedBirthDateSectionDisplayed() &&
                isNotRedNameSectionDisplayed() &&
                isNotRedGenderSectionDisplayed() &&
                isNotRedMoodSectionDisplayed() &&
                isSendButtonDisplayed();
    }

    public boolean checkSectionsColor(String color) {
        String[] headers = new String[]{"Email section", "Birth date section", "Name section", "Gender section", "Mood"};
        String expectedColor = color;
        String[] actualColor = new String[]{actionsWithElements.getElementColor(redEmailSection, "background-color"),
                actionsWithElements.getElementColor(redBirthDateSection, "background-color"),
                actionsWithElements.getElementColor(redNameSection, "background-color"),
                actionsWithElements.getElementColor(redGenderSection, "background-color"),
                actionsWithElements.getElementColor(redMoodSection, "background-color"),};
        for (int i = 0; i < actualColor.length; i++) {
            if (!actualColor[i].equals(expectedColor)) {
                logger.error("Expected color of " + headers[i] + " = " + expectedColor + " Actual = " + actualColor[i]);
                return false;
            }
        }
        return true;
    }
}
