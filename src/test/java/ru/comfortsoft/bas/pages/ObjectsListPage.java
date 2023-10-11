package ru.comfortsoft.bas.pages;

import com.codeborne.selenide.SelenideElement;
import ru.comfortsoft.bas.pages.components.CalendarComponent;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class ObjectsListPage {
    SidebarFilter sidebarFilter = new SidebarFilter();
    private final CalendarComponent calendar = new CalendarComponent();
    private final SelenideElement sidebarFilterButton = $("button[aria-controls='collapseFilter']");
    private final SelenideElement searchInput = $("input[type='search']");
    private final SelenideElement mainSearchSubmitButton = $("button[type='submit']");
    private final SelenideElement addObjectButton = $("p-button[ng-reflect-label='Добавить']");
    private final SelenideElement levelFilterDropdown = $(".level-wrapper");


    public ObjectsListPage openPage() {
        open("/frontbas/objects");
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

    public ObjectsListPage setLevelFilterValue(String value) {
        levelFilterDropdown.click();
        $("[ng-reflect-label=" + value + "]").click();
        return this;
    }

    public boolean objectWithRequiredLevelIsDisplayed() {
        return true;
    }
}
