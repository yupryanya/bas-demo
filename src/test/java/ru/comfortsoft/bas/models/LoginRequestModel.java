package ru.comfortsoft.bas.models;

import lombok.Data;

@Data
public class LoginRequestModel {
    private String username,
            password;
}
