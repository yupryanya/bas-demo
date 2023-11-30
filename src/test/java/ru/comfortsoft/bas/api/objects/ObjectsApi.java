package ru.comfortsoft.bas.api.objects;

import ru.comfortsoft.bas.api.auth.LoginApi;
import ru.comfortsoft.bas.api.endpoints.DictDataEndpoint;
import ru.comfortsoft.bas.data.DictType;
import ru.comfortsoft.bas.models.objects.CreateObjectRequestModel;
import ru.comfortsoft.bas.models.objects.CreateObjectResponseModel;

import static io.restassured.RestAssured.given;
import static ru.comfortsoft.bas.specs.BaseSpec.*;

public class ObjectsApi {
    DictType dictCode = DictType.OBJ;

    public CreateObjectResponseModel createObject(CreateObjectRequestModel object) {
        return
               given(defaultRequestSpec)
                    .cookie("JSESSIONID", LoginApi.getSessionIdCookie())
                    .pathParam("dict-code", dictCode.getCode())
                    .body(object)
               .when()
                    .post(DictDataEndpoint.CREATE)
               .then()
                    .spec(responseWithStatusCode200Spec)
                    .extract().as(CreateObjectResponseModel.class);
    }

    public void deleteObjectByCode(String code) {
        given()
            .spec(defaultRequestSpec)
            .cookie("JSESSIONID", LoginApi.getSessionIdCookie())
            .pathParam("dict-code", dictCode.getCode())
            .pathParam("code", code)
        .when()
            .delete(DictDataEndpoint.DELETE)
        .then()
            .spec(responseWithStatusCode204Spec);
    }
}
