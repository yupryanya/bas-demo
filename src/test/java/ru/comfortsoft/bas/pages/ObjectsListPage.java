package ru.comfortsoft.bas.pages;

import com.codeborne.selenide.SelenideElement;
import ru.comfortsoft.bas.pages.components.CalendarComponent;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class ObjectsListPage {
    SidebarFilter sidebarFilter = new SidebarFilter();
    private CalendarComponent calendar = new CalendarComponent();
    private SelenideElement sidebarFilterButton = $("button[aria-controls='collapseFilter']"),
            searchInput = $("input[type='search']"),
            mainSearchSubmitButton = $("button[type='submit']"),
            addObjectButton = $("p-button[ng-reflect-label='Добавить']");

    public ObjectsListPage openPage() {
        open("/objects");
        return this;
    }

    public ObjectsListPage openSidebarFilter() {
        sidebarFilterButton.click();
        return this;
    }

    public ObjectsListPage findWithMainSearch(String value) {
        searchInput.setValue(value);
        mainSearchSubmitButton.click();
        return this;
    }

    public ObjectsListPage openNewObjectForm() {
        addObjectButton.click();
        return this;
    }

    public boolean objectWithRequiredAddressIsDisplayed() {
        return true;
    }
}
