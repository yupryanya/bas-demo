package ru.comfortsoft.bas.api;

import io.restassured.http.ContentType;
import ru.comfortsoft.bas.config.App;

import static io.restassured.RestAssured.given;
import static ru.comfortsoft.bas.specs.LoginSpec.*;

public class LoginApi {
    public static String getLoginResponse() {

    return given(requestSpec)
                .when()
                .contentType(ContentType.URLENC)
                .formParam("username", App.authConfig.username())
                .formParam("password", App.authConfig.password())
                .post("/login")
                .then()
                .spec(responseWithStatusCode200Spec)
                .extract().response()
                .getCookie("JSESSIONID");
    }
}
