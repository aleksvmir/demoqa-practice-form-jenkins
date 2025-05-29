package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    private final SelenideElement nameInput = $("#userName"),
            mailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            outputWrapper = $("#output");


    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }

    public TextBoxPage setName(String value) {
        nameInput.setValue(value);
        return this;
    }

    public TextBoxPage setMail(String value) {
        mailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage submitForm() {
        submitButton.click();
        return this;
    }

    public TextBoxPage checkResultBox(String key, String value) {
        outputWrapper.$x(".//p[contains(text(), '" + key + "')]").shouldHave(text(value));
        return this;
    }

}