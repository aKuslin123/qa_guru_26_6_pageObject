package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFullFormTest() {
        textBoxPage.openPage()
                .setUserName("Alex")
                .setEmail("alex@mail.ru")
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .pressSubmitButton();

        textBoxPage.checkResult("Name:", "Alex")
                .checkResult("Email:", "alex@mail.ru")
                .checkResult("Current Address :", "Some street 1")
                .checkResult("Permananet Address :", "Another street 1");
    }
}