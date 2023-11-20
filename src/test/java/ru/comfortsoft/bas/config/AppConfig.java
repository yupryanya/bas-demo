package ru.comfortsoft.bas.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/${env}.properties"
})

public interface AppConfig extends Config {
    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browserVersion")
    @DefaultValue("114")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();

    @Key("apiUrl" )
    @DefaultValue("https://bas.comfortsoft.ru/bas" )
    String apiUrl();

    @Key("webUrl" )
    @DefaultValue("https://bas.comfortsoft.ru/frontbas" )
    String webUrl();

    @Key("remoteUrl")
    @DefaultValue("selenoid.autotests.cloud")
    String remoteUrl();
}