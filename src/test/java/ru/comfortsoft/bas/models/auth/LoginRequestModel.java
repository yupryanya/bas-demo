package ru.comfortsoft.bas.models.auth;

import lombok.Data;

@Data
public class LoginRequestModel {
    private String username,
            password;
}
