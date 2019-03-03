package registrationForm;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import parentTest.ParentTest;

public class Gender extends ParentTest {

    @Test
    @Description("TestCase_31: Verify that gender field is required for filling")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("Bug_9")
    public void verifyThatGenderFieldIsRequired() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.setCursorInNameField();
        registrationFormPage.pressTabButton();
        registrationFormPage.pressTabButton();
        checkExpectedResult("Validation message should be displayed", registrationFormPage.isValidationMessageOfGenderFieldDisplayed());
        checkExpectedResult("Inappropriate validation message displayed", registrationFormPage.getValidationMessageTextOfGenderField(), "Это обязательный вопрос.");
        checkExpectedResult("Gender section should be highlighted red color", registrationFormPage.isRedGenderSectionDisplayed());
    }

    @Test
    @Description("TestCase_32: Verify that can select «Мужской» gender ")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyThatCanSelectMaleGender() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.selectGender("Мужской");
        checkExpectedResult("Male option is not selected", registrationFormPage.checkSelectedGender(), "Мужской");
    }

    @Test
    @Description("TestCase_33: Verify that can select «Женский» gender")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyThatCanSelectFemaleGender() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.selectGender("Женский");
        checkExpectedResult("Male option is not selected", registrationFormPage.checkSelectedGender(), "Женский");
    }

    @Test
    @Description("TestCase_34: Verify that can unselect gender")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyThatCanUnSelectFemaleGender() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.selectGender("Мужской");
        checkExpectedResult("Male option is not selected", registrationFormPage.checkSelectedGender(), "Мужской");
        registrationFormPage.selectGender("Выбрать");
        checkExpectedResult("Select option is not selected", registrationFormPage.checkSelectedGender(), "Выбрать");
        checkExpectedResult("Validation message should be displayed", registrationFormPage.isValidationMessageOfGenderFieldDisplayed());
        checkExpectedResult("Inappropriate validation message displayed", registrationFormPage.getValidationMessageTextOfGenderField(), "Это обязательный вопрос.");
        checkExpectedResult("Gender section should be highlighted rec color", registrationFormPage.isRedGenderSectionDisplayed());
        registrationFormPage.selectGender("Женский");
        checkExpectedResult("Female option is not selected", registrationFormPage.checkSelectedGender(), "Женский");
        registrationFormPage.selectGender("Выбрать");
        checkExpectedResult("Select option is not selected", registrationFormPage.checkSelectedGender(), "Выбрать");
        checkExpectedResult("Validation message should be displayed", registrationFormPage.isValidationMessageOfGenderFieldDisplayed());
        checkExpectedResult("Inappropriate validation message displayed", registrationFormPage.getValidationMessageTextOfGenderField(), "Это обязательный вопрос.");
        checkExpectedResult("Gender section should be highlighted rec color", registrationFormPage.isRedGenderSectionDisplayed());
    }

    @Test
    @Description("TestCase_35: Make sure that validation disappears after selecting gender")
    @Severity(SeverityLevel.CRITICAL)
    public void makeSureThatValidationDisappearsAfterSelectingGender() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.clickSendButton();
        checkExpectedResult("Validation message should be displayed", registrationFormPage.isValidationMessageOfGenderFieldDisplayed());
        checkExpectedResult("Gender section should be highlighted red color", registrationFormPage.isRedGenderSectionDisplayed());
        registrationFormPage.selectGender("Женский");
        checkExpectedResult("Validation message should not be displayed", registrationFormPage.isValidationMessageOfGenderFieldDisplayed(), false);
        checkExpectedResult("Gender section should not be highlighted red color", registrationFormPage.isNotRedGenderSectionDisplayed());
    }
}
