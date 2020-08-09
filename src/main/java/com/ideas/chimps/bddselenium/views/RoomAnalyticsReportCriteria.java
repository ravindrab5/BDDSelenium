package com.ideas.chimps.bddselenium.views;

import com.ideas.chimps.bddselenium.actions.RoomAnalyticsReportCriteriaActions;
import com.ideas.chimps.bddselenium.util.UIName;
import com.ideas.chimps.bddselenium.util.UIWait;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class RoomAnalyticsReportCriteria extends PageBase {
    private UIWait uiWait;
    private RoomAnalyticsReportCriteriaActions actions;

    public RoomAnalyticsReportCriteria(EventFiringWebDriver driver) {
        super(driver);
        addWebElementMeta(this);
        uiWait=new UIWait(driver,30);
        actions=new RoomAnalyticsReportCriteriaActions(this);
    }

    @UIName(uiName = "Date Range")
    @FindBy(xpath = "//div[@id='commonCustomDatePicker']/div/span/i")
    private WebElement dateRange;

    @UIName(uiName = "Go button")
    @FindBy(css="#reportCriteria .btn-reportenter i")
    private WebElement goBtn;

    @UIName(uiName = "Report Criteria Sections")
    @FindBys(@FindBy(css="#reportCriteria .reportrowtitle span"))
    private List<WebElement> allSectionOfPrimaryData;

    @UIName(uiName = "Labels of Primary Data")
    @FindBys(@FindBy(xpath="//div[div[span[text()='Primary Data']]]/div/div/div/label"))
    private List<WebElement> allLabelsOfPrimaryData;

    @UIName(uiName = "Radios of Primary Data")
    @FindBys(@FindBy(xpath="//div[div[span[text()='Primary Data']]]/div/div/div/div/label/input"))
    private List<WebElement> allRadioOfPrimary;

    @UIName(uiName = "Comparative all dropdowns")
    @FindBys(@FindBy(css = ".report-row--comparative select"))
    private List<WebElement> comparativeAllDropDowns;

    @UIName(uiName = "Data Filter Labels")
    @FindBy(xpath="//div[div[span[text()='Data Filters']]]/div/div/div/label")
    private List<WebElement> dataFiltersLabels;

    @UIName(uiName = "Dow options")
    @FindBy(css=".daysofweek-select label")
    private List<WebElement> dowOptions;

    @UIName(uiName = "Dow dropdown")
    @FindBy(css=".daysofweek-select button span")
    private WebElement dayofWeekDropDown;

    @UIName(uiName = "Calender Label")
    @FindBy(css="#reportCriteria .reportrowcontent p")
    private WebElement calenderLabel;

    @UIName(uiName="Impact Event Year dropdown")
    @FindBy(css = ".impact-event-years-list")
    private WebElement impactEventYear;

    @UIName(uiName = "Impact Event List DropDown")
    @FindBy(css=".impactEvent.impact-event")
    private WebElement impactEventListSelect;

    @UIName(uiName = "Impact Event Lable")
    @FindBy(xpath = "//div[@class='report-row']/div[2]/div[1]/div[2]/label")
    private WebElement impactEventLabel;

    @UIName(uiName = "Slider Miniumum")
    @FindBy(css=".rangesliderwrap .irs-from")
    private WebElement sliderMinimum;

    @UIName(uiName = "Slider Maximum")
    @FindBy(css=".rangesliderwrap .irs-to")
    private WebElement sliderMax;

    @UIName(uiName = "Category drop down")
    @FindBy(css=".categoriesSelect button span")
    private WebElement categoryDropDown;

    @UIName(uiName = "Sub category drop down")
    @FindBy(css=".subTotalSelect button span")
    private WebElement subTotalDropDown;

    @UIName(uiName = "Segment dropdown")
    @FindBy(css=".segmentsSelect button span")
    private WebElement segmentSelectDropDown;

    @UIName(uiName = "Category Options")
    @FindBy(css=".categoriesSelect .multiselect-container label")
    private List<WebElement> categoriesSelectOptions;

    @UIName(uiName = "Sub total options")
    @FindBy(css=".segmentsSelect .multiselect-container label")
    private List<WebElement> subTotalsOptions;

    @UIName(uiName = "Segment selection options")
    @FindBy(css=".segmentsSelect .multiselect-container label")
    private List<WebElement> segmentSelectoptions;

    @UIName(uiName = "Same Range dropdown")
    @FindBy(css = ".compDataSameRangeSelect button")
    private WebElement sameRangeDropdown;

    @UIName(uiName = "Same Range options")
    @FindBy(css = ".compDataSameRangeSelect .multiselect-container li label[class='checkbox']")
    private List<WebElement> sameRangeOptions;

    @UIName(uiName = "Same Range Selected text")
    @FindBy(css = ".compDataSameRangeSelect .multiselect-selected-text")
    private WebElement sameRangeSelectedText;

    @UIName(uiName = "Prior year dropdown button")
    @FindBy(css = ".priorYearStlySelect button")
    private WebElement priorYearDropDown;

    @UIName(uiName = "PriorYear dropdown options")
    @FindBy(css = ".priorYearStlySelect .multiselect-container li label[class='checkbox']")
    private List<WebElement> priorYearOptions;

    @UIName(uiName = "PriorYear Selected text")
    @FindBy(css = ".priorYearStlySelect .multiselect-selected-text")
    private WebElement priorYearSelectText;

    @UIName(uiName = "PriorYear One dropdown button")
    @FindBy(css=".priorYearStlySelect2 button")
    private WebElement priorYearOneDropdown;

    @UIName(uiName = "PriorYear One options")
    @FindBy(css=".priorYearStlySelect2 .multiselect-container li label[class='checkbox']")
    private  List<WebElement> priorYearOneOptions;

    @UIName(uiName = "PriorYear Selected text")
    @FindBy(css = ".priorYearStlySelect2 .multiselect-selected-text")
    private WebElement priorYearOneSelectText;

    @UIName(uiName = "Impact Event Yar Dropdown")
    @FindBy(css=".yearselect.mars-select button")
    private WebElement impactEventYearDropDown;

    @UIName(uiName = "Select from impact event year")
    @FindBys(@FindBy(css=".yearselect.mars-select label"))
    private List<WebElement> impactEventYearOptions;

    @UIName(uiName = "Select impact event dropdown")
    @FindBy(css=".impactEventSelect button")
    private WebElement selectImpactEventDropdown;

    @UIName(uiName = "Select impact Event instance ")
    @FindBy(css=".impactEventSelect label")
    private List<WebElement> impactEventList;

    @UIName(uiName = "Report criteria go button")
    @FindBy(css=".criteria-report .chi-go")
    private WebElement reportCriteriaGoButton;

    public void selectImpactEventList(String impacteventName){
        int size=impactEventList.size();
        for(int i=0;i<size;i++){
            List<WebElement> impactEvents=driver.findElements(By.cssSelector(".impactEventSelect label"));
            if(impactEvents.get(i).getText().equals(impacteventName)){
                impactEvents.get(i).click();
                break;
            }
        }
    }

    public RoomAnalyticsReport clickGoButton(){ // supplier
        goBtn.click();
        return new RoomAnalyticsReport(driver);
    }

    public List<String> getListOfImpactEventForSelectedYear(){ // supplier
        return impactEventList.stream().filter((n)->!n.getText().equals("Select Impact Event")).map(WebElement::getText).collect(Collectors.toList());
    }

    public void selectImpactEventListDropdown(){
        selectImpactEventDropdown.click();
    }

    public void selectImpactEventYear(String year){

        impactEventYearOptions.stream().forEach((n)->{
            if(n.getText().trim().equals(year)){
                n.click();
            }
        });
    }

    /*public void clickSameRangeDropDown(){
        uiWait.waitTillElementVisibility(sameRangeDropdown);
        uiWait.waitTillElementClickable(sameRangeDropdown);
        sameRangeDropdown.click();
    }*/

    public void clickImpactEventYearDropDown(){
        impactEventYearDropDown.click();
    }

    /*public String getPriorYearSelectedText(){
        return priorYearSelectText.getText();
    }*/ // supplier

    public String getPriorYearOneSelectedText(){
        return priorYearOneSelectText.getText();
    } // supplier

    public void selectAllFromPriorYearOption(){
        int size=priorYearOptions.size();
        for(int i=0;i<size;i++){
            List<WebElement> elements=driver.findElements(By.cssSelector(".priorYearStlySelect .multiselect-container li label[class='checkbox']"));
            uiWait.waitTillElementVisibility(elements.get(i));
            uiWait.waitTillElementClickable(elements.get(i));
            elements.get(i).click();
        }
     }

    public void selectAllFromPriorYearOneOption(){
        int size=priorYearOneOptions.size();
        for(int i=0;i<size;i++){
            List<WebElement> elements=driver.findElements(By.cssSelector(".priorYearStlySelect2 .multiselect-container li label[class='checkbox']"));
            uiWait.waitTillElementVisibility(elements.get(i));
            uiWait.waitTillElementClickable(elements.get(i));
            elements.get(i).click();
        }
    }

    public void selectOptionInSameRange(String option){
         sameRangeOptions.forEach((element->{if(element.getText().equals(option)){element.click();};}));
    }

    public void selectOptionInPriorYear(String option){
        priorYearOptions.forEach((n)->{
            if(n.getText().equals(option)){
                n.click();
            }
        });
    }



    public void clickPriorYearDropDown(){
        uiWait.waitTillElementVisibility(priorYearDropDown);
        uiWait.waitTillElementClickable(priorYearDropDown);
        try {
            priorYearDropDown.click();
        }catch(WebDriverException we){

            try {
                Thread.sleep(2000);
            }catch (Exception e){

            }
            priorYearDropDown.click();
        }

    }

    public void clickPriorYearOneDropDown(){
        uiWait.waitTillElementVisibility(priorYearOneDropdown);
        uiWait.waitTillElementClickable(priorYearOneDropdown);
        priorYearOneDropdown.click();
    }

    public String getSameRangeSelectedText(){
        return sameRangeSelectedText.getText();
    } // supplier

    public boolean hasNoSameRangeOption(String text){  //predicate
        return !sameRangeOptions.stream().map(WebElement::getText).collect(Collectors.toList()).contains(text);
    }

    public void selectAllFromSameRange(){
        sameRangeOptions.forEach(WebElement::click);
        sameRangeDropdown.click();
    }



    public void clickSameRangeDropDown(){
        uiWait.waitTillElementVisibility(sameRangeDropdown);
        uiWait.waitTillElementClickable(sameRangeDropdown);
        uiWait.waitTillElementClickable(sameRangeDropdown);
        sameRangeDropdown.click();
    }

    public List<String> getCategoryOptions(){ // supplier
        List<String> categoryLabel=new ArrayList<>();
        categoriesSelectOptions.stream().forEach((n)->{categoryLabel.add(n.getText().trim());});
        return categoryLabel;
    }

    public List<String> getSegementOptions(){ // supplier
        List<String> segmentOptions=new ArrayList<>();
        segmentSelectoptions.stream().forEach((n)->{segmentOptions.add(n.getText().trim());});
        return segmentOptions;
    }

    public String getSliderMinimum() { // supplier
        return sliderMinimum.getText();
    }

    public String getSliderMax() { // supplier
        return sliderMax.getText();
    }

    public List<String> getAllLabelsofPrimaryRadio(){ // supplier
        List<String> listOfLabels=new ArrayList<>();
        allLabelsOfPrimaryData.stream().forEach((n)->{listOfLabels.add(n.getText());});
        return listOfLabels;
    }

    public List<WebElement> allSectionOfPrimaryData() { // supplier
        return allSectionOfPrimaryData;
    }

    public List<String> getDowOptions() {  // supplier
        List<String> data=new ArrayList<>();
        dowOptions.stream().forEach((n)->{data.add(n.getText());});
        return data;
    }

    public void clickDayOfWeekDropDown(){
        uiWait.waitTillElementVisibility(dayofWeekDropDown);
        uiWait.waitTillElementClickable(dayofWeekDropDown);
        dayofWeekDropDown.click();
    }

    public List<String> getListDataFilterLabelsString(){ // supplier
        List<String> listOfDataFilterLabels=new ArrayList<>();
        dataFiltersLabels.stream().forEach((n)->{listOfDataFilterLabels.add(n.getText());});
        return listOfDataFilterLabels;
    }

    public List<WebElement> getDataFiltersLabels() { // supplier
        return dataFiltersLabels;
    }

    public boolean isAllDropdownOfComparativeEnabled(){ // supplier
        boolean areAllDisabled=false;
        for(WebElement element:comparativeAllDropDowns){
            areAllDisabled=areAllDisabled || element.isEnabled();
        }
        return areAllDisabled;
    }

    public boolean isAnyOfPrimaryRadioSelected(){ // supplier
        boolean isselected=false;
        for(WebElement element:allRadioOfPrimary){
            isselected= isselected || element.isSelected();
        }
        return isselected;
    }

    public String getCalenderLabel() { // supplier
        return calenderLabel.getText();
    }


    public WebElement getImpactEventYear() { // supplier
        return impactEventYear;
    }

    public WebElement getImpactEventListSelect() { // supplier
        return impactEventListSelect;
    }

    public String getImpactEventLabel() { // supplier
        return impactEventLabel.getText();
    }

    public CalenderPop clickOnPrimaryDateRange() { // supplier
        dateRange.click();
        return new CalenderPop(driver);
    }

    public void selectPrimaryData(String dataType){
        String xpath="//div[@data-type='"+dataType.toUpperCase()+"']";
        uiName.put(xpath,dataType + "selected");
        driver.findElement(By.xpath(xpath)).click();
    }

    public boolean isPrimarySelected(String dataType){ //predicate
        String xpath="//div[label[input[@type='radio']]]/label[text()='"+dataType+"']";
        return driver.findElement(By.xpath(xpath)).isSelected();
    }

    public RoomAnalyticsPage clickGo(){ // supplier
        goBtn.click();
        return new RoomAnalyticsPage(driver);
    }

    public List<WebElement> getAllSectionOfPrimaryData() { // supplier
        return allSectionOfPrimaryData;
    }

    public List<String> getAllSectionsLabelString(){ // supplier
        List<String> labels=new ArrayList<>();
        allSectionOfPrimaryData.stream().forEach((n)->{labels.add(n.getText());});
        return labels;
    }

}

