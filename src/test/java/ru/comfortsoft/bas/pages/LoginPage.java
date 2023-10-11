package ru.comfortsoft.bas.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private final SelenideElement usernameInput = $("#login");
    private final SelenideElement passwordinput = $("input[type='password']");
    private final SelenideElement submitButton = $("button[type='submit']");

    public LoginPage login(String username, String password) {
        open("/frontbas/auth/login");
        usernameInput.setValue(username);
        passwordinput.setValue(password);
        submitButton.click();
        sleep(2000);
        return this;
    }
}
