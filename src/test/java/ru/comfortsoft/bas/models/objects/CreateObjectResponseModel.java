package ru.comfortsoft.bas.models.objects;

import lombok.Data;

import java.util.List;

@Data
public class CreateObjectResponseModel {
    private String unom,
            code,
            landCadastralNum,
            geom,
            lockTime,
            parentCode,
            lockUser,
            levelNumber,
            confirmStatus,
            fias,
            objType,
            cadastralNum,
            address,
            docType,
            geom_hash,
            addressRegDocNum,
            addressRegDocDate,
            orbisId,
            name,
            kladr,
            comment,
            category;

    private boolean active,
            locked;

    private List<String> prefect,
            district;

    //@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSXXX")
    private String updateTime, createTime, startDate;
}
