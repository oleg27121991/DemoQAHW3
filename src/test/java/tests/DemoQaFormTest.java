package tests;

import pages.DemoqaFormPage;
import org.junit.jupiter.api.Test;


public class DemoQaFormTest extends BaseTest {
    DemoqaFormPage demoqaFormPage = new DemoqaFormPage();
    private final static String DEMO_QA_PRACTICE_FORM_URL = "https://demoqa.com/automation-practice-form",
            FIRST_NAME = "Oleg",
            SECOND_NAME = "Test",
            USER_EMAIL = "test@test.ru",
            USER_MOBILE_NUMBER = "1234567890",
            USER_GENDER = "Male",
            USER_BIRTHDAY_YEAR = "1991",
            USER_BIRTHDAY_MONTH = "December",
            USER_BIRTHDAY_DAY = "30",
            SUBJECTS = "English",
            FIRST_HOBBIES = "Sports",
            SECOND_HOBBIES = "Music",
            CURRENT_ADDRESS = "Some town near some street 221b",
            STATE = "NCR",
            CITY = "Delhi",

            // Label in table (key)
            STUDENT_NAME = "Student Name",
            STUDENT_EMAIL = "Student Email",
            STUDENT_GENDER = "Gender",
            STUDENT_MOBILE = "Mobile",
            STUDENT_BIRTH = "Date of Birth",
            STUDENT_SUBJECTS = "Subjects",
            STUDENT_HOBBIES = "Hobbies",
            STUDENT_ADDRESS = "Address",
            STUDENT_STATE_AND_CITY = "State and City",
            INVALID_CSS_NAME = "border-color",
            INVALID_CSS_VALUE = "rgb(220, 53, 69)";



    @Test
    void testEnteringCorrectDataIntoTheForm() {
        demoqaFormPage.openPage(DEMO_QA_PRACTICE_FORM_URL)
                .addUserFirstName(FIRST_NAME)
                .addUserLastName(SECOND_NAME)
                .addUserEmail(USER_EMAIL)
                .checkUserGender(USER_GENDER)
                .addUserPhone(USER_MOBILE_NUMBER)
                .setUserBirth(USER_BIRTHDAY_YEAR, USER_BIRTHDAY_MONTH, USER_BIRTHDAY_DAY)
                .selectSubjects(SUBJECTS)
                .selectHobbies(FIRST_HOBBIES)
                .selectHobbies(SECOND_HOBBIES)
                .choicePicture()
                .addCurrentAddress(CURRENT_ADDRESS)
                .choiceStateAndCity(STATE, CITY);

        demoqaFormPage.checkSubmittingForm(STUDENT_NAME, FIRST_NAME)
                .checkSubmittingForm(STUDENT_NAME, SECOND_NAME)
                .checkSubmittingForm(STUDENT_EMAIL, USER_EMAIL)
                .checkSubmittingForm(STUDENT_GENDER, USER_GENDER)
                .checkSubmittingForm(STUDENT_MOBILE, USER_MOBILE_NUMBER)
                .checkSubmittingForm(STUDENT_BIRTH, USER_BIRTHDAY_YEAR)
                .checkSubmittingForm(STUDENT_BIRTH, USER_BIRTHDAY_MONTH)
                .checkSubmittingForm(STUDENT_BIRTH, USER_BIRTHDAY_DAY)
                .checkSubmittingForm(STUDENT_SUBJECTS, SUBJECTS)
                .checkSubmittingForm(STUDENT_HOBBIES, FIRST_HOBBIES)
                .checkSubmittingForm(STUDENT_HOBBIES, SECOND_HOBBIES)
                .checkSubmittingForm(STUDENT_ADDRESS, CURRENT_ADDRESS)
                .checkSubmittingForm(STUDENT_STATE_AND_CITY, STATE)
                .checkSubmittingForm(STUDENT_STATE_AND_CITY, CITY);
    }

    @Test
    void testEnteringMinimumDataIntoTheForm() {
        demoqaFormPage.openPage(DEMO_QA_PRACTICE_FORM_URL)
                .addUserFirstName(FIRST_NAME)
                .addUserLastName(SECOND_NAME)
                .checkUserGender(USER_GENDER)
                .addUserPhone(USER_MOBILE_NUMBER)
                .sendForm();


        demoqaFormPage.checkSubmittingForm(STUDENT_NAME, FIRST_NAME)
                .checkSubmittingForm(STUDENT_GENDER, USER_GENDER)
                .checkSubmittingForm(STUDENT_MOBILE, USER_MOBILE_NUMBER);
    }

    @Test
    void testSendFormWithEmptyFields() {
        demoqaFormPage.openPage(DEMO_QA_PRACTICE_FORM_URL)
                .sendForm();

        demoqaFormPage.checkInputInvalidBorderColor(INVALID_CSS_NAME, INVALID_CSS_VALUE)
                .checkRadioInvalidBorderColor(INVALID_CSS_NAME, INVALID_CSS_VALUE);
    }
}
