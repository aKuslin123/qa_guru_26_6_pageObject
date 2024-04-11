package tests;

import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;

public class TestBase {

    @BeforeAll
    static void setUpConfig() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }
}
