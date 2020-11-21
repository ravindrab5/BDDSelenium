package com.ideas.chimps.bddselenium.util;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Capabilities {
    private DesiredCapabilities capabilities;

    public DesiredCapabilities getCapabilities(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            capabilities = DesiredCapabilities.chrome();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("test-type");
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,969");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        }
        return capabilities;
    }

}
