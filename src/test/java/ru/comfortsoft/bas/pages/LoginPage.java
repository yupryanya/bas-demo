package ru.comfortsoft.bas.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private SelenideElement usernameInput = $("#login"),
                            passwordinput = $("input[type='password']"),
                            submitButton = $("button[type='submit']");

    public LoginPage login(String username, String password) {
        open("/auth/login");
        usernameInput.setValue(username);
        passwordinput.setValue(password);
        submitButton.click();
        return this;
    }
}
