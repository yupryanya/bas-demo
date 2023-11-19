package ru.comfortsoft.bas.pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.comfortsoft.bas.data.MenuItems;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.files.DownloadActions.click;

public class Header {

    private final SelenideElement mainMenu = $(".p-menubar"),
                                userInfoButton = $(".pi-user"),
                                userInfoContainer = $(".auth-panel"),
                                logoutButton = $("p-button[ng-reflect-label='Выход']");

    @Step("Navigate to {menuItem} page from Main menu")
    public void navigateTo(MenuItems menuItem) {
        mainMenu.find(byText(menuItem.getDisplayedName())).click();
    }

    @Step("Open authorized user info")
    public void openUserInfo() {
        userInfoButton.click();
    }

    @Step("Sign out from account")
    public void signOut() {
        userInfoButton.click();
        logoutButton.click();
    }

    @Step("Check user authorized as {username}")
    public void checkThatUserAuthorizedAs(String username) {
        userInfoButton.click();
        userInfoContainer.shouldHave(text(username));
    }
}