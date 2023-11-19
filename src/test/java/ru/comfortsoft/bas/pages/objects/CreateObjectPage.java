package ru.comfortsoft.bas.pages.objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CreateObjectPage {
    private final SelenideElement objectTypeInput = $("app-dict-input[formcontrolname='objType'] .p-dropdown-trigger"),
            commonDropdown = $(".im-options"),
            parentCodeInput = $("app-dict-input[formcontrolname='parentCode'] .p-dropdown-trigger"),
            addressInput = $("input[formcontrolname='address']"),
            objectNameInput = $("textarea[formcontrolname='name']"),
            submitButton = $("p-button[ng-reflect-label='Сохранить']"),
            objectCreatePage = $("app-object-create-page");

    @Step("Open 'New Object' page")
    public CreateObjectPage openPage() {
        open("/objects/new");
        return this;
    }

    @Step("Check that 'New Object' page is visible")
    public void checkTheNewObjectFormIsVisible() {
        objectCreatePage.isDisplayed();
    }

    @Step("Set object type {value}")
    public CreateObjectPage setObjectType(String value) {
        objectTypeInput.click();
        commonDropdown.$(byText(value)).click();
        return this;
    }

    @Step("Set parent code for object {value}")
    public CreateObjectPage setParentCode(String value) {
        parentCodeInput.click();
        commonDropdown.$(byText(value)).click();
        return this;
    }

    @Step("Set obect type {value}")
    public CreateObjectPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    @Step("Set object name {value}")
    public CreateObjectPage setObjectName(String value) {
        objectNameInput.setValue(value);
        return this;
    }

    @Step("Click Submit button")
    public void clickSubmitButton() {
        submitButton.click();
    }
}