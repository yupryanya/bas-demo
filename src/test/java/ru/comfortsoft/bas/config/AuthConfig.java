package ru.comfortsoft.bas.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:auth.properties"
})

public interface AuthConfig extends Config {
    @Key("username")
    @DefaultValue("dmitelena")
    String username();

    @Key("password")
    @DefaultValue("123QWEasd")
    String password();
}