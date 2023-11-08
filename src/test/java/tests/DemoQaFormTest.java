package tests;

import data.TestData;
import pages.DemoqaFormPage;
import org.junit.jupiter.api.Test;


public class DemoQaFormTest extends BaseTest {
    DemoqaFormPage demoqaFormPage = new DemoqaFormPage();
    TestData data = new TestData();
    private final static String DEMO_QA_PRACTICE_FORM_URL = "/automation-practice-form",

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
                .addUserFirstName(data.firstName)
                .addUserLastName(data.lastName)
                .addUserEmail(data.email)
                .checkUserGender(data.gender)
                .addUserPhone(data.phoneNumber)
                .setUserBirth(data.yearBirth, data.month, data.dayOfBirth)
                .selectSubjects(data.subjects)
                .selectHobbies(data.hobbies)
                .choicePicture("1.jpg")
                .addCurrentAddress(data.currentAddress)
                .choiceStateAndCity(data.state, data.city);

        demoqaFormPage.checkSubmittingForm(STUDENT_NAME, data.firstName)
                .checkSubmittingForm(STUDENT_NAME, data.lastName)
                .checkSubmittingForm(STUDENT_EMAIL, data.email)
                .checkSubmittingForm(STUDENT_GENDER, data.gender)
                .checkSubmittingForm(STUDENT_MOBILE, data.phoneNumber)
                .checkSubmittingForm(STUDENT_BIRTH, data.yearBirth)
                .checkSubmittingForm(STUDENT_BIRTH, data.month)
                .checkSubmittingForm(STUDENT_BIRTH, data.dayOfBirth)
                .checkSubmittingForm(STUDENT_SUBJECTS, data.subjects)
                .checkSubmittingForm(STUDENT_HOBBIES, data.hobbies)
                .checkSubmittingForm(STUDENT_ADDRESS, data.currentAddress)
                .checkSubmittingForm(STUDENT_STATE_AND_CITY, data.state)
                .checkSubmittingForm(STUDENT_STATE_AND_CITY, data.city);
    }

    @Test
    void testEnteringMinimumDataIntoTheForm() {
        demoqaFormPage.openPage(DEMO_QA_PRACTICE_FORM_URL)
                .addUserFirstName(data.firstName)
                .addUserLastName(data.lastName)
                .checkUserGender(data.gender)
                .addUserPhone(data.phoneNumber)
                .sendForm();


        demoqaFormPage.checkSubmittingForm(STUDENT_NAME, data.firstName)
                .checkSubmittingForm(STUDENT_NAME, data.lastName)
                .checkSubmittingForm(STUDENT_GENDER, data.gender)
                .checkSubmittingForm(STUDENT_MOBILE, data.phoneNumber);
    }

    @Test
    void testSendFormWithEmptyFields() {
        demoqaFormPage.openPage(DEMO_QA_PRACTICE_FORM_URL)
                .sendForm();

        demoqaFormPage.checkInputInvalidBorderColor(INVALID_CSS_NAME, INVALID_CSS_VALUE)
                .checkRadioInvalidBorderColor(INVALID_CSS_NAME, INVALID_CSS_VALUE);
    }
}
