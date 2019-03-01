package registrationForm;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import parentTest.ParentTest;

public class EmailAddress extends ParentTest {

    @Test
    @Description("TestCase_4: Verify that user can enter correct email")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyThatUserCanEnterCorrectEmail() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.enterEmail("test@test.tt");
        registrationFormPage.pressTabButton();
        checkExpectedResult("Email is not entered", registrationFormPage.getEmailValue(), "test@test.tt");
        checkExpectedResult("Validation message should not be displayed", registrationFormPage.isValidationMessageOfEmailFieldDisplayed(), false);
        checkExpectedResult("Email section should not be highlighted red color", registrationFormPage.isRedEmailSectionDisplayed(), false);
    }

    @Test
    @Description("TestCase_5: Verify that email field is required for filling")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyThatEmailAddressIsRequiredForFilling() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.setCursorInEmailField();
        registrationFormPage.pressTabButton();
        checkExpectedResult("Validation message should be displayed", registrationFormPage.isValidationMessageOfEmailFieldDisplayed());
        checkExpectedResult("Email section should be highlighted red color", registrationFormPage.isRedEmailSectionDisplayed());
    }

    @Test
    @Description("TestCase_6: Make sure that validation is displayed if enter incorrect email format")
    @Severity(SeverityLevel.NORMAL)
    public void makeSureThatValidationIsDisplayedIfEnterIncorrectEmail() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.enterEmail("test.test");
        registrationFormPage.pressTabButton();
        checkExpectedResult("Email is not entered", registrationFormPage.getEmailValue(), "test.test");
        checkExpectedResult("Inappropriate validation message displayed", registrationFormPage.getValidationMessageTextOfEmailField(), "Укажите действительный адрес эл. почты");
        checkExpectedResult("Email section should be highlighted red color", registrationFormPage.isRedEmailSectionDisplayed());
    }

    @Test
    @Description("TestCase_7: Make sure that validation is not displayed if to change incorrect email format to correct one.")
    @Severity(SeverityLevel.NORMAL)
    public void makeSureThatValidationMessageIsNotDisplayedAfterChangedIncorrectEmailToCorrectOne() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.enterEmail("test@Test,tt");
        registrationFormPage.pressTabButton();
        checkExpectedResult("Email is not entered", registrationFormPage.getEmailValue(), "test@Test,tt");
        checkExpectedResult("Inappropriate validation message displayed", registrationFormPage.getValidationMessageTextOfEmailField(), "Укажите действительный адрес эл. почты");
        checkExpectedResult("Email section should be highlighted red color", registrationFormPage.isRedEmailSectionDisplayed());
        registrationFormPage.enterValidEmail();
        registrationFormPage.pressTabButton();
        checkExpectedResult("Email is not entered", registrationFormPage.getEmailValue(), "test@test.test");
        checkExpectedResult("Validation message should not be displayed", registrationFormPage.isValidationMessageOfEmailFieldDisplayed(), false);
        checkExpectedResult("Email section should not be highlighted red color", registrationFormPage.isNotRedEmailSectionDisplayed());
    }

    @Test
    @Description("TestCase_8: Make sure that validation is displayed if to clear email.")
    @Severity(SeverityLevel.NORMAL)
    public void makeSureThatValidationIsDisplayedAfterClearingEmailField() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.enterValidEmail();
        registrationFormPage.pressTabButton();
        checkExpectedResult("Email is not entered", registrationFormPage.getEmailValue(), "test@test.test");
        registrationFormPage.clearEmailField();
        checkExpectedResult("Validation message should be displayed", registrationFormPage.isValidationMessageOfEmailFieldDisplayed());
        checkExpectedResult("Inappropriate validation message displayed", registrationFormPage.getValidationMessageTextOfEmailField(), "Это обязательный вопрос.");
        checkExpectedResult("Email section should be highlighted red color", registrationFormPage.isRedEmailSectionDisplayed());
    }

    @Test
    @Description("TestCase_9: Make sure that placeholder is displayed in the email field")
    @Severity(SeverityLevel.MINOR)
    public void makeSureThatPlaceHolderIsDisplayedInEmailField() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        checkExpectedResult("Inappropriate placeholder displayed or placeholder is absent", registrationFormPage.getPlaceHolderOfEmailField(), "Ваш адрес эл. почты");
    }

    @Test
    @Description("TestCase_10: Make sure that email field's line is highlighted red color if validation is displayed")
    @Severity(SeverityLevel.MINOR)
    public void makeSureThatLineIsHighlightedRedColorIfValidationIsDisplayed() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.setCursorInEmailField();
        registrationFormPage.pressTabButton();
        checkExpectedResult("Email field's line has invalid color", registrationFormPage.getColorEmailFieldLine(), "#c5221f");
    }
}
