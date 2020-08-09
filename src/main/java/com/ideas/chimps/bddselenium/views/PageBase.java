package com.ideas.chimps.bddselenium.views;

import com.ideas.chimps.bddselenium.util.UIName;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class PageBase {


    public EventFiringWebDriver getDriver() {
        return driver;
    }

    protected EventFiringWebDriver driver;

    public static Map<String, String> uiName=new HashMap<String, String>();

    public PageBase(EventFiringWebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public LoginPage logout() throws MalformedURLException {
        driver.findElement(By.cssSelector(".icon.ion-power")).click();
        return new LoginPage(driver);
    }


    protected void addWebElementMeta(PageBase p)  {
        Field[] field = p.getClass().getDeclaredFields();
        for (Field fld : field) {
            UIName wem = fld.getAnnotation(UIName.class);
            FindBy fb = fld.getAnnotation(FindBy.class);

            if(fb!=null) {
                uiName.put(getLocator(fb), wem.uiName());
            }

        }
    }

    protected String getLocator(FindBy fb) {
        String str = null;
        if (fb.css().length() > 0) {
            str = fb.css();
        } else if (fb.id().length() > 0) {
            str = fb.id();
        } else if (fb.className().length() > 0) {
            str = fb.className();
        } else if (fb.linkText().length() > 0) {
            str = fb.linkText();
        } else if (fb.partialLinkText().length() > 0) {
            str = fb.partialLinkText();
        } else if (fb.xpath().length() > 0) {
            str = fb.xpath();
        }

        if (str == null) {
            System.out.println("Str null detected ");
        }
        return str;

    }

    /*protected void addWebElementMetaIntoMap(String locator,String uiName) {
        this.uiName.put(locator, uiName);

    }*/

}
