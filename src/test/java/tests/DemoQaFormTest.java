package tests;

import base.BaseTest;
import pages.DemoqaFormPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class DemoQaFormTest extends BaseTest {
    private final static String DEMO_QA_PRACTICE_FORM_URL = "https://demoqa.com/automation-practice-form";
    private final static String FIRST_NAME = "Oleg";
    private final static String SECOND_NAME = "Test";
    private final static String USER_EMAIL = "test@test.ru";
    private final static String USER_MOBILE_NUMBER = "1234567890";
    private final static String USER_BIRTHDAY_YEAR = "1991";
    private final static String USER_BIRTHDAY_MONTH = "December";
    private final static String SUBJECTS = "English";
    private final static String CURRENT_ADDRESS = "Some town near some street 221b";
    private final static String STATE = "NCR";
    private final static String CITY = "Delhi";

    @Test
    void testEnteringCorrectDataIntoTheForm() {
        DemoqaFormPage demoqaFormPage = new DemoqaFormPage(DEMO_QA_PRACTICE_FORM_URL);
        demoqaFormPage.addUserFirstName(FIRST_NAME);
        demoqaFormPage.addUserLastName(SECOND_NAME);
        demoqaFormPage.addUserEmail(USER_EMAIL);
        String genderText = demoqaFormPage.getRadioFemaleGenderText();
        demoqaFormPage.checkUserGender();
        demoqaFormPage.addUserPhone(USER_MOBILE_NUMBER);
        demoqaFormPage.choiceUserBirthday(USER_BIRTHDAY_YEAR, USER_BIRTHDAY_MONTH);
        demoqaFormPage.choiceSubjects(SUBJECTS);
        String firstHobbiesText = demoqaFormPage.getFirstHobbiesText();
        String secondHobbiesText = demoqaFormPage.getSecondHobbiesText();
        demoqaFormPage.choiceHobbies();
        demoqaFormPage.choicePicture();
        demoqaFormPage.addCurrentAddress(CURRENT_ADDRESS);
        demoqaFormPage.choiceStateAndCity(STATE, CITY);

        $(".table-responsive").shouldHave(text(FIRST_NAME))
                .shouldHave(text(SECOND_NAME))
                .shouldHave(text(USER_EMAIL))
                .shouldHave(text(genderText))
                .shouldHave(text(USER_MOBILE_NUMBER))
                .shouldHave(text(USER_BIRTHDAY_YEAR))
                .shouldHave(text(USER_BIRTHDAY_MONTH))
                .shouldHave(text(SUBJECTS))
                .shouldHave(text(firstHobbiesText))
                .shouldHave(text(secondHobbiesText))
                .shouldHave(text(CURRENT_ADDRESS))
                .shouldHave(text(STATE))
                .shouldHave(text(CITY));
    }
}
