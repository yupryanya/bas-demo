package ru.comfortsoft.bas.models.objects;

import lombok.Data;

import java.util.List;

@Data
public class CreateObjectErrorResponseModel {
    private int errorType;
    private String errorCode;
    private String errorMessage;
    private ErrorData errorData;
    private List<String> errorDetails;

    @Data
    public static class ErrorData {
        private String paramName;
        private String problem;
        private String param;
    }
}
