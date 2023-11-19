package ru.comfortsoft.bas.data;

public enum ObjectLevel {
    CITY("Город"),
    CITY_PART("Часть города"),
    OKRUG("Округ"),
    DISTRICT("Район/Поселение"),
    BUILDING("Здание/Сооружение");
    private final String levelNumber;

    ObjectLevel(String levelNumber) {
        this.levelNumber = levelNumber;
    }

    public String getLevelName() {
        return levelNumber;
    }
}
