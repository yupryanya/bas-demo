package ru.comfortsoft.bas.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class ObjectsListPage {
    private final SelenideElement sidebarFilterButton = $("button[aria-controls='collapseFilter']"),
                                    searchInput = $("input[type='search']"),
                                    mainSearchSubmitButton = $("button[type='submit']"),
                                    addObjectButton = $("p-button[ng-reflect-label='Добавить']"),
                                    levelFilter = $(".level-wrapper"),
                                    elementsList = $(".p-datatable-tbody"),
                                    levelFilterDropdown = $(".p-dropdown-items");

    public ObjectsListPage openPage() {
        open("/frontbas/objects");
        return this;
    }

    public ObjectsListPage openSidebarFilter() {
        sidebarFilterButton.click();
        return this;
    }

    public ObjectsListPage fillTheMainSearchField(String value) {
        searchInput.setValue(value);
        mainSearchSubmitButton.click();
        return this;
    }

    public ObjectsListPage clickNewObjectButton() {
        addObjectButton.click();
        return this;
    }

    public ObjectsListPage setLevelFilterValue(String value) {
        levelFilter.click();
        levelFilterDropdown.$("[ng-reflect-label=" + value + "]").click();
        return this;
    }

    public void clickFirstElementFromList() {
        elementsList.$("a").click();
    }
}
