package com.ideas.chimps.bddselenium.util;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
    WebDriver driver;
    WebDriverWait wait;

    public Wait(WebDriver driver, int waitDuration){
        wait=new WebDriverWait(driver,waitDuration);
        this.driver=driver;
    }

    public boolean waitTillElementVisibility(WebElement element) {
        boolean status=false;
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            status=true;
        }catch(TimeoutException e) {

        }
        return status;

    }

    public boolean waitTillElementClickable(WebElement element) {
        boolean status=false;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            status=true;
        }catch(TimeoutException e) {

        }
        return status;
    }
}
