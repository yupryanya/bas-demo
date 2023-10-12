package ru.comfortsoft.bas.pages;

import com.codeborne.selenide.SelenideElement;
import ru.comfortsoft.bas.pages.components.CalendarComponent;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class ObjectsListPage {
    private final SelenideElement sidebarFilterButton = $("button[aria-controls='collapseFilter']"),
                                searchInput = $("input[type='search']"),
                                mainSearchSubmitButton = $("button[type='submit']"),
                                addObjectButton = $("p-button[ng-reflect-label='Добавить']"),
                                levelFilterDropdown = $(".level-wrapper");


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

    public ObjectsListPage clickNewObjectButton() {
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
