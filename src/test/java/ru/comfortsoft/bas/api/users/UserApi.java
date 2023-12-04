package ru.comfortsoft.bas.api.users;

import ru.comfortsoft.bas.api.auth.LoginApi;
import ru.comfortsoft.bas.data.endpoints.UsersEndpoint;
import ru.comfortsoft.bas.models.users.UserResponseModel;

import static io.restassured.RestAssured.given;
import static ru.comfortsoft.bas.specs.BaseSpec.defaultRequestSpec;
import static ru.comfortsoft.bas.specs.BaseSpec.defaultResponseSpec;

public class UserApi {
    public static UserResponseModel getAuthorizedUserInfo() {
        return
                given(defaultRequestSpec)
                        .cookie("JSESSIONID", LoginApi.startSession())
                        .when()
                        .get(UsersEndpoint.GET_LOGGED)
                        .then()
                        .spec(defaultResponseSpec)
                        .extract().as(UserResponseModel.class);
    }
}
