package ru.comfortsoft.bas.api.auth;

import io.restassured.http.ContentType;
import ru.comfortsoft.bas.data.endpoints.LoginEndpoint;
import ru.comfortsoft.bas.config.App;

import static io.restassured.RestAssured.given;
import static ru.comfortsoft.bas.specs.BaseSpec.*;

public class LoginApi {
    public static String startSession() {
        return
                given(defaultRequestSpec)
                        .contentType(ContentType.URLENC)
                        .formParam("username", App.appConfig.username())
                        .formParam("password", App.appConfig.password())
                        .when()
                        .post(LoginEndpoint.POST)
                        .then()
                        .spec(defaultResponseSpec)
                        .extract().response()
                        .getCookie("JSESSIONID");
    }
}
