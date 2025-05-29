package guru.qa.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class CheckResultComponent {


    public CheckResultComponent verifyResult(String key, String value) {
        $x("//td[text()='" + key + "']/following-sibling::td")
                .shouldHave(text(value));
        return this;
    }
}