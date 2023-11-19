package ru.comfortsoft.bas.pages.objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class ObjectsListPage {
    private final SelenideElement sidebarFilterButton = $("button[aria-controls='collapseFilter']"),
            searchInput = $("input[type='search']"),
            mainSearchSubmitButton = $("button[type='submit']"),
            addObjectButton = $("p-button[ng-reflect-label='Добавить']"),
            levelFilter = $(".level-wrapper"),
            elementsList = $(".p-datatable-tbody"),
            levelFilterDropdown = $(".p-dropdown-items"),
            objectsListPage = $("app-object-list");

    @Step("Open 'Objects' page")
    public void openPage() {
        open("/objects");
    }

    @Step("Check 'Objects' form is displayed")
    public void checkObjectsListPageIsDisplayed() {
        objectsListPage.isDisplayed();
    }

    @Step("Open Sidebar filter")
    public void openSidebarFilter() {
        sidebarFilterButton.click();
    }

    @Step("Find element with the 'Main search' field")
    public void fillTheMainSearchField(String value) {
        searchInput.setValue(value);
        mainSearchSubmitButton.click();
    }

    @Step("Click 'New Object' button")
    public void clickNewObjectButton() {
        addObjectButton.click();
    }

    @Step("Set 'Level Filter' value to {value}")
    public void setLevelFilterValue(String value) {
        levelFilter.click();
        levelFilterDropdown.$(byText(value)).click();
    }

    @Step("Cick the first element in objects list")
    public void clickFirstElementInList() {
        elementsList.$("a").click();
    }
}
