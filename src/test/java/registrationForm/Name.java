package registrationForm;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import parentTest.ParentTest;

public class Name extends ParentTest {

    @Test
    @Description("TestCase_27: Verify that validation is not displayed if entered name included 20 and less symbols")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("Bug_7")
    public void verifyThatValidationIsNotDisplayedIfEnteredNameIncluded20AndLessSymbols() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.enterName("Влласова-Дячеенк4321");
        checkExpectedResult("Validation message should not be displayed", registrationFormPage.isValidationMessageOfNameFieldDisplayed(), false);
        checkExpectedResult("Name section should not be highlighted red color", registrationFormPage.isNotRedNameSectionDisplayed());
        registrationFormPage.enterName("ВлаСовІ-ДячееНковва");
        checkExpectedResult("Validation message should not be displayed", registrationFormPage.isValidationMessageOfNameFieldDisplayed(), false);
        checkExpectedResult("Name section should not be highlighted red color", registrationFormPage.isNotRedNameSectionDisplayed());
        registrationFormPage.enterName("Test");
        checkExpectedResult("Validation message should not be displayed", registrationFormPage.isValidationMessageOfNameFieldDisplayed(), false);
        checkExpectedResult("Name section should not be highlighted red color", registrationFormPage.isNotRedNameSectionDisplayed());
        registrationFormPage.enterName("TESTING");
        checkExpectedResult("Validation message should not be displayed", registrationFormPage.isValidationMessageOfNameFieldDisplayed(), false);
        checkExpectedResult("Name section should not be highlighted red color", registrationFormPage.isNotRedNameSectionDisplayed());
        registrationFormPage.enterName("-+:!#$ %&*/=?^_{|}");
        checkExpectedResult("Validation message should not be displayed", registrationFormPage.isValidationMessageOfNameFieldDisplayed(), false);
        checkExpectedResult("Name section should not be highlighted red color", registrationFormPage.isNotRedNameSectionDisplayed());
        registrationFormPage.enterName("0");
        checkExpectedResult("Validation message should not be displayed", registrationFormPage.isValidationMessageOfNameFieldDisplayed(), false);
        checkExpectedResult("Name section should not be highlighted red color", registrationFormPage.isNotRedNameSectionDisplayed());
    }

    @Test
    @Description("TestCase_28: Verify that validation is displayed if entered name included 21 symbols")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyThatValidationIsDisplayedIfEnteredNameincluded21symbols() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.enterName("Вллассова-Дячеенковва");
        checkExpectedResult("Validation message should be displayed", registrationFormPage.isValidationMessageOfNameFieldDisplayed());
        checkExpectedResult("Inappropriate validation message displayed", registrationFormPage.getValidationMessageTextOfNameField(), "Максимальное количество символов 20 превышено");
        checkExpectedResult("Name section should not be highlighted red color", registrationFormPage.isRedNameSectionDisplayed());
    }

    @Test
    @Description("TestCase_29: Verify that name field is required for filling")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyThatNameFieldIsRequired() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.setCursorInNameField();
        registrationFormPage.pressTabButton();
        checkExpectedResult("Validation message should be displayed", registrationFormPage.isValidationMessageOfNameFieldDisplayed());
        checkExpectedResult("Inappropriate validation message displayed", registrationFormPage.getValidationMessageTextOfNameField(), "Это обязательный вопрос.");
        checkExpectedResult("Name section should not be highlighted red color", registrationFormPage.isRedNameSectionDisplayed());
    }

    @Test
    @Description("TestCase_30: Verify that validation is not displayed if to chancge icorrect name to correct one")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("Bug_8")
    public void verifyThatValidationIsNotDisplayedIfChangeIncorrectNameToCorrect() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.enterName("Вллассова-Дячеенковва");
        checkExpectedResult("Validation message should be displayed", registrationFormPage.isValidationMessageOfNameFieldDisplayed());
        checkExpectedResult("Inappropriate validation message displayed", registrationFormPage.getValidationMessageTextOfNameField(), "Максимальное количество символов 20 превышено");
        checkExpectedResult("Name section should not be highlighted red color", registrationFormPage.isRedNameSectionDisplayed());
        registrationFormPage.pressBackSpaceButton();
        checkExpectedResult("Validation message should not be displayed", registrationFormPage.isValidationMessageOfNameFieldDisplayed(), false);
        checkExpectedResult("Name section should not be highlighted red color", registrationFormPage.isNotRedNameSectionDisplayed());
    }
}
