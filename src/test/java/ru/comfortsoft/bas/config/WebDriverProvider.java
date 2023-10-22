package ru.comfortsoft.bas.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Configuration.pageLoadStrategy;

public class WebDriverProvider {
    WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public void webDriverConfigInit() {
        Configuration.baseUrl = webDriverConfig.baseUrl();
        Configuration.browser = webDriverConfig.browser().toString();
        Configuration.browserVersion = webDriverConfig.browserVersion();
        Configuration.browserSize = webDriverConfig.browserSize();
        if (webDriverConfig.isRemote()) {
            Configuration.remote = webDriverConfig.remoteUrl();


            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", Configuration.browser);
            capabilities.setCapability("browserVersion", Configuration.browserVersion);
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
            Configuration.timeout = 10000;
            pageLoadStrategy = "eager";
        }
    }
}


