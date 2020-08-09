package com.ideas.chimps.bddselenium.views;


import com.ideas.chimps.bddselenium.util.UIName;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.MalformedURLException;

@Getter
public class ManagementCompanyListingPage extends PageBase {


    public ManagementCompanyListingPage(EventFiringWebDriver driver){
        super(driver);
    }

    @UIName(uiName = "Search Text Field")
    @FindBy(css=".search input")
    private WebElement searchTextField;

    public PropertyListing clickOnManagementCompany(String managementCompany){
        searchTextField.sendKeys(managementCompany);
        WebElement element =driver.findElement(By.xpath("//td[a[contains(text(),'"+managementCompany+"')]]/a"));
        uiName.put("//td[a[contains(text(),'"+managementCompany+"')]]/a",managementCompany);
        element.click();
        return new PropertyListing(driver);
    }


}

