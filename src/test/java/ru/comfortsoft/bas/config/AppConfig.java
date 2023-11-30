package ru.comfortsoft.bas.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:bas.properties"
})

public interface AppConfig extends Config {
    @Key("apiUrl" )
    @DefaultValue("https://bas.comfortsoft.ru/bas" )
    String apiUrl();

    @Key("webUrl" )
    @DefaultValue("https://bas.comfortsoft.ru/frontbas" )
    String webUrl();

    @Key("username")
    @DefaultValue("delena")
    String username();

    @Key("password")
    @DefaultValue("123QWEasd")
    String password();
}