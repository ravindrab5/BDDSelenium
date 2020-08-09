package com.ideas.chimps.bddselenium.views;


import com.ideas.chimps.bddselenium.util.UIName;
import com.ideas.chimps.bddselenium.util.UiLocalDateUtil;
import com.ideas.chimps.bddselenium.util.Wait;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.time.LocalDate;


@Getter
public class CalenderPop extends PageBase {
    Wait wait;


    public CalenderPop(EventFiringWebDriver driver){
        super(driver);
        addWebElementMeta(this);
        wait=new Wait(driver,30);
    }

    @UIName(uiName = "Calender Popup")
    @FindBy(xpath = "//div[@class='reportpopup comparerangepopup customdaterange' and @style='display: block;']")
    private WebElement calenderPopup;

    @UIName(uiName = "Calender closeBtn")
    @FindBy(css=".btn-popupclose")
    private WebElement calenderCloseBtn;

    @UIName(uiName = "Start Calender Prev")
    @FindBy(xpath="//div[input[@name='start']]/div[1]/div[3]/table/thead/tr/th[@class='prev']")
    private WebElement startCalenderPrevBtn;

    @UIName(uiName = "Start Calender Next")
    @FindBy(xpath = "//div[input[@name='start']]/div[1]/div[3]/table/thead/tr/th[@class='next']")
    private WebElement startCalenderNextBtn;

    @UIName(uiName = "Start Calender Month datepicker-switch")
    @FindBy(xpath="//div[input[@name='start']]/div[1]/div[1]/table/thead/tr/th[@class='datepicker-switch']")
    private WebElement startCalenderMonthPickerSwitch;

    @UIName(uiName = "Start Calender year picker switch")
    @FindBy(xpath = "//div[input[@name='start']]/div[1]/div[2]/table/thead/tr/th[@class='datepicker-switch']")
    private WebElement startCalenderYearPickerSwitch;

    @UIName(uiName = "End Calender month datepicker-switch")
    @FindBy(xpath="//div[input[@name='end']]/div[2]/div[1]/table/thead/tr/th[@class='datepicker-switch']")
    private WebElement endCalenderMonthDatePickerSwitch;

    @UIName(uiName = "End Calender year picker switch")
    @FindBy(xpath = "//div[input[@name='end']]/div[2]/div[2]/table/thead/tr/th[@class='datepicker-switch']")
    private WebElement endCalenderYearPickerSwitch;


    public void selectDateRange(LocalDate startDate,LocalDate endDate){
        UiLocalDateUtil dateUtil=new UiLocalDateUtil(startDate,endDate);
        String xpath_startday="//div[input[@name='start']]/div[1]/div[1]/table/tbody/tr/td[@class='day' and text()="+startDate.getDayOfMonth()+"]";
        uiName.put(xpath_startday,"Start Day");

        String xpath_enday="//div[input[@name='end']]/div[2]/div[1]/table/tbody/tr/td[@class='day' and text()="+endDate.getDayOfMonth()+"]";
        uiName.put(xpath_enday,"End Day");

        String xpath_startMonth="//div[input[@name='start']]/div[1]/div[2]/table/tbody/tr/td/span[contains(@class,'month') and text()='"+dateUtil.getMonth(startDate.getMonthValue())+"']";
        uiName.put(xpath_startMonth,"Start Month");

        String xpath_endMonth="//div[input[@name='end']]/div[2]/div[2]/table/tbody/tr/td/span[contains(@class,'month') and text()='"+dateUtil.getMonth(endDate.getMonthValue())+"']";
        uiName.put(xpath_endMonth,"End month");

        String xpath_startselectYear="//div[input[@name='start']]/div[1]/div[3]/table/tbody/tr/td/span[contains(@class,'year') and text()="+startDate.getYear()+"]";
        uiName.put(xpath_startselectYear,"Start year");

        String xpath_endselectYear="//div[input[@name='start']]/div[2]/div[3]/table/tbody/tr/td/span[contains(@class,'year') and text()="+endDate.getYear()+"]";
        uiName.put(xpath_endselectYear,"End year");


    // todo
    int next_click=dateUtil.getNoOfNextClicksForYear();
    int prev_click=dateUtil.getNoOfPrevClicksForYear();
    if(next_click==0 && prev_click==0){
        wait.waitTillElementVisibility(startCalenderMonthPickerSwitch);
        startCalenderMonthPickerSwitch.click();
        wait.waitTillElementVisibility(startCalenderYearPickerSwitch);
        startCalenderYearPickerSwitch.click();
        driver.findElement(By.xpath(xpath_startselectYear)).click();
        driver.findElement(By.xpath(xpath_startMonth)).click();
        driver.findElement(By.xpath(xpath_startday)).click();
    }else if(prev_click!=0){
        wait.waitTillElementVisibility(startCalenderMonthPickerSwitch);
        startCalenderMonthPickerSwitch.click();
        wait.waitTillElementVisibility(startCalenderYearPickerSwitch);
        startCalenderYearPickerSwitch.click();
        for(int i=0;i<prev_click;i++){startCalenderPrevBtn.click();}

        driver.findElement(By.xpath(xpath_startselectYear)).click();
        driver.findElement(By.xpath(xpath_startMonth)).click();
        driver.findElement(By.xpath(xpath_startday)).click();
    }else {
        wait.waitTillElementVisibility(startCalenderMonthPickerSwitch);
        startCalenderMonthPickerSwitch.click();
        wait.waitTillElementVisibility(startCalenderYearPickerSwitch);
        startCalenderYearPickerSwitch.click();
        for(int i=0;i<next_click;i++){startCalenderNextBtn.click();}

        driver.findElement(By.xpath(xpath_endselectYear)).click();
        driver.findElement(By.xpath(xpath_startMonth)).click();
        driver.findElement(By.xpath(xpath_startday)).click();
    }

        wait.waitTillElementVisibility(endCalenderMonthDatePickerSwitch);
    endCalenderMonthDatePickerSwitch.click();

        wait.waitTillElementVisibility(endCalenderYearPickerSwitch);
        endCalenderYearPickerSwitch.click();
    driver.findElement(By.xpath(xpath_endselectYear)).click();
    driver.findElement(By.xpath(xpath_endMonth)).click();
    driver.findElement(By.xpath(xpath_enday)).click();

    }

}
