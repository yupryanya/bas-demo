package ru.comfortsoft.bas.tests;

import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.comfortsoft.bas.config.App;
import ru.comfortsoft.bas.helpers.WebDriverProvider;
import ru.comfortsoft.bas.helpers.Attach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    @BeforeAll
    static void init() {
        WebDriverProvider.webDriverConfigInit();
        RestAssured.baseURI = App.appConfig.apiUrl();
    }

    @BeforeEach
    public void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        if (App.appConfig.isRemote()) {
            Attach.addVideo();
        }
        closeWebDriver();
    }
}
