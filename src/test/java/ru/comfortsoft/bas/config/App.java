package ru.comfortsoft.bas.config;

import org.aeonbits.owner.ConfigFactory;

public class App {
    public static AppConfig appConfig = ConfigFactory.create(AppConfig.class, System.getProperties());
    public static AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
}