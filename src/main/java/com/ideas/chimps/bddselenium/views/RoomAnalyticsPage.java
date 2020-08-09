package com.ideas.chimps.bddselenium.views;

import com.ideas.chimps.bddselenium.util.UIName;
import com.ideas.chimps.bddselenium.util.UIWait;
import lombok.Getter;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

@Getter
public class RoomAnalyticsPage extends PageBase {
    private UIWait uiWait;

    public RoomAnalyticsPage(EventFiringWebDriver driver){
        super(driver);
        addWebElementMeta(this);
        uiWait=new UIWait(driver,30);
    }

    @UIName(uiName = "Criteria option button")
    @FindBy(css = ".btn.btn-action.btn-criteria-report")
    private WebElement criteriaOptionBtn;

    @UIName(uiName="Criteria Option Popup")
    @FindBy(xpath = "//div[@id='reportCriteria' and @style='display: block;']")
    private WebElement criteriaPopup;

    @UIName(uiName = "Date range")
    @FindBy(css="#commonCustomDatePicker p")
    private WebElement dateRangeText;

    @UIName(uiName = "Bread Crum impact event Name")
    @FindBy(xpath = "//li[span[text()='Impact Event Name:']]/div")
    private WebElement breadCrumImpactEventlabel;

    @UIName(uiName = "Display Criteria")
    @FindBy(linkText = "Display")
    private WebElement displayCriteria;

    public RoomAnalyticsDisplayCriteria openDisplayCriteria(){
        displayCriteria.click();
        return new RoomAnalyticsDisplayCriteria(driver);
    }

    public RoomAnalyticsDisplayCriteria clickDisplayCriteria(){
        displayCriteria.click();
        return new RoomAnalyticsDisplayCriteria(driver);
    }

    public String getDateText(){
        return dateRangeText.getText();
    }

    public boolean isCriteriaPopupDisplayed(){
        boolean isdisplay=false;
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            isdisplay = criteriaPopup.isDisplayed();
        }catch(NoSuchElementException e){
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            }
        return isdisplay;
    }

    public RoomAnalyticsReportCriteria openCriteria(){
            //throws MalformedURLException {
       if(!isCriteriaPopupDisplayed()){
           criteriaOptionBtn.click();
       }
     //   criteriaOptionBtn.click();
        uiWait.waitTillElementVisibility(criteriaPopup);
        uiWait.waitTillElementClickable(criteriaPopup);
        return new RoomAnalyticsReportCriteria(driver);
    }

    public RoomAnalyticsReportCriteria getCriteriaPopupIfOpen(){
        return new RoomAnalyticsReportCriteria(driver);
    }

}
