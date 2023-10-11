package ru.comfortsoft.bas.pages;

import com.codeborne.selenide.SelenideElement;
import ru.comfortsoft.bas.pages.components.CalendarComponent;

import static com.codeborne.selenide.Selenide.$;

public class SidebarFilter {
    private final CalendarComponent calendar = new CalendarComponent();
    private final SelenideElement codeInput = $("#iduo-code"),
                                nameInput = $("#uo-name"),
                                adressInput = $("#uo-address"),
                                prefectInput = $("[ng-reflect-input-id='uo-prefect']"),
                                submitButton = $("p-button[ng-reflect-label='Найти']");

    public SidebarFilter setCode(String value) {
        prefectInput.setValue(value);
        return this;
    }

    public SidebarFilter setDate(String year, String month, String day) {
        calendar.setDate(year, month, day);
        return this;
    }

    public SidebarFilter findWithSidebarFilterByAddress(String value) {
        adressInput.setValue(value);
        submitButton.click();
        return this;
    }
}
