package com.ideas.chimps.bddselenium.views;


import com.ideas.chimps.bddselenium.util.UIName;
import com.ideas.chimps.bddselenium.util.UIWait;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.MalformedURLException;

@Getter
public class RoomTrendDashBoard extends PageBase {
    private UIWait wait;

    public RoomTrendDashBoard(EventFiringWebDriver driver){
        super(driver);
        addWebElementMeta(this);
        wait=new UIWait(driver,30);
    }

    @UIName(uiName = "Room Analytics ScoreCard")
    @FindBy(xpath = "//div[@class='ember-view']/div/h3[text()='Rooms Analytics']")
    private WebElement roomAnalyticsScorecard;

    public RoomAnalyticsPage clickRoomAnalyticsScorecard() {
        wait.waitTillElementVisibility(roomAnalyticsScorecard);
        wait.waitTillElementClickable(roomAnalyticsScorecard);
        roomAnalyticsScorecard.click();
        wait.waitTillUrlContains("/rooms-analytics");
        return new RoomAnalyticsPage(driver);
    }
}
