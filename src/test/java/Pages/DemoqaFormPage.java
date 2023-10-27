package Pages; /**
 * Страница с тестом формы demoqa.com/automation-practice-form
 */

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;

public class DemoqaFormPage {
    private final SelenideElement inputFirstName = $("#firstName");
    private final SelenideElement inputLastName = $("#lastName");
    private final SelenideElement inputUserEmail = $("#userEmail");
    private final SelenideElement radioMaleGender = $("#gender-radio-1");
    private final SelenideElement radioFemaleGender = $("label[for='gender-radio-1']");
    private final SelenideElement radioOtherGender = $("#gender-radio-3");
    private final SelenideElement inputUserNumber = $("#userNumber");
    private final SelenideElement inputCalendar = $("#dateOfBirthInput");
    private final SelenideElement selectYearInCalendar = $(".react-datepicker__year-select");
    private final SelenideElement selectMonthInCalendar = $(".react-datepicker__month-select");
    private final SelenideElement divDatePickerDayInCalendar = $x("//div[contains(@class, 'react-datepicker__day') and contains(text(), '27')]");
    private final SelenideElement inputSubjects = $("#subjectsInput");
    private final SelenideElement checkboxSportHobbies = $("label[for='hobbies-checkbox-1']");
    private final SelenideElement checkboxMusicHobbies = $("label[for='hobbies-checkbox-3']");
    private final SelenideElement inputUploadPicture = $("#uploadPicture");
    private final SelenideElement textAreaCurrentAddress = $("#currentAddress");
    private final SelenideElement closeFixedban = $("#close-fixedban");
    private final SelenideElement selectState = $("#react-select-3-input");
    private final SelenideElement selectCity = $("#react-select-4-input");


    public DemoqaFormPage (String url) {
        Selenide.open(url);
    }

    public void addUserFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);
    }

    public void addUserLastName(String lastName) {
        inputLastName.sendKeys(lastName);
    }

    public void addUserEmail(String email) {
        inputUserEmail.sendKeys(email);
    }

    public String getRadioFemaleGenderText() {
        return radioFemaleGender.getText();
    }

    public void checkUserGender() {
        radioFemaleGender.parent().click();
    }

    public void addUserPhone(String phoneNumber) {
        inputUserNumber.sendKeys(phoneNumber);
    }

    public void choiceUserBirthday(String yearBirthday, String monthBirthday) {
        inputCalendar.click();
        selectYearInCalendar.selectOptionContainingText(yearBirthday);
        selectMonthInCalendar.selectOptionContainingText(monthBirthday);
        divDatePickerDayInCalendar.click();
    }

    public void choiceSubjects(String subjects) {
        inputSubjects.setValue(subjects);
        inputSubjects.pressEnter();
    }

    public String getFirstHobbiesText() {
        return checkboxMusicHobbies.getText();
    }

    public String getSecondHobbiesText() {
        return checkboxSportHobbies.getText();
    }

    public void choiceHobbies() {
        checkboxMusicHobbies.parent().click();
        checkboxSportHobbies.parent().click();
    }

    public void choicePicture() {
        inputUploadPicture.uploadFromClasspath("koshachii-yazik.jpg");
    }

    public void addCurrentAddress(String address) {
        textAreaCurrentAddress.sendKeys(address);
    }

    public void choiceStateAndCity(String state, String city) {
        closeFixedban.click();
        selectState.setValue(state).pressEnter();
        selectCity.setValue(city).pressEnter();
        selectCity.pressEnter();
    }
}
