package com.ideas.chimps.bddselenium.actionhelpers;

import com.ideas.chimps.bddselenium.entities.ManagementCompany;
import com.ideas.chimps.bddselenium.entities.Property;
import com.ideas.chimps.bddselenium.entities.User;
import com.ideas.chimps.bddselenium.util.LocalDateUtil;
import com.ideas.chimps.bddselenium.util.UiLocalDateUtil;
import com.ideas.chimps.bddselenium.views.*;
import lombok.Getter;
import org.openqa.selenium.support.events.EventFiringWebDriver;

@Getter
public abstract class ActionBase {

    public ActionBase(EventFiringWebDriver driver,User user){
        this.driver=driver;
        this.user=user;
    }

    protected User user;
    protected EventFiringWebDriver driver;
    protected ManagementCompanyListingPage companyListingPage;
    protected PropertyListing propListing;
    protected PropertyHomePage propertyHomePage;
    protected UiLocalDateUtil uiDateUtil;
    protected LoginPage loginPage;
    protected LocalDateUtil localDateUtil;
    protected CalenderPop calenderPop;


    public void navigateToPropertyHome(ManagementCompany managementCompany, Property property){
        loginPage=new LoginPage(driver);
        if(user.getRole().equals(UserTypeConstants.PROPERTY_USER)){
            propertyHomePage=loginPage.loginAsPropertyUser(user.getUserName(),user.getPassword());
        }else {
            companyListingPage = loginPage.login(user.getUserName(), user.getPassword());
            propListing = companyListingPage.clickOnManagementCompany(managementCompany.getManagementCompanyName());
            propertyHomePage=propListing.clickOnProperty(property.getPropertyName());
        }
    }

    public void navigateToManagementListing(){

    }

}
