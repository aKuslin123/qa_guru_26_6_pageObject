package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        //убирает рекламу и банеры, чтобы не мешались
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Alexey");
        $("#lastName").setValue("Kuslin");
        $("#userEmail").setValue("Alexey@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("0123456789");

        //Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("1");
        $(".react-datepicker__year-select").selectOptionByValue("2000");
        $(".react-datepicker").$(byText("12")).click();

        //Subjects
        $("#subjectsContainer").click();
        actions().sendKeys("M").perform();
        $(".subjects-auto-complete__menu-list").$(byText("Maths")).click();

        //Hobbies
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        //Picture
        $("#uploadPicture").uploadFromClasspath("img.jpg");

        //Current Address
        $("#currentAddress").setValue("NCR Delhi 5");

        //State
        $("#state").click();
        $(byText("NCR")).click();

        //City
        $("#city").click();
        $(byText("Delhi")).click();

        $("#submit").click();

        //Check results
        $(byXpath("//div[contains(@class, 'modal-title')]")).shouldHave(text("Thanks for submitting the form"));
        $(byXpath("//td[text()='Student Name']/following-sibling::td")).shouldHave(text("Alexey Kuslin"));
        $(byXpath("//td[text()='Student Email']/following-sibling::td")).shouldHave(text("Alexey@mail.ru"));
        $(byXpath("//td[text()='Gender']/following-sibling::td")).shouldHave(text("Male"));
        $(byXpath("//td[text()='Mobile']/following-sibling::td")).shouldHave(text("0123456789"));
        $(byXpath("//td[text()='Date of Birth']/following-sibling::td")).shouldHave(text("12 February,2000"));
        $(byXpath("//td[text()='Subjects']/following-sibling::td")).shouldHave(text("Maths"));
        $(byXpath("//td[text()='Hobbies']/following-sibling::td")).shouldHave(text("Sports, Reading, Music"));
        $(byXpath("//td[text()='Picture']/following-sibling::td")).shouldHave(text("img.jpg"));
        $(byXpath("//td[text()='Address']/following-sibling::td")).shouldHave(text("NCR Delhi 5"));
        $(byXpath("//td[text()='State and City']/following-sibling::td")).shouldHave(text("NCR Delhi"));
    }
}
