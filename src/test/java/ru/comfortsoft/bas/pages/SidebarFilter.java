package ru.comfortsoft.bas.pages;

import com.codeborne.selenide.SelenideElement;
import ru.comfortsoft.bas.pages.components.CalendarComponent;

import static com.codeborne.selenide.Selenide.$;

public class SidebarFilter {
    private CalendarComponent calendar = new CalendarComponent();
    private SelenideElement codeInput = $("#iduo-code"),
            nameInput = $("#uo-name"),
            adressInput = $("#uo-address"),
            prefectInput = $("[ng-reflect-input-id='uo-prefect']");

    public SidebarFilter setCode(String value) {
        prefectInput.setValue(value);
        return this;
    }

    public SidebarFilter setDate(String year, String month, String day) {
        calendar.setDate(year, month, day);
        return this;
    }
}
