package com.ideas.chimps.bddselenium.views;


import com.ideas.chimps.bddselenium.util.UIName;
import lombok.Getter;
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

    @UIName(uiName = "REVENUE ANALYTICS")
    @FindBy(xpath="//a[text()='Revenue Analytics']")
    private WebElement revAnalyticsOptionInPlanning;

    @UIName(uiName = "ROOMS")
    @FindBy(xpath="//li[a[text()='Revenue Analytics']]/ul/li/a[text()='Rooms']")
    private WebElement roomsInRevAnalyticsOfPlanning;

    public RoomTrendDashBoard navigateToRoomTrend(){
        Actions actions=new Actions(driver);
        actions.moveToElement(planningButton).moveToElement(revAnalyticsOptionInPlanning).moveToElement(roomsInRevAnalyticsOfPlanning).click().build().perform();
        return new RoomTrendDashBoard(driver);
    }

}
