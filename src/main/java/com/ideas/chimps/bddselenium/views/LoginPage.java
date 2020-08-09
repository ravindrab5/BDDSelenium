package com.ideas.chimps.bddselenium.views;


import com.ideas.chimps.bddselenium.util.UIName;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.function.BiFunction;
import java.util.function.Supplier;

@Getter
public class LoginPage extends PageBase{

    public LoginPage(EventFiringWebDriver driver) {
       super(driver);
        addWebElementMeta(this);
    }

    @UIName(uiName="Username")
    @FindBy(id="username")
    private WebElement username;

    @UIName(uiName="Password")
    @FindBy(id="password")
    private WebElement password;

    @UIName(uiName="Login button")
    @FindBy(xpath = "//input[@name='submit']")
    private WebElement loginBtn;

    //Supplier<ManagementCompanyListingPage> doLogin=(user,pass)->{login(user,pass); return new ManagementCompanyListingPage()};


    BiFunction<String,String,ManagementCompanyListingPage> loginToSystem=(user,pass)->{
        login(user,pass);
        return new ManagementCompanyListingPage(driver);
    };

    BiFunction<String,String,PropertyHomePage> loginToSystemPropertyUser=(user,pass)->{
        login(user,pass);
        return new PropertyHomePage(driver);
    };

    private void doLogin(String username,String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginBtn.click();
    }



    public ManagementCompanyListingPage login(String username,String password) {
        doLogin(username,password);
        return new ManagementCompanyListingPage(driver);
    }


    public PropertyHomePage loginAsPropertyUser(String userName,String password){
        doLogin(userName,password);
        return new PropertyHomePage(driver);
    }


}
