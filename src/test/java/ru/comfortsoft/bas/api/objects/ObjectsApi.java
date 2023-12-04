package ru.comfortsoft.bas.api.objects;

import io.restassured.response.Response;
import ru.comfortsoft.bas.api.auth.LoginApi;
import ru.comfortsoft.bas.data.endpoints.DictDataEndpoint;
import ru.comfortsoft.bas.data.dictionaries.DictType;
import ru.comfortsoft.bas.models.objects.CreateObjectRequestModel;

import static io.restassured.RestAssured.given;
import static ru.comfortsoft.bas.specs.BaseSpec.*;

public class ObjectsApi {
    private final DictType dictCode = DictType.OBJ;

    public Response createObject(CreateObjectRequestModel object) {
        return
                given(defaultRequestSpec)
                        .cookie("JSESSIONID", LoginApi.startSession())
                        .pathParam("dict-code", dictCode.getCode())
                        .body(object)
                        .when()
                        .post(DictDataEndpoint.CREATE)
                        .then()
                        .spec(defaultResponseSpec)
                        .extract().response();
    }

    public Response deleteObject(String code) {
        return
                given()
                        .spec(defaultRequestSpec)
                        .cookie("JSESSIONID", LoginApi.startSession())
                        .pathParam("dict-code", dictCode.getCode())
                        .pathParam("code", code)
                        .when()
                        .delete(DictDataEndpoint.DELETE)
                        .then()
                        .spec(defaultResponseSpec)
                        .extract().response();
    }
}
