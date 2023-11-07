package base.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TableWithResultComponent {
    private final static SelenideElement tableWithResult = $(".table-responsive");


    public void checkTable(String value) {
        tableWithResult.shouldHave(text("Student Name")).parent().shouldHave(text(value));
        tableWithResult.shouldHave(text("Student Email")).parent().shouldHave(text(value));
        tableWithResult.shouldHave(text("Gender")).parent().shouldHave(text(value));
        tableWithResult.shouldHave(text("Mobile")).parent().shouldHave(text(value));
        tableWithResult.shouldHave(text("Date of Birth")).parent().shouldHave(text(value));
        tableWithResult.shouldHave(text("Subjects")).parent().shouldHave(text(value));
        tableWithResult.shouldHave(text("Hobbies")).parent().shouldHave(text(value));
        tableWithResult.shouldHave(text("Address")).parent().shouldHave(text(value));
        tableWithResult.shouldHave(text("State and City")).parent().shouldHave(text(value));
    }
}
