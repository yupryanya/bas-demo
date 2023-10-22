package ru.comfortsoft.bas.tests;

import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.comfortsoft.bas.config.WebDriverConfig;
import ru.comfortsoft.bas.config.WebDriverProvider;
import ru.comfortsoft.bas.helpers.Attach;
import ru.comfortsoft.bas.pages.LoginPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    static final WebDriverProvider webDriverProvider = new WebDriverProvider();

    @BeforeAll
    static void init() {
        webDriverProvider.webDriverConfigInit();
    }

    @BeforeEach
    public void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void login() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("dmitelena", "123QWEasd");
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        if (webDriverConfig.isRemote()) {
            Attach.addVideo();
        }
        closeWebDriver();
    }
}
