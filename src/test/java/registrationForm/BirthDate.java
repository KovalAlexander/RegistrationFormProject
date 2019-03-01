package registrationForm;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import libs.DateConverter;
import org.junit.Test;
import parentTest.ParentTest;

public class BirthDate extends ParentTest {

    @Test
    @Description("TestCase_11: Make sure that can enter current date")
    @Severity(SeverityLevel.CRITICAL)
    public void makeSureThatCanEnterCurrentDate() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.enterBirthDate(DateConverter.getCurrentDate());
        registrationFormPage.pressTabButton();
        checkExpectedResult("Email is not entered", registrationFormPage.getBirthDateValue(), DateConverter.getCurrentDate());
        checkExpectedResult("Validation message should not be displayed", registrationFormPage.isValidationMessageOfBirthDateFieldDisplayed(), false);
        checkExpectedResult("Email section should not be highlighted red color", registrationFormPage.isNotRedBirthDateSectionDisplayed());
    }

    @Test
    @Description("TestCase_12: Make sure that can enter yesterday date")
    @Severity(SeverityLevel.CRITICAL)
    public void makeSureThatCanEnterYesterdayDate() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.enterBirthDate(DateConverter.getYesterdayDate());
        registrationFormPage.pressTabButton();
        checkExpectedResult("Email is not entered", registrationFormPage.getBirthDateValue(), DateConverter.getYesterdayDate());
        checkExpectedResult("Validation message should not be displayed", registrationFormPage.isValidationMessageOfBirthDateFieldDisplayed(), false);
        checkExpectedResult("Email section should not be highlighted red color", registrationFormPage.isNotRedBirthDateSectionDisplayed());
    }

    @Test
    @Description("TestCase_13: Make sure that impossible set tomorrow date")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("Bug_1")
    public void makeSureThatImpossibleSetTomorrowDate() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.enterBirthDate(DateConverter.getTomorrowDate());
        registrationFormPage.pressTabButton();
        checkExpectedResult("Email is not entered", registrationFormPage.getBirthDateValue(), DateConverter.getTomorrowDate());
        checkExpectedResult("Validation message should be displayed", registrationFormPage.isValidationMessageOfBirthDateFieldDisplayed());
        checkExpectedResult("Email section should be highlighted red color", registrationFormPage.isRedBirthDateSectionDisplayed());
    }

    @Test
    @Description("TestCase_14: Make sure that impossible set incorrect year")
    @Severity(SeverityLevel.NORMAL)
    @Issue("Bug_2")
    public void makeSureThatImpossibleSetIncorrectYear() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.enterBirthDate("02.02.19001");
        registrationFormPage.pressTabButton();
        checkExpectedResult("Email is not entered", registrationFormPage.getYearValue(), "1900");
    }

    @Test
    @Description("TestCase_15: Make sure that correct validation message displayed if enter incorrect date after required field validation")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("Bug_3")
    public void makeSureThatCorrectValidationMessageDisplayedIfEnterIncorrectDateAfterRequiredFieldValidation() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.clickSendButton();
        checkExpectedResult("Inappropriate validation message displayed", registrationFormPage.getValidationMessageTextOfBirthDateField(), "Это обязательный вопрос.");
        registrationFormPage.enterBirthDate("30.02.2005");
        registrationFormPage.pressTabButton();
        checkExpectedResult("Inappropriate validation message displayed", registrationFormPage.getValidationMessageTextOfBirthDateField(), "Недопустимая дата");
    }

    @Test
    @Description("TestCase_16: Verify that «Birth date» field is required for filling")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("Bug_4")
    public void verifyThatBirthDatefieldIsRequired() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.setCursorInBirthDateField();
        registrationFormPage.pressTabButton();
        registrationFormPage.pressTabButton();
        registrationFormPage.pressTabButton();
        checkExpectedResult("Validation message should be displayed", registrationFormPage.isValidationMessageOfBirthDateFieldDisplayed());
        checkExpectedResult("Inappropriate validation message displayed", registrationFormPage.getValidationMessageTextOfBirthDateField(), "Это обязательный вопрос.");
        checkExpectedResult("Birth date section should be highlighted red color", registrationFormPage.isRedBirthDateSectionDisplayed());
    }

    @Test
    @Description("TestCase_17: Verify of the validation message for incorrect date")
    @Severity(SeverityLevel.NORMAL)
    @Issue("Bug_5")
    public void verifyValidationMessageForIncorrectDate() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.enterBirthDate("30.02.2005");
        registrationFormPage.pressTabButton();
        checkExpectedResult("Validation message should be displayed", registrationFormPage.isValidationMessageOfBirthDateFieldDisplayed());
        checkExpectedResult("Inappropriate validation message displayed", registrationFormPage.getValidationMessageTextOfBirthDateField(), "Недопустимая дата");
        registrationFormPage.enterBirthDate("29.02.2005");
        registrationFormPage.pressTabButton();
        checkExpectedResult("Validation message should be displayed", registrationFormPage.isValidationMessageOfBirthDateFieldDisplayed());
        checkExpectedResult("Inappropriate validation message displayed", registrationFormPage.getValidationMessageTextOfBirthDateField(), "Недопустимая дата");
        registrationFormPage.enterBirthDate("31.09.2005");
        registrationFormPage.pressTabButton();
        checkExpectedResult("Validation message should be displayed", registrationFormPage.isValidationMessageOfBirthDateFieldDisplayed());
        checkExpectedResult("Inappropriate validation message displayed", registrationFormPage.getValidationMessageTextOfBirthDateField(), "Недопустимая дата");
    }

    @Test
    @Description("TestCase_18: Verify that validation is not displayed if not full date is entered")
    @Severity(SeverityLevel.MINOR)
    @Issue("Bug_6")
    public void verifyThatValidationMessageIsNotDisplayedIfNotFullDateIsEntered() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.enterBirthDate("29.02.200");
        checkExpectedResult("Validation message should not be displayed", registrationFormPage.isValidationMessageOfBirthDateFieldDisplayed(), false);
        checkExpectedResult("Inappropriate validation message displayed", registrationFormPage.isNotRedBirthDateSectionDisplayed());
    }

    @Test
    @Description("TestCase_19: Verify that validation is not displayed if enter 29th February with correct year")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyThatValidationIsNotDisplayedIfEnter29thFebWithCorrectYear() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.enterBirthDate("29.02.2016");
        registrationFormPage.pressTabButton();
        checkExpectedResult("Birth date is not entered or incorrect", registrationFormPage.getBirthDateValue(), "29.02.2016");
        checkExpectedResult("Validation message should not be displayed", registrationFormPage.isValidationMessageOfBirthDateFieldDisplayed(), false);
        checkExpectedResult("Inappropriate validation message displayed", registrationFormPage.isNotRedBirthDateSectionDisplayed());
        registrationFormPage.enterBirthDate("29.02.2012");
        registrationFormPage.pressTabButton();
        checkExpectedResult("Birth date is not entered or incorrect", registrationFormPage.getBirthDateValue(), "29.02.2012");
        checkExpectedResult("Validation message should not be displayed", registrationFormPage.isValidationMessageOfBirthDateFieldDisplayed(), false);
        checkExpectedResult("Inappropriate validation message displayed", registrationFormPage.isNotRedBirthDateSectionDisplayed());
        registrationFormPage.enterBirthDate("29.02.2008");
        registrationFormPage.pressTabButton();
        checkExpectedResult("Birth date is not entered or incorrect", registrationFormPage.getBirthDateValue(), "29.02.2008");
        checkExpectedResult("Validation message should not be displayed", registrationFormPage.isValidationMessageOfBirthDateFieldDisplayed(), false);
        checkExpectedResult("Inappropriate validation message displayed", registrationFormPage.isNotRedBirthDateSectionDisplayed());
    }

    @Test
    @Description("TestCase_20: Make sure that impossible enter letters in the birth date field")
    @Severity(SeverityLevel.CRITICAL)
    public void MakeSureThatImpossibleEnterlettersInBirthDateField() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.enterBirthDate("ф");
        registrationFormPage.moveFocusFromBirthDateField();
        checkExpectedResult("Birth date is not entered or incorrect", registrationFormPage.getBirthDate(), "");
        checkExpectedResult("Validation message should not be displayed", registrationFormPage.isValidationMessageOfBirthDateFieldDisplayed(), false);
        checkExpectedResult("Inappropriate validation message displayed", registrationFormPage.isNotRedBirthDateSectionDisplayed());
        registrationFormPage.enterBirthDate("в");
        registrationFormPage.moveFocusFromBirthDateField();
        checkExpectedResult("Birth date is not entered or incorrect", registrationFormPage.getBirthDate(), "");
        checkExpectedResult("Validation message should not be displayed", registrationFormPage.isValidationMessageOfBirthDateFieldDisplayed(), false);
        checkExpectedResult("Inappropriate validation message displayed", registrationFormPage.isNotRedBirthDateSectionDisplayed());
        registrationFormPage.enterBirthDate("q");
        registrationFormPage.moveFocusFromBirthDateField();
        checkExpectedResult("Birth date is not entered or incorrect", registrationFormPage.getBirthDate(), "");
        checkExpectedResult("Validation message should not be displayed", registrationFormPage.isValidationMessageOfBirthDateFieldDisplayed(), false);
        checkExpectedResult("Inappropriate validation message displayed", registrationFormPage.isNotRedBirthDateSectionDisplayed());
    }

    @Test
    @Description("TestCase_21: Make sure that impossible enter special symbol in the birth date field")
    @Severity(SeverityLevel.CRITICAL)
    public void makeSureThatImpossibleEnterSpecialSymbolInTheBirthDateField() {
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.enterBirthDate("+-&№\"'?:%/*=()$#@!~");
        registrationFormPage.moveFocusFromBirthDateField();
        checkExpectedResult("Birth date is not entered or incorrect", registrationFormPage.getBirthDate(), "");
        checkExpectedResult("Validation message should not be displayed", registrationFormPage.isValidationMessageOfBirthDateFieldDisplayed(), false);
        checkExpectedResult("Inappropriate validation message displayed", registrationFormPage.isNotRedBirthDateSectionDisplayed());
    }

    @Test
    @Description("TestCase_26: Varify that date mask is work during entering date")
    @Severity(SeverityLevel.MINOR)
    public void verifyThatDateMaskIsWorkDuringEnteringDate(){
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.enterBirthDate("03032001");
        registrationFormPage.pressTabButton();
        checkExpectedResult("Birth date is not entered or incorrect", registrationFormPage.getBirthDateValue(), "03.03.2001");
        checkExpectedResult("Validation message should not be displayed", registrationFormPage.isValidationMessageOfBirthDateFieldDisplayed(), false);
        checkExpectedResult("Inappropriate validation message displayed", registrationFormPage.isNotRedBirthDateSectionDisplayed());
    }
}
