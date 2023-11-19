package ru.comfortsoft.bas.models.objects;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateObjectRequestModel {
    private String address,
            name,
            objType,
            parentCode;
}
