package registrationForm;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import parentTest.ParentTest;

public class FormResponse extends ParentTest {

    @Test
    @Description("TestCase_48: Verify content of the area form response")
    @Severity(SeverityLevel.NORMAL)
    public void verifyContentOfTheFormResponseArea(){
        registrationFormPage.openRegistrationForm();
        registrationFormPage.checkURL();
        registrationFormPage.submitForm();
        checkExpectedResult("Inappropriate text is displayed in the form response", formResponsePage.getTextInAreaFormResponse(), "Форма регистрации\n" +
                "Ответ записан.\n" +
                "Отправить ещё один ответ");
        checkExpectedResult("'Send one more response' is not link", formResponsePage.checkThatSendOneMoreResponseIsLink(), true);
    }
}
