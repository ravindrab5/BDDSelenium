package com.ideas.chimps.bddselenium.views;

import com.ideas.chimps.bddselenium.util.UIName;
import com.ideas.chimps.bddselenium.util.UIWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RoomAnalyticsReport extends PageBase{
    private UIWait uiWait;
    public RoomAnalyticsReport(EventFiringWebDriver driver) {
        super(driver);
        addWebElementMeta(this);
        uiWait=new UIWait(driver,30);
    }

    public List<String> getMetricOptionForPrimary(String columnName){
        uiWait.waitTillElementInVisibility(driver.findElement(By.id("wait")));
        uiWait.waitTillElementVisibility(driver.findElement(By.xpath("//th[span[text()='"+columnName+"']]")));

        List<WebElement> elements=driver.findElements(By.xpath("//table[thead[tr[th[span[text()='"+columnName+"']]]]]/thead/tr[2]/th[contains(@class,'is-fixed-left ember-view bg-sky')]"));
        List<String> allText= new ArrayList<>();
        List<WebElement> allElements=null;
        for(int i=0;i<elements.size();i++){
            allElements=driver.findElements(By.xpath("//table[thead[tr[th[span[text()='"+columnName+"']]]]]/thead/tr[2]/th[contains(@class,'is-fixed-left ember-view bg-sky')]"));
            allText.add(allElements.get(i).getText());
        }
        return allText;

    }
    @UIName(uiName="Statistics expand icon")
    @FindBy(xpath="//div[span[span[text()='Statistics']]]/span/i")
    private WebElement statisticsExpand;

    @UIName(uiName="Total expand icon")
    @FindBy(xpath="//div[span[span[text()='Total']]]/span/i")
    private WebElement totalExpand;

    @UIName(uiName = "All statistics options")
    @FindBys(@FindBy(xpath = "//tbody/tr[position()>1 and position()<11]/td[1]/div/div/span/span"))
    private List<WebElement> allStatisticsOptions;

    @UIName(uiName = "Category label")
    @FindBy(css=".category-bar-color span span")
    private List<WebElement> categories;

    @UIName(uiName = "List of segments")
    @FindBy(xpath="//tr[@class='et-tr ember-view category-bar-color']/following-sibling::tr[@class!='et-tr ember-view category-bar-color' and @class!='et-tr ember-view trWhiteLilac']/td[1]/div/div/span/span")
    private List<WebElement> segmentList;

    @UIName(uiName = "List of subcategory")
    @FindBy(xpath = "//tr[@class='et-tr ember-view category-bar-color']/following-sibling::tr[@class!='et-tr ember-view category-bar-color' and @class='et-tr ember-view trWhiteLilac']/td[1]/div/div/span/span")
    private List<WebElement> subcategoryList;

    public List<String> allColumnLabels(String colName){
        String xpath="//thead[tr[th[text()='"+colName+"']]]/tr[2]/th[position()>1]";
        return driver.findElements(By.xpath(xpath)).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> listofSubCateory(){
        return subcategoryList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void clickExpandTotal(){
        uiWait.waitTillElementVisibility(totalExpand);
        uiWait.waitTillElementClickable(totalExpand);
        totalExpand.click();
    }

    public List<String> getLIstOfSegment(){
        return segmentList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getCategoryList() {
        return categories.stream().map(WebElement::getText).map((n)->n.substring(5).trim()).collect(Collectors.toList());
    }

    public void expandStatistics(){

        uiWait.waitTillElementClickable(statisticsExpand);
        uiWait.waitTillElementVisibility(statisticsExpand);
        statisticsExpand.click();
    }

    public List<String> getAllStatisticsOptionInReport(){
        return allStatisticsOptions.stream().map(WebElement::getText).collect(Collectors.toList());
    }

}
