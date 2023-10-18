package ru.comfortsoft.bas.pages;

import com.codeborne.selenide.SelenideElement;
import ru.comfortsoft.bas.pages.components.CalendarComponent;

import static com.codeborne.selenide.Selenide.$;

public class SidebarFilter {
    private final CalendarComponent calendar = new CalendarComponent();
    private final SelenideElement adressInput = $("#uo-address"),
                                submitButton = $("p-button[ng-reflect-label='Найти']");

    public SidebarFilter setAddress(String value) {
        adressInput.setValue(value);
        return this;
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
