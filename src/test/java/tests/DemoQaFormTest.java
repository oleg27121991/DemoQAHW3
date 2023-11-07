package tests;

import base.BaseTest;
import pages.DemoqaFormPage;
import org.junit.jupiter.api.Test;


public class DemoQaFormTest extends BaseTest {
    private final static String DEMO_QA_PRACTICE_FORM_URL = "https://demoqa.com/automation-practice-form",
            FIRST_NAME = "Oleg",
            SECOND_NAME = "Test",
            USER_EMAIL = "test@test.ru",
            USER_MOBILE_NUMBER = "1234567890",
            USER_BIRTHDAY_YEAR = "1991",
            USER_BIRTHDAY_MONTH = "December",
            USER_BIRTHDAY_DAY = "30",
            SUBJECTS = "English",
            CURRENT_ADDRESS = "Some town near some street 221b",
            STATE = "NCR",
            CITY = "Delhi",


            INVALID_CSS_NAME = "border-color",
            INVALID_CSS_VALUE = "rgb(220, 53, 69)";



    @Test
    void testEnteringCorrectDataIntoTheForm() {
        DemoqaFormPage demoqaFormPage = new DemoqaFormPage(DEMO_QA_PRACTICE_FORM_URL)
                .addUserFirstName(FIRST_NAME)
                .addUserLastName(SECOND_NAME)
                .addUserEmail(USER_EMAIL)
                .checkUserGender()
                .addUserPhone(USER_MOBILE_NUMBER)
                .setUserBirth(USER_BIRTHDAY_YEAR, USER_BIRTHDAY_MONTH, USER_BIRTHDAY_DAY)
                .choiceSubjects(SUBJECTS)
                .choiceHobbies()
                .choicePicture()
                .addCurrentAddress(CURRENT_ADDRESS)
                .choiceStateAndCity(STATE, CITY);
        String genderText = demoqaFormPage.getRadioFemaleGenderText();
        String firstHobbiesText = demoqaFormPage.getFirstHobbiesText();
        String secondHobbiesText = demoqaFormPage.getSecondHobbiesText();

        demoqaFormPage.checkResult(FIRST_NAME)
                .checkResult(SECOND_NAME)
                .checkResult(USER_EMAIL)
                .checkResult(genderText)
                .checkResult(USER_MOBILE_NUMBER)
                .checkResult(USER_BIRTHDAY_YEAR)
                .checkResult(USER_BIRTHDAY_MONTH)
                .checkResult(USER_BIRTHDAY_DAY)
                .checkResult(SUBJECTS)
                .checkResult(firstHobbiesText)
                .checkResult(secondHobbiesText)
                .checkResult(CURRENT_ADDRESS)
                .checkResult(STATE)
                .checkResult(CITY);
    }

    @Test
    void testEnteringMinimumDataIntoTheForm() {
        DemoqaFormPage demoqaFormPage = new DemoqaFormPage(DEMO_QA_PRACTICE_FORM_URL)
                .addUserFirstName(FIRST_NAME)
                .addUserLastName(SECOND_NAME)
                .checkUserGender()
                .addUserPhone(USER_MOBILE_NUMBER)
                .sendForm();
        String genderText = demoqaFormPage.getRadioFemaleGenderText();

        demoqaFormPage.checkResult(FIRST_NAME)
                .checkResult(SECOND_NAME)
                .checkResult(genderText)
                .checkResult(USER_MOBILE_NUMBER);
    }

    @Test
    void testSendFormWithEmptyFields() {
        DemoqaFormPage demoqaFormPage = new DemoqaFormPage(DEMO_QA_PRACTICE_FORM_URL)
                .sendForm();

        demoqaFormPage.checkInputInvalidBorderColor(INVALID_CSS_NAME, INVALID_CSS_VALUE)
                .checkRadioInvalidBorderColor(INVALID_CSS_NAME, INVALID_CSS_VALUE);
    }
}
