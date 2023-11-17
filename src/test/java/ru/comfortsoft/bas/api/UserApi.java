package ru.comfortsoft.bas.api;

import io.restassured.http.Cookies;
import ru.comfortsoft.bas.models.UserResponseModel;

import static io.restassured.RestAssured.given;
import static ru.comfortsoft.bas.specs.LoginSpec.requestSpec;
import static ru.comfortsoft.bas.specs.LoginSpec.responseWithStatusCode200Spec;

public class UserApi {
    public static UserResponseModel getUserResponse(Cookies cookies) {

        return given(requestSpec)
                .cookies(cookies)
        .when()
                .get("/user")
                .then()
                .spec(responseWithStatusCode200Spec)
                .extract().as(UserResponseModel.class);
    }
}
