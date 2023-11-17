package ru.comfortsoft.bas.models;

import lombok.Data;

import java.util.List;

@Data
public class UserResponseModel {
        private String email;
        private String name;
        private List<String> roles;
        private String id;
        private String state;
    }