package ru.comfortsoft.bas.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ObjectViewPage {
    private final SelenideElement objectInformation = $(".common-info");

    public void objectWithRequiredFieldsisDisplayed(String ... values) {
        for (String value : values) {
            objectInformation.shouldHave(text(value));
        }
    }
}
