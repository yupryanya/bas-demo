package ru.comfortsoft.bas.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.comfortsoft.bas.pages.LoginPage;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;

public class TestBaseLocal {
    @BeforeAll
    static void beforeAll() {
        baseUrl = "https://bas.comfortsoft.ru/frontbas";
        browserSize = "1920x1080";
        Configuration.timeout = 8000;
        pageLoadStrategy = "eager";
    }

    @BeforeEach
    public void login() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("dmitelena", "123QWEasd");
    }

    @BeforeEach
    public void beforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    public void closePage() {
          closeWebDriver();
    }
}

