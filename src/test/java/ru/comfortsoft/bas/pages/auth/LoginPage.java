package ru.comfortsoft.bas.pages.auth;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private final String GUEST_TEXT = "Автоматизация оперпланов";

    private final SelenideElement usernameInput = $("#login"),
                            passwordInput = $("input[type='password']"),
                            submitButton = $("button[type='submit']"),
                            guestPageText = $(".bas-guest-header");

    @Step("Open 'Login' page")
    public void openPage() {
        Selenide.open("/auth/login");
    }

    @Step("Log in to account with username '{username}'")
    public void signIn(String username, String password) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        submitButton.click();
    }

    @Step("Guest page should be displayed")
    public void checkUserSignedOut() {
        guestPageText.shouldHave(text(GUEST_TEXT));
    }
}
