package ru.comfortsoft.bas.pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SidebarFilter {
    private final SelenideElement adressInput = $("#uo-address"),
            submitButton = $("p-button[ng-reflect-label='Найти']");

    @Step("Set object address")
    public void setAddress(String value) {
        adressInput.setValue(value);
        submitButton.click();
    }
}
