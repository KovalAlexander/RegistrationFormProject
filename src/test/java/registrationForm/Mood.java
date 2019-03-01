package registrationForm;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import parentTest.ParentTest;

public class Mood extends ParentTest {

    @Test
    @Description("TestCase_37: Make sure that can check/unchek one option in the «Как ваше настроение ?» section")
    @Severity(SeverityLevel.CRITICAL)
    public void makeSureThatCanCheckUnCheckOneOption() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.setStateOfMoodCheckBox("Хорошо", "check");
        checkExpectedResult("'Хорошо' checkbox should be checked", registrationFormPage.isMoodOptionChecked("Хорошо", true));
        registrationFormPage.setStateOfMoodCheckBox("Хорошо", "uncheck");
        checkExpectedResult("'Хорошо' checkbox should not be checked", registrationFormPage.isMoodOptionChecked("Хорошо", false));
    }

    @Test
    @Description("TestCase_38: Make sure that can check/uncheck several options in the «Как ваше настроение ?» section")
    @Severity(SeverityLevel.MINOR)
    public void makeSureThatCanCheckUnCheckSeveralOption(){
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.setStateOfMoodCheckBox("Супер", "check");
        checkExpectedResult("'Супер' checkbox should be checked", registrationFormPage.isMoodOptionChecked("Супер", true));
        registrationFormPage.setStateOfMoodCheckBox("Нормально", "check");
        checkExpectedResult("'Нормально' checkbox should be checked", registrationFormPage.isMoodOptionChecked("Нормально", true));
        registrationFormPage.setStateOfMoodCheckBox("Плохо", "check");
        checkExpectedResult("'Плохо' checkbox should be checked", registrationFormPage.isMoodOptionChecked("Плохо", true));
        registrationFormPage.setStateOfMoodCheckBox("Супер", "check");
        checkExpectedResult("'Супер' checkbox should not be checked", registrationFormPage.isMoodOptionChecked("Супер", false));
        registrationFormPage.setStateOfMoodCheckBox("Нормально", "check");
        checkExpectedResult("'Нормально' checkbox should not be checked", registrationFormPage.isMoodOptionChecked("Нормально", false));
        registrationFormPage.setStateOfMoodCheckBox("Плохо", "check");
        checkExpectedResult("'Плохо' checkbox should not be checked", registrationFormPage.isMoodOptionChecked("Плохо", false));
    }

    @Test
    @Description("TestCase_39: Make sure that can check/uncheck all options in the «Как ваше настроение ?» section")
    @Severity(SeverityLevel.MINOR)
    public void makeSureThatCanCheckUnCheckAllOption(){
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.setStateOfMoodCheckBox("Супер", "check");
        checkExpectedResult("'Супер' checkbox should be checked", registrationFormPage.isMoodOptionChecked("Супер", true));
        registrationFormPage.setStateOfMoodCheckBox("Нормально", "check");
        checkExpectedResult("'Нормально' checkbox should be checked", registrationFormPage.isMoodOptionChecked("Нормально", true));
        registrationFormPage.setStateOfMoodCheckBox("Плохо", "check");
        checkExpectedResult("'Плохо' checkbox should be checked", registrationFormPage.isMoodOptionChecked("Плохо", true));
        registrationFormPage.setStateOfMoodCheckBox("Хорошо", "check");
        checkExpectedResult("'Хорошо' checkbox should be checked", registrationFormPage.isMoodOptionChecked("Хорошо", true));
        registrationFormPage.setStateOfMoodCheckBox("Удовлетворительно", "check");
        checkExpectedResult("'Удовлетворительно' checkbox should be checked", registrationFormPage.isMoodOptionChecked("Удовлетворительно", true));
        registrationFormPage.setStateOfMoodCheckBox("Другое:", "check");
        checkExpectedResult("'Другое' checkbox should be checked", registrationFormPage.isMoodOptionChecked("Другое:", true));
        registrationFormPage.setStateOfMoodCheckBox("Супер", "check");
        checkExpectedResult("'Супер' checkbox should not be checked", registrationFormPage.isMoodOptionChecked("Супер", false));
        registrationFormPage.setStateOfMoodCheckBox("Нормально", "check");
        checkExpectedResult("'Нормально' checkbox should not be checked", registrationFormPage.isMoodOptionChecked("Нормально", false));
        registrationFormPage.setStateOfMoodCheckBox("Плохо", "check");
        checkExpectedResult("'Плохо' checkbox should not be checked", registrationFormPage.isMoodOptionChecked("Плохо", false));
        registrationFormPage.setStateOfMoodCheckBox("Хорошо", "check");
        checkExpectedResult("'Хорошо' checkbox should not be checked", registrationFormPage.isMoodOptionChecked("Хорошо", false));
        registrationFormPage.setStateOfMoodCheckBox("Удовлетворительно", "check");
        checkExpectedResult("'Удовлетворительно' checkbox should not be checked", registrationFormPage.isMoodOptionChecked("Удовлетворительно", false));
        registrationFormPage.setStateOfMoodCheckBox("Другое:", "check");
        checkExpectedResult("'Другое' checkbox should not be checked", registrationFormPage.isMoodOptionChecked("Другое:", false));
    }

    @Test
    @Description("TestCase_42: Verify that «Другое» field is required for filling if selected")
    @Severity(SeverityLevel.NORMAL)
    public void verifyThatAnotherFieldIsRequired(){
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.setStateOfMoodCheckBox("Другое:", "check");
        checkExpectedResult("'Другое' checkbox should be checked", registrationFormPage.isMoodOptionChecked("Другое:", true));
        checkExpectedResult("Validation message should be displayed", registrationFormPage.isValidationMessageOfAnotherFieldDisplayed());
        checkExpectedResult("Validation message is not correct", registrationFormPage.getValidationMessageTextOfMoodSection(), "Это обязательный вопрос.");
        checkExpectedResult("Mood section should be highlighted red color", registrationFormPage.isRedMoodSectionDisplayed());
    }

    @Test
    @Description("TestCase_43: Verify that validation is not displayed if entered «Другое» value")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyThatValidationIsNotDisplayedIfEnteredAnotherValue(){
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.setStateOfMoodCheckBox("Другое:", "check");
        checkExpectedResult("'Другое' checkbox should be checked", registrationFormPage.isMoodOptionChecked("Другое:", true));
        checkExpectedResult("Validation message should not be displayed", registrationFormPage.isValidationMessageOfAnotherFieldDisplayed());
        checkExpectedResult("Validation message is not correct", registrationFormPage.getValidationMessageTextOfMoodSection(), "Это обязательный вопрос.");
        checkExpectedResult("Mood section should not be highlighted red color", registrationFormPage.isRedMoodSectionDisplayed());
        registrationFormPage.enterAnotherValue("Влласова-Дячеенк4321");
        checkExpectedResult("Validation message should not be displayed", registrationFormPage.isValidationMessageOfAnotherFieldDisplayed(), false);
        checkExpectedResult("Mood section should not be highlighted red color", registrationFormPage.isNotRedMoodSectionDisplayed());
        registrationFormPage.changeAnotherValue("ВлаСовІ-ДячееНковва");
        checkExpectedResult("Validation message should not be displayed", registrationFormPage.isValidationMessageOfAnotherFieldDisplayed(), false);
        checkExpectedResult("Mood section should not be highlighted red color", registrationFormPage.isNotRedMoodSectionDisplayed());
        registrationFormPage.changeAnotherValue("Test");
        checkExpectedResult("Validation message should not be displayed", registrationFormPage.isValidationMessageOfAnotherFieldDisplayed(), false);
        checkExpectedResult("Mood section should not be highlighted red color", registrationFormPage.isNotRedMoodSectionDisplayed());
        registrationFormPage.changeAnotherValue("TESTING");
        checkExpectedResult("Validation message should not be displayed", registrationFormPage.isValidationMessageOfAnotherFieldDisplayed(), false);
        checkExpectedResult("Mood section should not be highlighted red color", registrationFormPage.isNotRedMoodSectionDisplayed());
        registrationFormPage.changeAnotherValue("\" - + : ! # $ % & * / = ? ^ _ { | } ~");
        checkExpectedResult("Validation message should not be displayed", registrationFormPage.isValidationMessageOfAnotherFieldDisplayed(), false);
        checkExpectedResult("Mood section should not be highlighted red color", registrationFormPage.isNotRedMoodSectionDisplayed());
        registrationFormPage.changeAnotherValue("T");
        checkExpectedResult("Validation message should be displayed", registrationFormPage.isValidationMessageOfAnotherFieldDisplayed(), false);
        checkExpectedResult("Mood section should be highlighted red color", registrationFormPage.isNotRedMoodSectionDisplayed());
        registrationFormPage.changeAnotherValue("0");
        checkExpectedResult("Validation message should be displayed", registrationFormPage.isValidationMessageOfAnotherFieldDisplayed(), false);
        checkExpectedResult("Mood section should be highlighted red color", registrationFormPage.isNotRedMoodSectionDisplayed());
    }
}
