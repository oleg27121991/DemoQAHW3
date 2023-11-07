package pages;
/**
 * Страница с тестом формы demoqa.com/automation-practice-form
 */

import base.components.CalendarComponent;
import base.components.TableWithResultComponent;
import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaFormPage {
    CalendarComponent calendar = new CalendarComponent();
    TableWithResultComponent table = new TableWithResultComponent();
    private final SelenideElement inputFirstName = $("#firstName"),
                            inputLastName = $("#lastName"),
                            inputUserEmail = $("#userEmail"),
                            radioMaleGender = $("label[for='gender-radio-1']"),
                            radioFemaleGender = $("label[for='gender-radio-2']"),
                            radioOtherGender = $("label[for='gender-radio-3']"),
                            inputUserNumber = $("#userNumber"),
                            inputCalendar = $("#dateOfBirthInput"),
                            inputSubjects = $("#subjectsInput"),
                            checkboxSportHobbies = $("label[for='hobbies-checkbox-1']"),
                            checkboxMusicHobbies = $("label[for='hobbies-checkbox-3']"),
                            inputUploadPicture = $("#uploadPicture"),
                            textAreaCurrentAddress = $("#currentAddress"),
                            selectState = $("#react-select-3-input"),
                            selectCity = $("#react-select-4-input"),
                            buttonSendForm = $("#submit");


    public DemoqaFormPage (String url) {
        Selenide.open(url);
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    public DemoqaFormPage addUserFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);

        return this;
    }

    public DemoqaFormPage addUserLastName(String lastName) {
        inputLastName.sendKeys(lastName);

        return this;
    }

    public DemoqaFormPage addUserEmail(String email) {
        inputUserEmail.sendKeys(email);

        return this;
    }

    public String getRadioFemaleGenderText() {
        return radioMaleGender.getText();
    }

    public DemoqaFormPage checkUserGender() {
        radioMaleGender.parent().click();

        return this;
    }

    public DemoqaFormPage addUserPhone(String phoneNumber) {
        inputUserNumber.sendKeys(phoneNumber);

        return this;
    }

    public DemoqaFormPage setUserBirth(String year, String mouth, String day){
        inputCalendar.click();
        calendar.setDate(year, mouth, day);
        return this;
    }

    public DemoqaFormPage choiceSubjects(String subjects) {
        inputSubjects.setValue(subjects);
        inputSubjects.pressEnter();

        return this;
    }

    public String getFirstHobbiesText() {
        return checkboxMusicHobbies.getText();
    }

    public String getSecondHobbiesText() {
        return checkboxSportHobbies.getText();
    }

    public DemoqaFormPage choiceHobbies() {
        checkboxMusicHobbies.parent().click();
        checkboxSportHobbies.parent().click();

        return this;
    }

    public DemoqaFormPage choicePicture() {
        inputUploadPicture.uploadFromClasspath("koshachii-yazik.jpg");

        return this;
    }

    public DemoqaFormPage addCurrentAddress(String address) {
        textAreaCurrentAddress.sendKeys(address);

        return this;
    }

    public DemoqaFormPage choiceStateAndCity(String state, String city) {
        selectState.setValue(state).scrollIntoView(true).pressEnter();
        selectCity.setValue(city).pressEnter();
        selectCity.pressEnter();

        return this;
    }

    public DemoqaFormPage sendForm() {
        buttonSendForm.scrollIntoView(true).click();

        return this;
    }

    public DemoqaFormPage checkResult(String value) {
        table.checkTable(value);

        return this;
    }

    public DemoqaFormPage checkInputInvalidBorderColor(String cssName, String cssValue) {
        inputFirstName.shouldHave(cssValue(cssName, cssValue));
        inputLastName.shouldHave(cssValue(cssName, cssValue));
        inputUserNumber.shouldHave(cssValue(cssName, cssValue));

        return this;
    }

    public DemoqaFormPage checkRadioInvalidBorderColor(String cssName, String cssValue) {
        radioMaleGender.shouldHave(cssValue(cssName, cssValue));
        radioMaleGender.shouldHave(pseudo(":before", cssName, cssValue));

        return  this;
    }
}
