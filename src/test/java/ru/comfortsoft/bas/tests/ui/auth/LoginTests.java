package ru.comfortsoft.bas.tests.ui.auth;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.comfortsoft.bas.api.users.UserApi;
import ru.comfortsoft.bas.config.App;
import ru.comfortsoft.bas.helpers.WithLogin;
import ru.comfortsoft.bas.tests.ui.BaseWeb;

@DisplayName("Login tests")
public class LoginTests extends BaseWeb {
    @Test
    @DisplayName("Authenticate successfully with valid credentials")
    @Tags({@Tag("smoke"), @Tag("regress")})
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Yulia Azovtseva")
    void successfulLoginTest() {
        loginPage.openPage();
        loginPage.signIn(App.appConfig.username(), App.appConfig.password());
        header.userIsAuthorizedAs(UserApi.getAuthorizedUserInfo().getName());
    }

    @Test
    @WithLogin
    @DisplayName("Successful user sign-out")
    @Tags({@Tag("smoke"), @Tag("regress")})
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Yulia Azovtseva")
    void sucessfulLogoutTest() {
        loginPage.openPage();
        header.userIsAuthorizedAs(UserApi.getAuthorizedUserInfo().getName());
        header.signOut();
        loginPage.guestPageIsDisplayed();
    }

    @Test
    @DisplayName("Attempt login with an invalid password for a valid username")
    @Tag("regress")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Yulia Azovtseva")
    void unsuccessfulLoginWithInvalidPasswordTest() {
        loginPage.openPage();
        loginPage.signIn(App.appConfig.username(), "invalid_password");
        loginPage.guestPageIsDisplayed();
    }
}