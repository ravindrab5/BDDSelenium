package com.ideas.chimps.bddselenium.util;

import com.ideas.chimps.bddselenium.config.CommonConfig;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Capabilities {
    private DesiredCapabilities capabilities;

    public DesiredCapabilities getCapabilities(CommonConfig config){
        if(config.getBrowser().equalsIgnoreCase("chrome")){
            capabilities = DesiredCapabilities.chrome();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("test-type");
            if(config.getHeadless()) {
                options.addArguments("--headless");
                options.addArguments(config.getWindowSize());
            }
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        }
        return capabilities;
    }

}
