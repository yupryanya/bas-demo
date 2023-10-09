package ru.comfortsoft.bas.pages;

import com.codeborne.selenide.SelenideElement;
import ru.comfortsoft.bas.pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NewObjectPage {
    private CalendarComponent calendar = new CalendarComponent();
    private SelenideElement objectCodeInput = $("input[formcontrolname='code']"),
            objectTypeInput = $("app-dict-input[formcontrolname='objType'] .p-dropdown-trigger"),
            parentCodeInput = $("app-dict-input[formcontrolname='parentCode'] .p-dropdown-trigger"),
            addressInput = $("input[formcontrolname='address']"),
            objectNameInput = $("textarea[formcontrolname='name']"),
            submitButton = $("p-button[ng-reflect-label='Сохранить']");

    public NewObjectPage openPage() {
        open("/objects/new");
        return this;
    }

    public NewObjectPage setObjectType(String value) {
        objectTypeInput.click();
        $(byText(value)).click();
        return this;
    }

    public NewObjectPage setParentCode(String value) {
        parentCodeInput.click();
        $(byText(value)).click();
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

    public void submit() {
        submitButton.click();
    }

    public String getGeneratedCode() {
        return objectCodeInput.val();
    }
}
