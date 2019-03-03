package registrationForm;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import libs.DateConverter;
import org.junit.Test;
import parentTest.ParentTest;

public class SubmitForm extends ParentTest {

    @Test
    @Description("TestCase_3: Make sure that user can submit form with the correct data")
    @Severity(SeverityLevel.CRITICAL)
    public void makeSureThatUserCanSubmitForm() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.enterValidEmail();
        registrationFormPage.enterBirthDate(DateConverter.getYesterdayDate());
        registrationFormPage.enterValidName();
        registrationFormPage.selectGender("Мужской");
        registrationFormPage.setStateOfMoodCheckBox("Нормально", "check");
        registrationFormPage.clickSendButton();
        formResponsePage.checkURL();
        checkExpectedResult("Form should be successfully submitted", formResponsePage.isSuccessfullyResponseDisplayed());
        checkExpectedResult("Inappropriate text is displayed in the form response", formResponsePage.getTextInAreaFormResponse(), "Форма регистрации\n" +
                "Ответ записан.\n" +
                "Отправить ещё один ответ");
    }

    @Test
    @Description("TestCase_36: Make sure that can navigate the form with using keyboard")
    @Severity(SeverityLevel.MINOR)
    public void makeSureThatCanNavigateTheFormWithUsingKeyboard() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.pressTabButton();
        registrationFormPage.enterValidEmail();
        registrationFormPage.pressTabButton();
        checkExpectedResult("Email is not entered or incorrect", registrationFormPage.getEmailValue(), "test@test.test");
        registrationFormPage.enterValidBirthDate();
        registrationFormPage.pressTabButton();
        checkExpectedResult("Birth date is not entered or incorrect", registrationFormPage.getBirthDateValue(), DateConverter.getYesterdayDate());
        registrationFormPage.enterValidName();
        registrationFormPage.pressTabButton();
        checkExpectedResult("Name is not entered or incorrect", registrationFormPage.getNameValue(), user.getName());
        registrationFormPage.pressDownButton();
        registrationFormPage.pressDownButton();
        registrationFormPage.pressEnterButton();
        checkExpectedResult("Male option is not selected", registrationFormPage.checkSelectedGender(), "Женский");
        registrationFormPage.pressTabButton();
        registrationFormPage.pressTabButton();
        registrationFormPage.pressSpaceButton();
        checkExpectedResult("'Хорошо' checkbox should be checked", registrationFormPage.isMoodOptionChecked("Хорошо", true));
        registrationFormPage.pressTabButton();
        registrationFormPage.pressTabButton();
        registrationFormPage.pressTabButton();
        registrationFormPage.pressTabButton();
        registrationFormPage.pressTabButton();
        registrationFormPage.pressTabButton();
        registrationFormPage.pressEnterButton();
        checkExpectedResult("Form should be successfully submitted", formResponsePage.isSuccessfullyResponseDisplayed());
        checkExpectedResult("Inappropriate text is displayed in the form response", formResponsePage.getTextInAreaFormResponse(), "Форма регистрации\n" +
                "Ответ записан.\n" +
                "Отправить ещё один ответ");
    }

    @Test
    @Description("TestCase_40: Make sure that can submit form with the several options from the «Как ваше настроение ?» section")
    @Severity(SeverityLevel.MINOR)
    public void makeSureThatCanSubmitFormWithSeveralOptions() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.enterValidEmail();
        registrationFormPage.enterValidBirthDate();
        registrationFormPage.enterValidName();
        registrationFormPage.selectGender("Мужской");
        registrationFormPage.setStateOfMoodCheckBox("Супер", "check");
        checkExpectedResult("'Супер' checkbox should be checked", registrationFormPage.isMoodOptionChecked("Супер", true));
        registrationFormPage.setStateOfMoodCheckBox("Нормально", "check");
        checkExpectedResult("'Нормально' checkbox should be checked", registrationFormPage.isMoodOptionChecked("Нормально", true));
        registrationFormPage.setStateOfMoodCheckBox("Плохо", "check");
        checkExpectedResult("'Плохо' checkbox should be checked", registrationFormPage.isMoodOptionChecked("Плохо", true));
        registrationFormPage.clickSendButton();
        checkExpectedResult("Form should be successfully submitted", formResponsePage.isSuccessfullyResponseDisplayed());
        checkExpectedResult("Inappropriate text is displayed in the form response", formResponsePage.getTextInAreaFormResponse(), "Форма регистрации\n" +
                "Ответ записан.\n" +
                "Отправить ещё один ответ");
    }

    @Test
    @Description("TestCase_41: Make sure that can submit form with all options from the «Как ваше настроение ?» section")
    @Severity(SeverityLevel.MINOR)
    public void makeSureThatCanSubmitFormWithAllOptions() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.enterValidEmail();
        registrationFormPage.enterValidBirthDate();
        registrationFormPage.enterValidName();
        registrationFormPage.selectGender("Мужской");
        registrationFormPage.setStateOfMoodCheckBox("Супер", "check");
        checkExpectedResult("'Супер' checkbox should be checked", registrationFormPage.isMoodOptionChecked("Супер", true));
        registrationFormPage.setStateOfMoodCheckBox("Хорошо", "check");
        checkExpectedResult("'Хорошо' checkbox should be checked", registrationFormPage.isMoodOptionChecked("Хорошо", true));
        registrationFormPage.setStateOfMoodCheckBox("Нормально", "check");
        checkExpectedResult("'Нормально' checkbox should be checked", registrationFormPage.isMoodOptionChecked("Нормально", true));
        registrationFormPage.setStateOfMoodCheckBox("Удовлетворительно", "check");
        checkExpectedResult("'Удовлетворительно' checkbox should be checked", registrationFormPage.isMoodOptionChecked("Удовлетворительно", true));
        registrationFormPage.setStateOfMoodCheckBox("Плохо", "check");
        checkExpectedResult("'Плохо' checkbox should be checked", registrationFormPage.isMoodOptionChecked("Плохо", true));
        registrationFormPage.setStateOfMoodCheckBox("Другое:", "check");
        checkExpectedResult("'Другое' checkbox should be checked", registrationFormPage.isMoodOptionChecked("Другое:", true));
        registrationFormPage.enterAnotherValue("Замечательно");
        registrationFormPage.clickSendButton();
        checkExpectedResult("Form should be successfully submitted", formResponsePage.isSuccessfullyResponseDisplayed());
        checkExpectedResult("Inappropriate text is displayed in the form response", formResponsePage.getTextInAreaFormResponse(), "Форма регистрации\n" +
                "Ответ записан.\n" +
                "Отправить ещё один ответ");
    }

    @Test
    @Description("TestCase_44: Verify that impossible submit form if required fields are not filled")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyThatImpossibleSubmitFormIfRequiredFieldsAreNotFilled() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.clickSendButton();
        checkExpectedResult("Validation message should be displayed", registrationFormPage.isValidationMessageOfEmailFieldDisplayed());
        checkExpectedResult("Validation message is not correct", registrationFormPage.getValidationMessageTextOfEmailField(), "Это обязательный вопрос.");
        checkExpectedResult("Email section should be highlighted red color", registrationFormPage.isRedEmailSectionDisplayed());
        checkExpectedResult("Validation message should be displayed", registrationFormPage.isValidationMessageOfBirthDateFieldDisplayed());
        checkExpectedResult("Validation message is not correct", registrationFormPage.getValidationMessageTextOfBirthDateField(), "Это обязательный вопрос.");
        checkExpectedResult("Birth date section should be highlighted red color", registrationFormPage.isRedBirthDateSectionDisplayed());
        checkExpectedResult("Validation message should be displayed", registrationFormPage.isValidationMessageOfNameFieldDisplayed());
        checkExpectedResult("Validation message is not correct", registrationFormPage.getValidationMessageTextOfNameField(), "Это обязательный вопрос.");
        checkExpectedResult("Name section should be highlighted red color", registrationFormPage.isRedNameSectionDisplayed());
        checkExpectedResult("Validation message should be displayed", registrationFormPage.isValidationMessageOfGenderFieldDisplayed());
        checkExpectedResult("Validation message is not correct", registrationFormPage.getValidationMessageTextOfGenderField(), "Это обязательный вопрос.");
        checkExpectedResult("Gender section should be highlighted red color", registrationFormPage.isRedGenderSectionDisplayed());
        checkExpectedResult("Validation message should be displayed", registrationFormPage.isValidationMessageOfMoodFieldDisplayed());
        checkExpectedResult("Validation message is not correct", registrationFormPage.getValidationMessageTextOfMoodSection(), "Это обязательный вопрос.");
        checkExpectedResult("Mood section should be highlighted red color", registrationFormPage.isRedMoodSectionDisplayed());
    }

    @Test
    @Description("TestCase_46: Make sure that quantity limits for fields in the DB the same as on the form")
    @Severity(SeverityLevel.CRITICAL)
    public void makeSureThatQuantityLimitsForFieldsInDBTheSameAsOnTheForm() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.enterEmail("Тест Тест Тест Тест Тест Тест Тест Тест Тест Тест Тест Тест Test Test @#$%");
        registrationFormPage.enterBirthDate("01.01.2000");
        registrationFormPage.enterName("Имя Name Имя Name Имя!@#");
        registrationFormPage.selectGender("Мужской");
        registrationFormPage.setStateOfMoodCheckBox("Супер", "check");
        registrationFormPage.setStateOfMoodCheckBox("Хорошо", "check");
        registrationFormPage.setStateOfMoodCheckBox("Нормально", "check");
        registrationFormPage.setStateOfMoodCheckBox("Удовлетворительно", "check");
        registrationFormPage.setStateOfMoodCheckBox("Плохо", "check");
        registrationFormPage.setStateOfMoodCheckBox("Другое", "check");
        registrationFormPage.enterAnotherValue("Testing Тестирование Testing Тестирование Testing Тестирование Testing Тестирование Testing Тестирование Testing Тестирование Testing " +
                "Тестирование Testing Тестирование Testing Тестирование Testing Тестирование Testing Тестирование Testing Тестирование Testing Тестирование Testing Тестирование Testing " +
                "Тестирование Testing Тестирование Testing Тестирование Testing Тестирование Testing Тестирование Testing Тестирование Testing Тестирование Testing Тестирование Testing " +
                "Тестирование Testing Тестирование Testing Тестирование Testing Тестирование Testing Тестирование Testing Тестирование Testing Тестирование Testing Тестирование " +
                "!\"№;%:?*()_+*/\\Ё`~}{[][[]78945");
        registrationFormPage.clickSendButton();
        formResponsePage.checkURL();
        checkExpectedResult("Form should be successfully submitted", formResponsePage.isSuccessfullyResponseDisplayed());
        checkExpectedResult("Inappropriate text is displayed in the form response", formResponsePage.getTextInAreaFormResponse(), "Форма регистрации\n" +
                "Ответ записан.\n" +
                "Отправить ещё один ответ");
    }
}


// NOTE: If there is access to DB need delete the record in the DB after tests run in this class
