package com.ideas.chimps.bddselenium.util;


import com.ideas.chimps.bddselenium.config.CommonConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

@Component
@Scope("singleton")
public class DriverFactory implements FactoryBean<WebDriver> {

    private static boolean driverFirstTimeFlag=false;

    @Autowired
    private CommonConfig config;

    @Override
    public WebDriver getObject() throws MalformedURLException {

        DesiredCapabilities cap=new Capabilities().getCapabilities(config);
        String url="http://"+config.getHubUrl()+":4444/wd/hub";

        final WebDriver driver;


        driver = new RemoteWebDriver(new java.net.URL(url), cap);

        initWebDriver(driver);

        return driver;

    }

    private void initWebDriver(WebDriver webDriver) {
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }


    @Override
    public Class<?> getObjectType() {
        return WebDriver.class;
    }
}
