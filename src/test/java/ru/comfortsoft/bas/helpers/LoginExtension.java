package ru.comfortsoft.bas.helpers;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;
import ru.comfortsoft.bas.api.auth.LoginApi;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginExtension implements BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) {
        open("/favicon.ico");
        getWebDriver().manage().addCookie(new Cookie("JSESSIONID", LoginApi.startSession()));
    }
}