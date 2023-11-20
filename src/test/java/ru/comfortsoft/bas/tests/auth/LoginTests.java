package ru.comfortsoft.bas.tests.auth;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.comfortsoft.bas.api.users.UserApi;
import ru.comfortsoft.bas.config.App;
import ru.comfortsoft.bas.tests.TestBase;

@DisplayName("Login tests")
public class LoginTests extends TestBase {
    @Test
    @DisplayName("Successful login with valid credentials")
    @Tags({@Tag("smoke"), @Tag("regress")})
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Yulia Azovtseva")
    void successfulLoginTest() {
        loginPage.openPage();
        loginPage.signIn(App.authConfig.username(), App.authConfig.password());
        header.clickTheAlertMessage();
        header.openUserInfo();
        header.checkThatUserAuthorizedAs(UserApi.getAuthorizedUserInfo().getName());
    }

    @Test
    @DisplayName("Successful user sign-out")
    @Tags({@Tag("smoke"), @Tag("regress")})
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Yulia Azovtseva")
    void sucessfulLogoutTest() {
        loginPage.openPage();
        loginPage.signIn(App.authConfig.username(), App.authConfig.password());
        header.clickTheAlertMessage();
        header.checkThatUserAuthorizedAs(UserApi.getAuthorizedUserInfo().getName());
        header.signOut();
        loginPage.checkUserSignedOut();
    }

    @Test
    @DisplayName("Login with an invalid password for valid username")
    @Tag("regress")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Yulia Azovtseva")
    void unsuccessfulLoginWithInvalidPasswordTest() {
        loginPage.openPage();
        loginPage.signIn(App.authConfig.username(), "invalid_password");
        loginPage.checkUserSignedOut();
    }
}