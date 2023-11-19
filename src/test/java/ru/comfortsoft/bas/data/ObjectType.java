package ru.comfortsoft.bas.data;

public enum ObjectType {
    BUILDING("06", "Здание"),
    LAND_PLOT("05", "Земельный участок");

    private final String code,
            name;

    ObjectType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getObjectTypeCode() { return code; }

    public String getObjectTypeName() {
        return name;
    }
}
