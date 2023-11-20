package ru.comfortsoft.bas.pages.objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CreateObjectPage {
    private final String REQUIRED_MESSAGE = "Поле обязательно для заполнения";
    private final SelenideElement objectEditForm = $(".object-edit-form"),
            objectTypeInput = $("app-dict-input[formcontrolname='objType'] .p-dropdown-trigger"),
            commonDropdown = $(".im-options"),
            codeInput = $("input[formcontrolname='code']"),
            parentCodeInput = $("app-dict-input[formcontrolname='parentCode'] .p-dropdown-trigger"),
            addressInput = $("input[formcontrolname='address']"),
            nameInput = $("textarea[formcontrolname='name']"),
            submitButton = $("p-button[ng-reflect-label='Сохранить']"),
            objectCreatePage = $("app-object-create-page");

    @Step("Open 'New Object' page")
    public CreateObjectPage openPage() {
        open("/objects/new");
        return this;
    }

    @Step("The 'New Objects' form should be displayed")
    public void checkTheNewObjectFormIsVisible() {
        objectCreatePage.isDisplayed();
    }

    @Step("Set object type to {value}")
    public CreateObjectPage setObjectType(String value) {
        objectTypeInput.click();
        commonDropdown.$(byText(value)).click();
        return this;
    }

    @Step("Set parent code for object to {value}")
    public CreateObjectPage setParentCode(String value) {
        parentCodeInput.click();
        commonDropdown.$(byText(value)).click();
        return this;
    }

    @Step("Set obect type to {value}")
    public CreateObjectPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    @Step("Set object name to {value}")
    public CreateObjectPage setObjectName(String value) {
        nameInput.setValue(value);
        return this;
    }

    @Step("Click Sidebar Filter Submit button")
    public void clickSubmitButton() {
        submitButton.click();
    }

    @Step("Get object code from 'Code' field")
    public String getObjectCode() {
        return codeInput.getValue();
    }

    @Step("The required field error message should be displayed")
    public void requiredFieldErrorMessageShouldBeDisplayed() {
        objectEditForm.shouldHave(text(REQUIRED_MESSAGE));
    }
}