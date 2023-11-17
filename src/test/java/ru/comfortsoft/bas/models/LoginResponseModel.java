package ru.comfortsoft.bas.models;

import io.restassured.http.Cookies;
import lombok.Data;

@Data
public class LoginResponseModel {
    private Cookies cookies;
}