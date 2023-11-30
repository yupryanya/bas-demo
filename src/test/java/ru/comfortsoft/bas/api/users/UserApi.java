package ru.comfortsoft.bas.api.users;

import ru.comfortsoft.bas.api.auth.LoginApi;
import ru.comfortsoft.bas.api.endpoints.UsersEndpoint;
import ru.comfortsoft.bas.models.users.UserResponseModel;

import static io.restassured.RestAssured.given;
import static ru.comfortsoft.bas.specs.BaseSpec.defaultRequestSpec;
import static ru.comfortsoft.bas.specs.BaseSpec.responseWithStatusCode200Spec;

public class UserApi {
    public static UserResponseModel getAuthorizedUserInfo() {
        return
                given(defaultRequestSpec)
                    .cookie("JSESSIONID", LoginApi.getSessionIdCookie())
               .when()
                    .get(UsersEndpoint.GET_LOGGED)
               .then()
                    .spec(responseWithStatusCode200Spec)
                    .extract().as(UserResponseModel.class);
    }
}
