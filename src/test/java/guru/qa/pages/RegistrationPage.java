package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;
import guru.qa.pages.components.CheckResultComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final CalendarComponent calendar = new CalendarComponent();

    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateDropdown = $("#state"),
            cityDropdown = $("#city"),
            submitButton = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        removeAllAds();

        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage selectGender(String gender) {
        $(byText(gender)).click();
        return this;
    }

    public RegistrationPage setPhoneNumber(String number) {
        userNumberInput.setValue(number);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage selectHobby(String hobby) {
        $(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String fileName) {
        uploadPictureInput.uploadFile(new File("src/test/resources/" + fileName));
        return this;
    }

    public RegistrationPage setAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public RegistrationPage selectState(String state) {
        stateDropdown.shouldBe(visible).scrollTo().click();
        $(byText(state)).shouldBe(visible).click();
        return this;
    }

    public RegistrationPage selectCity(String city) {
        cityDropdown.shouldBe(visible).scrollTo().click();
        $(byText(city)).shouldBe(visible).click();
        return this;
    }

    public RegistrationPage submitForm() {
        submitButton.scrollIntoView(true).shouldBe(visible).click();
        return this;
    }

    public CheckResultComponent checkResultTable() {
        return new CheckResultComponent();
    }

    private void removeAllAds() {
        executeJavaScript(
                "const adSelectors = ['#fixedban', 'footer', '.adsbygoogle', '.ad', '.ad-container', '.ad-banner', " +
                        "'.google-ad', '.ad-wrapper', '.ad-unit', '.advert', '.advertisement', " +
                        "'[id^=google_ads_iframe]', '[id^=div-gpt-ad]', '[id^=ad-container]']; " +
                        "adSelectors.forEach(selector => { " +
                        "   document.querySelectorAll(selector).forEach(el => el.remove()); " +
                        "});"
        );
    }
}