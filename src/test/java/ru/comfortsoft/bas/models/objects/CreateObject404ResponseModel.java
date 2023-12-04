package ru.comfortsoft.bas.models.objects;

import lombok.Data;

import java.util.List;

@Data
public class CreateObject404ResponseModel {
    private int errorType;
    private String errorCode;
    private String errorMessage;
    private ErrorData errorData;
    private List<String> errorDetails;

    @Data
    public static class ErrorData {
        private String objectTypeName;
        private String objectType;
        private String id;
    }
}
