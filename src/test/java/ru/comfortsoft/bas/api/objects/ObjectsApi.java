package ru.comfortsoft.bas.api.objects;

import ru.comfortsoft.bas.api.auth.LoginApi;
import ru.comfortsoft.bas.models.objects.CreateObjectRequestModel;
import ru.comfortsoft.bas.models.objects.CreateObjectResponseModel;

import static io.restassured.RestAssured.given;
import static ru.comfortsoft.bas.specs.BaseSpec.*;

public class ObjectsApi {
    public CreateObjectResponseModel createObject(CreateObjectRequestModel object) {
        return given(defaultRequestSpec)
                .cookie("JSESSIONID", LoginApi.getSessionIdCookie())
                .body(object)
                .when()
                .post("/v1/dict-data/obj")
                .then()
                .spec(responseWithStatusCode200Spec)
                .extract().as(CreateObjectResponseModel.class);
    }

    public void deleteObjectByCode(String objectId) {
        given().spec(defaultRequestSpec)
                .cookie("JSESSIONID", LoginApi.getSessionIdCookie())
                .pathParam("id", objectId)
                .when()
                .delete("/v1/dict-data/obj/{id}")
                .then()
                .spec(responseWithStatusCode204Spec);
    }
}
