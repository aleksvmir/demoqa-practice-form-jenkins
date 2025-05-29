package guru.qa.tests;

import guru.qa.commonconfig.TestConfig;
import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$$;

public class RegistrationFormTest extends TestConfig {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormWithAllDataTest() {
        registrationPage.openPage()
                .setFirstName("Vladimir")
                .setLastName("Alekseev")
                .setEmail("aetirodev@gmail.com")
                .selectGender("Male")
                .setPhoneNumber("9001112233")
                .setDateOfBirth("8", "February", "2000")
                .setSubjects("History")
                .selectHobby("Reading")
                .uploadPicture("photo.png")
                .setAddress("Moscow, Leninsky Prospekt, 56-67")
                .selectState("Haryana")
                .selectCity("Karnal")
                .submitForm();
        registrationPage.checkResultTable()
                .verifyResult("Student Name", "Vladimir Alekseev")
                .verifyResult("Student Email", "aetirodev@gmail.com")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "9001112233")
                .verifyResult("Date of Birth", "8 February,2000")
                .verifyResult("Subjects", "History")
                .verifyResult("Hobbies", "Reading")
                .verifyResult("Picture", "photo.png")
                .verifyResult("Address", "Moscow, Leninsky Prospekt, 56-67")
                .verifyResult("State and City", "Haryana Karnal");
    }

    @Test
    void fillFormMinimalRequiredDataTest() {
        registrationPage.openPage()
                .setFirstName("Vladimir")
                .setLastName("Alekseev")
                .selectGender("Male")
                .setPhoneNumber("9001112233")
                .submitForm();
        registrationPage.checkResultTable()
                .verifyResult("Student Name", "Vladimir Alekseev")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "9001112233");
    }

    @Test
    void fillFormNegativeTest() {
        registrationPage.openPage()
                .submitForm();
        $$(".modal-content").shouldHave(size(0));
    }
}