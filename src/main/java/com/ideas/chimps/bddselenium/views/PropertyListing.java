package com.ideas.chimps.bddselenium.views;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.MalformedURLException;

@Getter
public class PropertyListing extends PageBase {


    public PropertyListing(EventFiringWebDriver driver){
        super(driver);
    }

    public PropertyHomePage clickOnProperty(String property){
        String xpath="//a[text()='"+property+"']";
        uiName.put(xpath,property);
        driver.findElement(By.xpath(xpath)).click();
        return new PropertyHomePage(driver);
    }

}
