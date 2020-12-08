package com.ideas.chimps.bddselenium.views;

import com.ideas.chimps.bddselenium.util.UIName;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class AccountSummaryReportPage extends PageBase {

    public AccountSummaryReportPage(EventFiringWebDriver driver) {
        super(driver);
        addWebElementMeta(this);
    }

    private static final String TITLE_ATTRIBUTE = "title";
    private static final String ACCOUNT_SUMMARY_SCORECARD="//div[contains(@class,'score-card-new')]//h3[contains(text(),'Account Summary')]";
    private static final String ACCOUNT_SUMMARY_CRITERIA_ICON = "(//i[contains(@class,'chi-arrowright icon-medium icon-r0')])[1]";
    private static final String REPORT_CRITERIA_HEADER = "//h2[text()='Report Criteria']";
    private static final String DATE_RANGE_CALENDAR_ICON = "//span[contains(@class,'btn-calendar')]//i";
    private static final String CALENDAR_DATE_RANGE_HEADER = "//h2[contains(text(),'Date Range')]";
    private static final String VOLUME_METRICS_SELECT_BUTTON = "//div[contains(@class,'mars-select volume-metrics-select')]//span//div[contains(@class,'btn-group')]//button/span";
    private static final String VOLUME_METRICS_LIST = "//div[contains(@class,'mars-select volume-metrics-select')]//span//div[contains(@class,'btn-group')]//li//label[@class='checkbox']";
    private static final String VOLUME_METRICS_LIST_SELECT = "//div[contains(@class,'mars-select volume-metrics-select')]//span//div[contains(@class,'btn-group')]//li//label[@title='string']";
    private static final String ROOM_REV_METRICS_SELECT_BUTTON = "//div[contains(@class,'mars-select revenue-metrics-select')]//span//div[contains(@class,'btn-group')]//button/span";
    private static final String ROOM_REV_METRICS_LIST = "((//div[contains(@class,'mars-select revenue-metrics-select')])[1])//span//div[contains(@class,'btn-group')]//li//label[@class='checkbox']";
    private static final String ACCOUNT_TYPE_SELECT_BUTTON = "//div[contains(@class,'account-type-select')]//span//div[contains(@class,'btn-group')]//button/span";
    private static final String ACCOUNT_TYPE_LIST = "//div[contains(@class,'account-type-select')]//span//div[contains(@class,'btn-group')]//li//label[@class='radio']";
    private static final String ACCOUNT_TYPE_SELECT=".account-type";
    private static final String ACCOUNT_TYPE_SELECTED = "//div[contains(@class,'account-type-select')]//span//div[contains(@class,'btn-group')]//li[@class='active']//label[@class='radio']";
    private static final String ACCOUNT_HIERARCHY_SELECT_BUTTON = "//div[contains(@class,'profile-view-select')]//span//div[contains(@class,'btn-group')]//button/span";
    private static final String ACCOUNT_HIERARCHY_LIST = "//div[contains(@class,'profile-view-select')]//span//div[contains(@class,'btn-group')]//li//label[@class='radio']";
    private static final String ACCOUNT_HIERARCHY_DROPDOWN_SELECT="//select[contains(@class,'hierarchy')]";
    private static final String ACCOUNT_HIERARCHY_SELECTED = "//div[contains(@class,'profile-view-select')]//span//div[contains(@class,'btn-group')]//li[@class='active']//label[@class='radio']";
    private static final String ACCOUNT_NAME_SEARCH_BUTTON_DROP_DOWN=".account-select .multiselect-selected-text";
    private static final String SEARCH_FIELD="//input[@placeholder='Search..']";
    private static final String SEARCH_RESULT=".account-select .multiselect-container label";
    private static final String DOW_DROP_DOWN_BUTTON=".days-of-week-select .multiselect-selected-text";
    private static final String DOW_DROPDOWN_SELECT = "//select[contains(@class,'week-configuration')]//optgroup[@label='string']//option";
    private static final String DOW_SELECT_LIST="//select[contains(@class,'daysOfWeek')]";
    private static final String DOW_LIST_DEFAULT_TEXT = "//div[contains(@class,'days-of-week-select')]//div[contains(@class,'btn-group')]//button[contains(@class,'btn-default')]//span";
    private static final String MKT_SEG_LIST_DEFAULT_TEXT = "//div[contains(@class,'segment-select')]//div[contains(@class,'btn-group')]//button[contains(@class,'btn-default')]//span";
    private static final String MKT_SEG_DROP_DOWN_BUTTON=".segment-select .multiselect-selected-text";
    private static final String MKT_SEG_DROPDOWN_SELECT = "//select[contains(@class,'pmsSegmentSelect')]//optgroup[@label='string']//option";
    private static final String MKT_SEG_SELECT_DROPDOWN=".RmRev-Metrics-List";
    private static final String LEAD_TIME_INPUT=".form-group .inputrange input";
    private static final String MKT_SEG_SELECT=".pmsSegmentSelect.configuration-list";
    private static final String REPORT_CRITERIA_GO_BUTTON =".chi-go";
    private static final String TOTAL_REV_METRICS_SELECT_BUTTON = "//span[select[contains(@class,'fnbTotalRev-Metrics-List')]]/div/button"; // matching multiple dropdowns
    private static final String TOTAL_REV_METRICS_LIST = "//span[select[contains(@class,'fnbTotalRev-Metrics-List')]]/div/ul/li/a/label"; // matching more elements
    private static final String TOTAL_REV_METRICS_SELECT_DROPDOWN=".fnbTotalRev-Metrics-List";
    private static final String PRODUCTION_INPUT_FROM="//div[div[label[text()='Production']]]/div/input[1]";
    private static final String PRODUCTION_INPUT_TO="//div[div[label[text()='Production']]]/div/input[2]";
    private static final String PRODUCTION_DROPDOWN_BUTTON=".volume-select button";
    private static final String PRODUCTION_SELECT=".volume-select select";
    private static final String SEARCH_BUTTON=".account-select .multiselect-selected-text";
    private static final String SEARCH_ALL_PROFILE_OPTION=".account-select .checkbox.bold";
    private static final String OCC_FROM_SLIDER=".rangesliderwrap .irs-from";
    private static final String OCC_TO_SLIDER=".rangesliderwrap .irs-to";
    private static final String ALL_BREADCRUMB_TEXT=".criteria-bread-crumb li";
    private static final String BREADCRUMB_SLICE_TEXT ="//li[span[contains(text(),'string')]]/div";
    private static final String IMPACT_EVENT_YEAR_BTN=".year-select button";
    private static final String SELECT_IMPACT_EVENT_YEAR_DROPDOWN = "//select[@class='multiselect-list form-control impact-event-years-list']";
    private static final String IMPACT_EVENT_BTN="//span[text()='Select Impact Event']";
    private static final String SELECT_IMPACT_EVENT_DROPDOWN ="//select[@class='multiselect-list form-control impactEvent impact-event']";
    private static final String CALENDER_LABEL="#commonCustomDatePicker p";
    private static final String GRID_COLUMN_HEADERS = "(//div[contains(@class,'account-summary-table')]//tr)[1]//th";
    private static final String WAIT_SPINNER="wait";
    private static final String SELECT_IMPACTEVENT_NAME="//li[a[label[b[contains(text(),'string')]]]]/following-sibling::li[1]";

    @UIName(uiName = "WAIT_SPINNER")
    @FindBy(how= How.ID,using=WAIT_SPINNER)
    private WebElement waitSpinner;

    @UIName(uiName = "ACCOUNT_SUMMARY_SCORECARD")
    @FindBy(how= How.XPATH,using=ACCOUNT_SUMMARY_SCORECARD)
    private WebElement accountSummaryScoreCard;

    @UIName(uiName = "ACCOUNT_SUMMARY_CRITERIA_ICON")
    @FindBy(how = How.XPATH, using = ACCOUNT_SUMMARY_CRITERIA_ICON)
    private WebElement reportCriteriaIcon;

    @UIName(uiName = "DATE_RANGE_CALENDAR_ICON")
    @FindBy(how = How.XPATH, using = DATE_RANGE_CALENDAR_ICON)
    private WebElement dateRangeCalendarIcon;

    @UIName(uiName = "VOLUME_METRICS_SELECT_BUTTON")
    @FindBy(how = How.XPATH, using = VOLUME_METRICS_SELECT_BUTTON)
    private WebElement volumeMetricsSelectButton;

    @UIName(uiName = "VOLUME_METRICS_LIST")
    @FindBy(how = How.XPATH, using = VOLUME_METRICS_LIST)
    private List<WebElement> volumeMetricsList;

    @UIName(uiName = "ROOM_REV_METRICS_SELECT_BUTTON")
    @FindBy(how = How.XPATH, using = ROOM_REV_METRICS_SELECT_BUTTON)
    private WebElement roomRevMetricsSelectButton;

    @UIName(uiName = "ROOM_REV_METRICS_LIST")
    @FindBy(how = How.XPATH, using = ROOM_REV_METRICS_LIST)
    private List<WebElement> roomRevMetricsList;

    @UIName(uiName = "ACCOUNT_TYPE_SELECT_BUTTON")
    @FindBy(how = How.XPATH, using = ACCOUNT_TYPE_SELECT_BUTTON)
    private WebElement accountTypeSelectButton;

    @UIName(uiName = "ACCOUNT_TYPE_LIST")
    @FindBy(how = How.XPATH, using = ACCOUNT_TYPE_LIST)
    private List<WebElement> accountTypeList;

    @UIName(uiName = "ACCOUNT_TYPE_SELECT")
    @FindBy(how=How.CSS,using=ACCOUNT_TYPE_SELECT)
    private WebElement accountTypeSelect;

    @UIName(uiName = "ACCOUNT_TYPE_SELECTED")
    @FindBy(how = How.XPATH, using = ACCOUNT_TYPE_SELECTED)
    private WebElement accountTypeSelected;

    @UIName(uiName = "ACCOUNT_HIERARCHY_SELECT_BUTTON")
    @FindBy(how = How.XPATH, using = ACCOUNT_HIERARCHY_SELECT_BUTTON)
    private WebElement accountHierarchySelectButton;

    @UIName(uiName = "ACCOUNT_HIERARCHY_LIST")
    @FindBy(how = How.XPATH, using = ACCOUNT_HIERARCHY_LIST)
    private List<WebElement> accountHierarchyList;

    @UIName(uiName = "ACCOUNT_HIERARCHY_SELECTED")
    @FindBy(how = How.XPATH, using = ACCOUNT_HIERARCHY_SELECTED)
    private WebElement accountHierarchySelected;

    @UIName(uiName = "ACCOUNT_HIERARCHY_DROPDOWN_SELECT")
    @FindBy(how=How.XPATH,using = ACCOUNT_HIERARCHY_DROPDOWN_SELECT)
    private WebElement accountHierarchySelectDropDown;

    @UIName(uiName = "ACCOUNT_NAME_SEARCH_BUTTON_DROP_DOWN")
    @FindBy(how=How.CSS,using = ACCOUNT_NAME_SEARCH_BUTTON_DROP_DOWN)
    private WebElement accountNameSearchButtonDropdown;

    @UIName(uiName = "SEARCH_FIELD")
    @FindBy(how=How.XPATH,using = SEARCH_FIELD)
    private WebElement searchField;

    @UIName(uiName = "DOW_DROP_DOWN_BUTTON")
    @FindBy(how=How.CSS,using = DOW_DROP_DOWN_BUTTON)
    private WebElement dowDropdownButton;

    @UIName(uiName = "DOW_LIST_DEFAULT_TEXT")
    @FindBy(how=How.XPATH,using = DOW_LIST_DEFAULT_TEXT)
    private WebElement dowDropdownDefaultText;

    @UIName(uiName = "DOW_SELECT_LIST")
    @FindBy(how = How.XPATH,using = DOW_SELECT_LIST)
    private WebElement dowSelectDropDown;

    @UIName(uiName = "MKT_SEG_LIST_DEFAULT_TEXT")
    @FindBy(how=How.XPATH,using = MKT_SEG_LIST_DEFAULT_TEXT)
    private WebElement mktSegmentDropdownDefaultText;

    @UIName(uiName = "MKT_SEG_DROP_DOWN_BUTTON")
    @FindBy(how=How.CSS,using = MKT_SEG_DROP_DOWN_BUTTON)
    private WebElement mktSegDropdownButton;

    @UIName(uiName = "MKT_SEG_SELECT")
    @FindBy(how=How.CSS,using=MKT_SEG_SELECT)
    private WebElement mktSegmentSelect;

    @UIName(uiName = "MKT_SEG_SELECT_DROPDOWN")
    @FindBy(how=How.CSS,using=MKT_SEG_SELECT_DROPDOWN)
    private WebElement mktSegmentSelectDropdown;

    @UIName(uiName = "LEAD_TIME_INPUT")
    @FindBy(how=How.CSS,using = LEAD_TIME_INPUT)
    private List<WebElement> leadTimeInput;

    @UIName(uiName = "REPORT_CRITERIA_GO_BUTTON")
    @FindBy(how=How.CSS,using = REPORT_CRITERIA_GO_BUTTON)
    private WebElement reportCriteriaGoButton;

    @UIName(uiName = "PRODUCTION_INPUT_FROM")
    @FindBy(how=How.XPATH,using = PRODUCTION_INPUT_FROM)
    private WebElement productionFromField;

    @UIName(uiName = "PRODUCTION_INPUT_TO")
    @FindBy(how=How.XPATH,using = PRODUCTION_INPUT_TO)
    private WebElement productionInputToField;

    @UIName(uiName = "SEARCH_BUTTON")
    @FindBy(how=How.CSS,using = SEARCH_BUTTON)
    private WebElement searchButton;

    @UIName(uiName = "SEARCH_ALL_PROFILE_OPTION")
    @FindBy(how=How.CSS,using = SEARCH_ALL_PROFILE_OPTION)
    private WebElement selectAllProfilesInSearch;

    @UIName(uiName = "PRODUCTION_DROPDOWN_BUTTON")
    @FindBy(how=How.CSS,using = PRODUCTION_DROPDOWN_BUTTON)
    private WebElement productionDropdown;

    @UIName(uiName = "PRODUCTION_SELECT")
    @FindBy(how=How.CSS,using = PRODUCTION_SELECT)
    private WebElement productionSelect;

    @UIName(uiName = "GRID_COLUMN_HEADERS")
    @FindBy(how = How.XPATH, using = GRID_COLUMN_HEADERS)
    private List<WebElement> gridColumnHeaders;

    @UIName(uiName = "SEARCH_RESULT")
    @FindBys(@FindBy(how=How.CSS,using = SEARCH_RESULT))
    private List<WebElement> searchResults;

    @UIName(uiName = "TOTAL_REV_METRICS_SELECT_BUTTON")
    @FindBy(how=How.XPATH,using = TOTAL_REV_METRICS_SELECT_BUTTON)
    private WebElement totalRevMetricsSelectButton;

    @UIName(uiName = "TOTAL_REV_METRICS_SELECT_DROPDOWN")
    @FindBy(how=How.CSS,using=TOTAL_REV_METRICS_SELECT_DROPDOWN)
    private WebElement totalRevMetricsSelectDropdown;

    @UIName(uiName = "OCC_FROM_SLIDER")
    @FindBy(how=How.CSS,using = OCC_FROM_SLIDER)
    private WebElement occFromSlider;

    @UIName(uiName = "OCC_TO_SLIDER")
    @FindBy(how = How.CSS,using = OCC_TO_SLIDER)
    private WebElement toSlider;

    @UIName(uiName = "ALL_BREADCRUMB_TEXT")
    @FindBy(how=How.CSS,using = ALL_BREADCRUMB_TEXT)
    private List<WebElement> allBreadCrumbText;

    @UIName(uiName = "TOTAL_REV_METRICS_LIST")
    @FindBy(how=How.XPATH,using=TOTAL_REV_METRICS_LIST)
    private List<WebElement> totalRevMetricsList;

    @UIName(uiName = "CALENDER_LABEL")
    @FindBy(how=How.CSS,using=CALENDER_LABEL)
    private WebElement calenderLabel;

    @UIName(uiName = "IMPACT_EVENT_YEAR_BTN")
    @FindBy(how=How.CSS,using = IMPACT_EVENT_YEAR_BTN)
    private WebElement impactEventYearBtn;

    @UIName(uiName = "SELECT_IMPACT_EVENT_YEAR_DROPDOWN")
    @FindBy(how=How.XPATH,using = SELECT_IMPACT_EVENT_YEAR_DROPDOWN)
    private WebElement selectImpactEventYearDropDown;

    @UIName(uiName = "IMPACT_EVENT_BTN")
    @FindBy(how=How.XPATH,using=IMPACT_EVENT_BTN)
    private WebElement impactEventBtn;

    @UIName(uiName = "SELECT_IMPACT_EVENT_DROPDOWN")
    @FindBy(how=How.XPATH,using = SELECT_IMPACT_EVENT_DROPDOWN)
    private WebElement selectImpactEventDropDown;


    public void accessAccountSummaryReport(){
        waitForElementToAppear(accountSummaryScoreCard);
        accountSummaryScoreCard.click();
    }

    public void clickReportCriteriaIcon(){
        waitForElementToAppear(ACCOUNT_SUMMARY_CRITERIA_ICON);
        waitForElementToBeClickable(reportCriteriaIcon);
        reportCriteriaIcon.click();
        waitForElementToAppear(REPORT_CRITERIA_HEADER);
    }

    public void clickDateRangeCalendarIcon(){
        dateRangeCalendarIcon.click();
        waitForElementToAppear(CALENDAR_DATE_RANGE_HEADER);
    }

    public void clickDOWDropDown(){
        waitForElementToBeClickable(dowDropdownButton);
        dowDropdownButton.click();
    }

    public String getDayOfWeekDropText(){
        waitForElementToAppear(dowDropdownDefaultText);
        return dowDropdownDefaultText.getText();
    }

    public List<String> getDOWList(String dowType){
        List<WebElement> weekDayList = getListOfDynamicWebElements(DOW_DROPDOWN_SELECT,dowType);
        return weekDayList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void deselectDOWList(List<String> dowDeselectList){
        for (String dowText : dowDeselectList) {
            deselectByVisibleTextInDropdown(dowSelectDropDown,dowText.trim());
        }
    }

    public String getDefaultMarketSegmentDropDownText(){
        waitForElementToAppear(mktSegmentDropdownDefaultText);
        return mktSegmentDropdownDefaultText.getText();
    }

    public void clickMarketSegmentDropDown(){
        waitForElementToBeClickable(mktSegDropdownButton);
        mktSegDropdownButton.click();
    }

    public List<String> getMarketSegmentList(String mktSegType){
        List<WebElement> weekDayList = getListOfDynamicWebElements(MKT_SEG_DROPDOWN_SELECT,mktSegType);
        return weekDayList.stream().map(data->data.getAttribute(TITLE_ATTRIBUTE)).collect(Collectors.toList());
    }

    public void deselectMarketSegmentList(List<String> mktSegDeselectList){
        for (String mktSegText : mktSegDeselectList) {
            deselectByVisibleTextInDropdown(mktSegmentSelect,mktSegText);
        }
    }

    public void clickVolumeMetricsDropDown(){
        waitForElementToAppear(volumeMetricsSelectButton);
        volumeMetricsSelectButton.click();
    }

    public List<String> getVolumeMetricsList(){
        return volumeMetricsList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void selectVolumeMetricsList(List<String> volumeMetrics){
        for (String volumeMetricText : volumeMetrics) {
            WebElement volumeMetric = getDynamicWebElement(VOLUME_METRICS_LIST_SELECT,volumeMetricText);
            volumeMetric.click();
        }
    }

    public void clickRoomRevMetricsDropDown(){
        waitForElementToAppear(roomRevMetricsSelectButton);
        roomRevMetricsSelectButton.click();
    }

    public List<String> getRoomRevMetricsList(){
        return roomRevMetricsList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void selectRoomRevMetricsList(List<String> roomRevMetrics){
        for (String roomRevMetricText : roomRevMetrics) {
            selectByVisibleTextInDropdown(mktSegmentSelectDropdown,roomRevMetricText);
        }
    }

    public void clickAccountTypeDropDown(){
        waitForElementToAppear(accountTypeSelectButton);
        accountTypeSelectButton.click();
    }

    public List<String> getAccountTypeList(){
        return accountTypeList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void selectAccountType(String accountType){
        selectByVisibleTextInDropdown(accountTypeSelect,accountType);
    }

    public String getSelectedAccountType(){
        return  accountTypeSelected.getAttribute(TITLE_ATTRIBUTE);
    }

    public void clickAccountHierarchyDropDown(){
        waitForElementToAppear(accountHierarchySelectButton);
        accountHierarchySelectButton.click();
    }

    public List<String> getAccountHierarchyList(){
        return accountHierarchyList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void selectAccountHierarchy(String accountHierarchy){
        selectByVisibleTextInDropdown(accountHierarchySelectDropDown,accountHierarchy);
    }

    public String  getSelectedAccountHierarchy(){
        return  accountHierarchySelected.getAttribute(TITLE_ATTRIBUTE);
    }

    public void clickAccountSearchDropDown(){
        waitForElementToBeClickable(accountNameSearchButtonDropdown);
        accountNameSearchButtonDropdown.click();
    }

    public void searchAccountName(String accountNameToSearch){
        searchField.clear();
        searchField.sendKeys(accountNameToSearch);
    }

    public List<String> getSearchResult(){
        return searchResults.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void setLeadTimeInput(List<String> leadTimeRange){
        waitForAllElementsToAppear(leadTimeInput);
        int i = 0;
        for (WebElement leadTime : leadTimeInput) {
            leadTime.clear();
            leadTime.sendKeys(leadTimeRange.get(i));
            i++;
        }
    }

    public void closeReportCriteriaPopUp(){
        reportCriteriaIcon.click();
    }

    public void clickReportCriteriaGoButton(){
        reportCriteriaGoButton.click();
        waitForElementToDisappear(waitSpinner);
    }

    public List<String> getGridColumnHeaders(){
        return gridColumnHeaders.stream().map(data->data.getText().trim()).collect(Collectors.toList());
    }

    public String getBreadCrumbSliceText(String sliceName){
        return driver.findElement(By.xpath(getDynamicXpath(BREADCRUMB_SLICE_TEXT,sliceName))).getText();
    }

    public List<String> getAllBreadCrumbText(){
        waitForAllElementsToAppear(allBreadCrumbText);
        return allBreadCrumbText.stream().map(WebElement::getText).map(String::trim).collect(Collectors.toList());
    }

    public String setOccupancyPercentage(int fromPercent,int toPercent){
        int currentFromSlider=Integer.parseInt(occFromSlider.getText());
        Actions move = new Actions(driver);
        if(fromPercent>currentFromSlider){
            int steps=fromPercent-currentFromSlider;
            for(int i=1;i<=steps;i++) {
                move.moveToElement(occFromSlider).click().sendKeys(Keys.ARROW_RIGHT).build().perform();

            }
        }else if(fromPercent<currentFromSlider){
            int steps=currentFromSlider-fromPercent;
            for(int i=1;i<=steps;i++) {
                move.moveToElement(occFromSlider).click().sendKeys(Keys.LEFT).build().perform();
            }
        }

        int currentToSlider=Integer.parseInt(toSlider.getText());
        if(toPercent<currentToSlider){
            int steps=currentToSlider-toPercent;
            for(int i=1;i<=steps;i++) {
                move.moveToElement(toSlider).click().sendKeys(Keys.LEFT).build().perform();
            }
        }else if(toPercent>currentToSlider){
            int steps=toPercent-currentToSlider;
            for(int i=1;i<=steps;i++) {
                move.moveToElement(toSlider).click().sendKeys(Keys.RIGHT).build().perform();
            }
        }
        pauseTest(2000); // move function def in base class
        return occFromSlider.getText()+"% - "+toSlider.getText()+"%";
    }

    public void clickTotalRevMetricsSelectButton(){
        waitForElementToBeClickable(totalRevMetricsSelectButton);
        totalRevMetricsSelectButton.click();
    }


    public void selectTotalRevMetrics(List<String> totalRevMetrics){

        for (String trMetrics : totalRevMetrics) {
            selectByVisibleTextInDropdown(totalRevMetricsSelectDropdown,trMetrics);
        }
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public void searchAndSelectAllInProfileNameOfCriteria(List<String> allProfilesToBeSelected){
        for(String profile:allProfilesToBeSelected){
            searchField.clear();
            searchField.sendKeys(profile);
            selectAllProfilesInSearch.click();
        }
    }

    public void selectProductionOption(String option){
        selectByVisibleTextInDropdown(productionSelect,option);
    }

    public void fillProductionFromField(String val){
        productionFromField.clear();
        productionFromField.sendKeys(val);
    }

    public void fillProductionToField(String val){
        productionInputToField.clear();
        productionInputToField.sendKeys(val);
    }

    public void selectImpactEventYear(String year){
        waitForElementToBeClickable(impactEventYearBtn);
        impactEventYearBtn.click();
        selectByVisibleTextInDropdown(selectImpactEventYearDropDown,year);
    }

    public void selectImpactEventByVisibleText(String impactEvent){
        waitForElementToBeClickable(impactEventBtn);
        impactEventBtn.click();
        String xpath=getDynamicXpath(SELECT_IMPACTEVENT_NAME,impactEvent);
        driver.findElement(By.xpath(xpath)).click();
    }

    public String getDateLabelToBeDisplayedInBreadCrumb(LocalDate startDate, LocalDate endDate) {
        if (startDate.getYear() == endDate.getYear()) {
            return calenderLabel.getText().replaceFirst(", " + startDate.getYear(), "");
        } else {
            return calenderLabel.getText();
        }
    }

    @Override
    public void refreshPage() {
        driver.navigate().refresh();
        waitForElementToDisappear(By.id("wait"));
    }

}
