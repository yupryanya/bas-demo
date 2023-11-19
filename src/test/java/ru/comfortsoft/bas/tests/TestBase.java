package ru.comfortsoft.bas.tests;

import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.comfortsoft.bas.api.objects.ObjectsApi;
import ru.comfortsoft.bas.config.App;
import ru.comfortsoft.bas.helpers.WebDriverProvider;
import ru.comfortsoft.bas.helpers.Attach;
import ru.comfortsoft.bas.pages.auth.LoginPage;
import ru.comfortsoft.bas.pages.components.Header;
import ru.comfortsoft.bas.pages.components.SidebarFilter;
import ru.comfortsoft.bas.pages.main.MainPage;
import ru.comfortsoft.bas.pages.objects.CreateObjectPage;
import ru.comfortsoft.bas.pages.objects.ObjectViewPage;
import ru.comfortsoft.bas.pages.objects.ObjectsListPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    protected final LoginPage loginPage = new LoginPage();
    protected final Header header = new Header();
    protected final MainPage mainPage = new MainPage();
    protected final ObjectsListPage objectsListPage = new ObjectsListPage();
    protected final CreateObjectPage createObjectPage = new CreateObjectPage();
    protected final ObjectViewPage objectViewPage = new ObjectViewPage();
    protected final SidebarFilter sidebarFilter = new SidebarFilter();
    protected final ObjectsApi objectsApi = new ObjectsApi();

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
