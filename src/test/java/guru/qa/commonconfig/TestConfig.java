package guru.qa.commonconfig;

import com.codeborne.selenide.Configuration;
import guru.qa.helpers.Attachments;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import static com.codeborne.selenide.Selenide.executeJavaScript;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class TestConfig {

    @BeforeAll
    static void configureBrowser() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        Configuration.browserCapabilities = new DesiredCapabilities();
        Configuration.browserCapabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.pageLoadTimeout = 60000;
    }

    @BeforeEach
    void removeBanners() {
        executeJavaScript(
                "document.getElementById('fixedban').remove();" +
                        "document.querySelector('footer').remove();"
        );
    }

    @AfterEach
    void addAttachments() {
        Attachments.addScreenshot();
        Attachments.addPageSource();
        Attachments.addConsoleLogs();
        Attachments.addVideo();
    }

    @AfterAll
    static void closeBrowser() {
        closeWebDriver();
    }
}