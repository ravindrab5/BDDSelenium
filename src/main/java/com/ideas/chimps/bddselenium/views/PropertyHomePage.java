package com.ideas.chimps.bddselenium.views;


import com.ideas.chimps.bddselenium.util.UIName;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.MalformedURLException;

@Getter
public class PropertyHomePage extends PageBase {


    public PropertyHomePage(EventFiringWebDriver driver){
        super(driver);
        addWebElementMeta(this);
    }

    @UIName(uiName = "PLANNING BUTTON")
    @FindBy(xpath="//a[text()='Planning']")
    private WebElement planningButton;

    @UIName(uiName = "INTEL BUTTON")
    @FindBy(xpath="//a[text()='Intel']")
    private WebElement intelButton;

    @UIName(uiName = "ACCOUNTS SUBMENU")
    @FindBy(xpath="//li[a[text()='Accounts']]/ul/li/a[text()='Accounts']")
    private WebElement accountsSubmenu;

    @UIName(uiName = "ACCOUNTS MENU")
    @FindBy(xpath="//a[text()='Accounts']")
    private WebElement accountsInmenu;



    @UIName(uiName = "REVENUE ANALYTICS")
    @FindBy(xpath="//a[text()='Revenue']")
    private WebElement revAnalyticsOptionInPlanning;

    @UIName(uiName = "ROOMS")
    @FindBy(xpath="//li[a[text()='Revenue']]/ul/li/a[text()='Rooms']")
    private WebElement roomsInRevAnalyticsOfPlanning;

    @UIName(uiName = "PRODUCTION")
    @FindBy(xpath = "//li[a[text()='Accounts']]/ul/li/a[text()='Production']")
    private WebElement productionSubMenu;

    public RoomTrendDashBoard navigateToRoomTrend(){
        Actions actions=new Actions(driver);
        actions.moveToElement(planningButton).moveToElement(revAnalyticsOptionInPlanning).moveToElement(roomsInRevAnalyticsOfPlanning).click().build().perform();
        return new RoomTrendDashBoard(driver);
    }

    public ProfileManagementPage navigateToAccounts(){
        Actions actions=new Actions(driver);
        actions.moveToElement(intelButton).moveToElement(accountsInmenu).moveToElement(accountsSubmenu).click().build().perform();
        actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Profile Status')]"))).build().perform();
        return new ProfileManagementPage(driver);
    }

    public AccountSummaryReportPage navigateToProduction(){
        Actions actions=new Actions(driver);
        actions.moveToElement(intelButton).moveToElement(accountsInmenu).moveToElement(productionSubMenu).click().build().perform();
        return new AccountSummaryReportPage(driver);
    }

}
