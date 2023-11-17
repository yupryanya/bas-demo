package ru.comfortsoft.bas.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SidebarFilterComponent {
    private final CalendarComponent calendar = new CalendarComponent();
    private final SelenideElement adressInput = $("#uo-address"),
                                submitButton = $("p-button[ng-reflect-label='Найти']");

    public SidebarFilterComponent setAddress(String value) {
        adressInput.setValue(value);
        return this;
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
