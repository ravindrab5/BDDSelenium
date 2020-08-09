package com.ideas.chimps.bddselenium.util;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeleniumApi {

    @Autowired
    private DriverFactory driverFactory;

    protected WebDriver driver;



    /**
     * Start void.
     *
     * @throws Exception the exception
     */
    public WebDriver start() {
         if(driver==null) {


             try {
                 driver = driverFactory.getObject();

             } catch (Exception e) {

             }
         }
        return driver;
    }

    /**
     * Quit void.
     */
    public void quit() {
        if (driver != null) {
            driver.quit();

        }
        driver=null;

    }

}
