package ru.comfortsoft.bas.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NewObjectPage {
    private final SelenideElement objectTypeInput = $("app-dict-input[formcontrolname='objType'] .p-dropdown-trigger"),
            commonDropdown = $(".im-options"),
            parentCodeInput = $("app-dict-input[formcontrolname='parentCode'] .p-dropdown-trigger"),
            addressInput = $("input[formcontrolname='address']"),
            objectNameInput = $("textarea[formcontrolname='name']"),
            submitButton = $("p-button[ng-reflect-label='Сохранить']"),
            objectNewPage = $("app-object-create-page");

    public NewObjectPage openPage() {
        open("/frontbas/objects/new");
        return this;
    }

    public NewObjectPage setObjectType(String value) {
        objectTypeInput.click();
        commonDropdown.$(byText(value)).click();
        return this;
    }

    public NewObjectPage setParentCode(String value) {
        parentCodeInput.click();
        commonDropdown.$(byText(value)).click();
        return this;
    }

    public NewObjectPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public NewObjectPage setObjectName(String value) {
        objectNameInput.setValue(value);
        return this;
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void newObjectFormIsDisplayed() {
        objectNewPage.isDisplayed();
    }
}
