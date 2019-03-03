package registrationForm;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import parentTest.ParentTest;

public class OpenRegistrationForm extends ParentTest {

    @Test
    @Description("TestCase 1: Make sure that form is opened")
    @Severity(SeverityLevel.CRITICAL)
    public void makeSureThatFormIsOpened() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        checkExpectedResult("Form should be opened and 'Send' button should be displayed", registrationFormPage.isSendButtonDisplayed());
    }

    @Test
    @Description("TestCase 2: Verify of the title")
    @Severity(SeverityLevel.MINOR)
    public void checkTitle() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.checkTitle();
    }

    @Test
    @Description("TestCase_45: Make sure that new form is opened if click «Отправить еще один ответ»")
    @Severity(SeverityLevel.NORMAL)
    public void makeSureThatNewFormIsOpenedIfClickSendOneMoreLink() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.submitForm();
        formResponsePage.checkURL();
        checkExpectedResult("Form should be successfully submitted", formResponsePage.isSuccessfullyResponseDisplayed());
        checkExpectedResult("Inappropriate text is displayed in the form response", formResponsePage.getTextInAreaFormResponse(), "Форма регистрации\n" +
                "Ответ записан.\n" +
                "Отправить ещё один ответ");
        formResponsePage.clickOnSendOneMoreResponseLink();
        registrationFormPage.checkURL();
        checkExpectedResult("New registration form should be opened", registrationFormPage.isSendButtonDisplayed());
    }

    @Test
    @Description("TestCase 47: Verify content of the form")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyFormContent() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        checkExpectedResult("Header elements should be displayed", registrationFormPage.isHeaderElementsDisplayed());
        checkExpectedResult("'Required' text has inappropriate color", registrationFormPage.getRequiredTextColor(), "#c5221f");
        checkExpectedResult("All sections should be displayed on the form", registrationFormPage.isAllSectionsPresent());
    }

    @Test
    @Description("TestCase_50: Check default value in the gender field")
    @Severity(SeverityLevel.NORMAL)
    public void checkDefaultValueInGenderField() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        checkExpectedResult("Inappropriate default value in the gender field", registrationFormPage.checkSelectedGender(), "Выбрать");
    }

    @Test
    @Description("TestCase_51: Check validation color of sections")
    @Severity(SeverityLevel.NORMAL)
    public void checkValidationColorOfSection() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.clickSendButton();
        checkExpectedResult("Validation color of the section should be correct", registrationFormPage.checkSectionsColor("#fce8e6"));
    }
}
