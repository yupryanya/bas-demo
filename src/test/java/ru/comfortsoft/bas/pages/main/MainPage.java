package ru.comfortsoft.bas.pages.main;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class MainPage {
    @Step("Open Main page")
    public void openPage() {
        Selenide.open("/");
    }
}
