package com.ideas.chimps.bddselenium.views;

import com.ideas.chimps.bddselenium.util.UIName;
import com.ideas.chimps.bddselenium.util.UIWait;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class RoomAnalyticsDisplayCriteria extends PageBase {
    private UIWait uiWait;

    public RoomAnalyticsDisplayCriteria(EventFiringWebDriver driver) {
        super(driver);
        addWebElementMeta(this);
        uiWait=new UIWait(driver,30);
    }

    @UIName(uiName = "Room Nights Checkbox")
    @FindBy(xpath="//label[text()='Room Nights']/input")
    private WebElement roomNightsCheckbox;

    @UIName(uiName = "Average Rate Checkbox")
    @FindBy(xpath="//label[text()='Average Rate']/input")
    private WebElement averageRateCheckBox;

    @UIName(uiName = "Room Revenue Checkbox")
    @FindBy(xpath="//label[text()='Room Revenue']/input")
    private WebElement roomRevenueCheckBox;

    @UIName(uiName = "RevPar Checkbox")
    @FindBy(xpath="//label[text()='RevPar']")
    private WebElement revParCheckbox;

    @UIName(uiName = "%Contribution Checkbox")
    @FindBy(xpath="//label[text()='% Contribution']")
    private WebElement percentContributionCheckbox;

    @UIName(uiName = "Difference Radio")
    @FindBy(xpath="//label[text()='Difference']/input")
    private WebElement differenceRadio;

    @UIName(uiName = "Difference Radio")
    @FindBy(xpath="//label[text()='Variance %']/input")
    private WebElement variancePercent;

    @UIName(uiName = "Inventory Option Label")
    @FindBy(xpath="//label[text()='Inventory Options']")
    private WebElement inventoryOptionLabel;

    @UIName(uiName = "ADR Options Label")
    @FindBy(xpath="//label[text()='ADR Options']")
    private WebElement adrOptionLabel;

    @UIName(uiName = "Inventory Option Button")
    @FindBy(css=".inventoryOptionsSelect button span")
    private WebElement inventoryOptionButton;

    @UIName(uiName = "Inventory options list")
    @FindBys(@FindBy(css=".inventoryOptionsSelect label[class='checkbox']"))
    private List<WebElement> inventoryOptionList;

    @UIName(uiName = "Adr option button")
    @FindBy(css=".adrOptionsSelect button span")
    private WebElement adrOptionButton;

    @UIName(uiName = "Adr option list")
    @FindBys(@FindBy(css=".adrOptionsSelect label[class='checkbox']"))
    private List<WebElement> adrOptionList;

    @UIName(uiName = "Go button")
    @FindBy(css="#displayCriteria .chi-go")
    private WebElement goButton;

    @UIName(uiName="All Metrics option")
    @FindBy(css="#displayCriteria .reportrowcontent .mars-checkbox")
    private List<WebElement> allMetricsOption;

    @UIName(uiName = "Display criteria popup")
    @FindBy(css="#displayCriteria")
    private WebElement displayCriteriaPopup;

    public void waitTillDisplayCriteriaIsVisible(){
        uiWait.waitTillElementVisibility(displayCriteriaPopup);
    }

    public void waitTillDisplayCriteriaVisible(){
        uiWait.waitTillElementVisibility(roomNightsCheckbox);
        uiWait.waitTillElementClickable(roomNightsCheckbox);
    }

    public void selectAllMetricsOption(){
        allMetricsOption=driver.findElements(By.cssSelector("#displayCriteria .reportrowcontent .mars-checkbox"));
        allMetricsOption.stream().forEach((element)->{
            if(!element.isSelected()){
              //  uiWait.waitTillElementVisibility(element);
              //  uiWait.waitTillElementClickable(element);
                element.click();
            }
        });
    }


    public RoomAnalyticsReport clickGo(){
        uiWait.waitTillElementVisibility(goButton);
        uiWait.waitTillElementClickable(goButton);
        goButton.click();
        return new RoomAnalyticsReport(driver);
    }

    public void openInvetoryDropdown(){
        uiWait.waitTillElementClickable(inventoryOptionButton);
        uiWait.waitTillElementVisibility(inventoryOptionButton);
        inventoryOptionButton.click();
    }

    public void openAdrDropdown(){
        uiWait.waitTillElementClickable(adrOptionButton);
        uiWait.waitTillElementVisibility(adrOptionButton);
        adrOptionButton.click();
    }
    public List<String> getInventoryOptionsList(){
        return inventoryOptionList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getAdrOptions(){
        return adrOptionList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void selectAllInventoryOptions(){
        int length=inventoryOptionList.size();
        uiWait.waitTillElementVisibility(inventoryOptionList.get(0));
        for(int i=0;i<length;i++){
            driver.findElements(By.cssSelector(".inventoryOptionsSelect label[class='checkbox']")).get(i).click();
        }
    }

    public void selectAllAdrOptions(){
        int length=adrOptionList.size();
        uiWait.waitTillElementVisibility(adrOptionList.get(0));
        for(int i=0;i<length;i++){
            driver.findElements(By.cssSelector(".adrOptionsSelect label[class='checkbox']")).get(i).click();
        }
    }

    public void clickInventoryOptionButton(){
        uiWait.waitTillElementVisibility(inventoryOptionButton);
        uiWait.waitTillElementClickable(inventoryOptionButton);
        inventoryOptionButton.click();
    }

    public void clickAdrOptionButton(){
        uiWait.waitTillElementVisibility(adrOptionButton);
        uiWait.waitTillElementClickable(adrOptionButton);
        adrOptionButton.click();
    }
}
