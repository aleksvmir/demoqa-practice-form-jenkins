package guru.qa.tests;

import guru.qa.commonconfig.TestConfig;
import guru.qa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

public class TextBoxTest extends TestConfig {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void successfulFillingFormTest() {
        textBoxPage.openPage()
                .setName("Vladimir Alekseev")
                .setMail("aetirodev@gmail.com")
                .setCurrentAddress("Moscow, Leninsky Prospekt, 56-67")
                .setPermanentAddress("Almaty, Prospekt Abaya, 99-77")
                .submitForm()
                .checkResultBox("Name:", "Vladimir Alekseev")
                .checkResultBox("Email:", "aetirodev@gmail.com")
                .checkResultBox("Current Address :", "Moscow, Leninsky Prospekt, 56-67")
                .checkResultBox("Permananet Address :", "Almaty, Prospekt Abaya, 99-77");
    }
}