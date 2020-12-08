package stepdefs.accountintel;

import com.ideas.chimps.bddselenium.actionhelpers.AccountIntelActions;
import com.ideas.chimps.bddselenium.actionhelpers.UserTypeConstants;
import com.ideas.chimps.bddselenium.entities.User;
import com.ideas.chimps.bddselenium.tests.TestBase;
import com.ideas.chimps.bddselenium.views.CalenderPop;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import java.time.LocalDate;

import java.util.List;

public class AccountSummaryReport extends TestBase {
    protected AccountIntelActions accountIntelActions;
    private static final String VOLUME_METRICS="Volume metrics";
    private static final String ROOM_REVENUE_METRICS="Room Revenue metrics";
    private static final String ACCOUNT_TYPE="Account Type";
    private static final String ACCOUNT_HIERARCHY="Account Hierarchy";
    private static final String MASTER_PLUS_SUBLINKED="Master+Sub-Linked Accounts";
    private static final String DAYS_OF_WEEK="Days Of Week";
    private static final String WEEKDAYS="Weekdays";
    private static final String WEEKEND="Weekends";
    private static final String MARKET_SEGMENT="Market Segment";
    private static final String HOTEL="Hotel";
    private static final String DOW="DOW";
    private static final String OCC="Occ";
    private static final String DATE_RANGE="Date Range";
    private static final String IMPACT_EVENT="Impact Event";

    @Given("Navigate to property homepage for production.")
    public void navigateToPropertyHomePage() {
        driver = eventDriver.getDriver();
        driver.get(environment.getUrl());
        User user = new User(environment.getMarsUser(), environment.getMarsUserPass(), UserTypeConstants.MARS_ADMIN);
        accountIntelActions = new AccountIntelActions(driver, user);
        accountIntelActions.navigateToPropertyHome(controller.getManagementCompany(), controller.getProperty());

    }

    @And("Profiles data and its reservation are populated already.")
    public void accountIntelDataShouldBePresent() {
        controller.createCompanyProfiles();
        controller.createCompanyProfileReservation();
    }

    @When("I navigate to account intel production.")
    public void iNavigateToAccountIntelProduction() {
        accountSummaryReportPage=accountIntelActions.navigateToAccountsProduction();
        accountSummaryReportPage.accessAccountSummaryReport();

    }

    @And("Open {string} dropdown.")
    public void openDropdown(String arg0) {
        switch (arg0){
            case VOLUME_METRICS:
                accountSummaryReportPage.clickVolumeMetricsDropDown();
                break;
            case ROOM_REVENUE_METRICS:
                accountSummaryReportPage.clickRoomRevMetricsDropDown();
                break;
            case ACCOUNT_TYPE:
                accountSummaryReportPage.clickAccountTypeDropDown();
                break;
            case ACCOUNT_HIERARCHY:
                accountSummaryReportPage.clickAccountHierarchyDropDown();
                break;
            case DAYS_OF_WEEK:
                accountSummaryReportPage.clickDOWDropDown();
                break;
            case MARKET_SEGMENT:
                accountSummaryReportPage.clickMarketSegmentDropDown();
                break;



        }
    }

    @Then("{string} list should contain.")
    public void listShouldContain(String arg0, List<String> expected) {
        switch (arg0){
            case VOLUME_METRICS:
                List<String> volumeMetricsList = accountSummaryReportPage.getVolumeMetricsList();
                Assert.assertEquals(volumeMetricsList,expected);
                break;
            case ROOM_REVENUE_METRICS:
                List<String> roomRevMetricsList = accountSummaryReportPage.getRoomRevMetricsList();
                Assert.assertEquals(roomRevMetricsList,expected);
                break;
            case ACCOUNT_TYPE:
                List<String> accountTypeList = accountSummaryReportPage.getAccountTypeList();
                Assert.assertEquals(accountTypeList,expected);
                break;
            case ACCOUNT_HIERARCHY:
                List<String> accountHierarchyList = accountSummaryReportPage.getAccountHierarchyList();
                Assert.assertEquals(accountHierarchyList,expected);
                break;
            case WEEKDAYS:
                List<String> weekdaysList = accountSummaryReportPage.getDOWList(WEEKDAYS);
                Assert.assertEquals(weekdaysList,expected);
                break;
            case WEEKEND:
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//b[text()=' Weekends']")));
                List<String> weekendList = accountSummaryReportPage.getDOWList(WEEKEND);
                Assert.assertEquals(weekendList,expected);
                break;
            case HOTEL:
                List<String> mktSegmentList = accountSummaryReportPage.getMarketSegmentList(HOTEL);
                Assert.assertEquals(mktSegmentList,expected);




        }
    }

    @When("I select {string} from {string} dropdown.")
    public void iSelectFromDropdown(String arg0, String arg1) {
        switch (arg1){
            case ACCOUNT_HIERARCHY:
                accountSummaryReportPage.selectAccountHierarchy(arg0);
                break;

        }

    }

    @Then("Label for {string} drop down should be {string}.")
    public void labelForDropDownShouldBe(String arg0, String arg1) {
        switch (arg0){
            case ACCOUNT_HIERARCHY:
                Assert.assertEquals(accountSummaryReportPage.getSelectedAccountHierarchy(),arg1);
                break;
            case MARKET_SEGMENT:
                Assert.assertEquals(accountSummaryReportPage.getDefaultMarketSegmentDropDownText(),arg1);
                break;
        }
    }

    @And("Search profile \"(.*)\" in account search.$")
    public void searchProfileInAccountSearch(String arg0) {
        accountSummaryReportPage.clickAccountSearchDropDown();
        accountSummaryReportPage.searchAccountName(arg0);
    }

    @Then("Search result should contain.")
    public void searchResultShouldContain(List<String> expected) {
        List<String> actual=accountSummaryReportPage.getSearchResult();
        accountSummaryReportPage.clickAccountSearchDropDown();
        Assert.assertEquals(actual,expected);
    }

    @When("I deselect {string} list")
    public void iDeselectList(String arg0,List<String> deslectList) {
        switch (arg0){
            case DAYS_OF_WEEK:
                accountSummaryReportPage.deselectDOWList(deslectList);
                accountSummaryReportPage.clickDOWDropDown();
                break;
            case MARKET_SEGMENT:
                accountSummaryReportPage.deselectMarketSegmentList(deslectList);
                break;

        }


    }

    @When("I Click {string} Drop down.")
    public void iClickDropDown(String arg0) {
        openDropdown(arg0);
    }

    @And("I select Impact Event year {string}.")
    public void iSelectImpactEventYear(String arg0) {
        accountSummaryReportPage.selectImpactEventYear(arg0);
    }

    @And("I select impact event {string}.")
    public void iSelectImpactEvent(String arg0) {
        accountSummaryReportPage.selectImpactEventByVisibleText(arg0);
    }

    @And("I set occupancy percentage from {string} to {string}.")
    public void iSetOccupancyPercentageFromTo(String arg0, String arg1) {
        accountSummaryReportPage.setOccupancyPercentage(Integer.parseInt(arg0),Integer.parseInt(arg1));

    }

    @And("I type the production {string} field as {string}.")
    public void iTypeTheProductionFieldAs(String arg0, String arg1) {
        if(arg0.equals("from")) {
            accountSummaryReportPage.fillProductionFromField(arg1);
        }else if(arg0.equals("to")) {
            accountSummaryReportPage.fillProductionToField(arg1);
        }

    }

    @And("Click on the report criteria go button.")
    public void clickOnTheReportCriteriaGoButton() {
        accountSummaryReportPage.clickReportCriteriaGoButton();
    }

    @Then("BreadCrum slice text for {string} should be {string}.")
    public void breadcrumSliceTextForShouldBe(String arg0, String arg1) {
        switch (arg0){
            case DOW:
                String actual = accountSummaryReportPage.getBreadCrumbSliceText("DOW").trim();
                String expected=arg1;
                Assert.assertEquals(actual,expected);
                break;
            case OCC:
                actual = accountSummaryReportPage.getBreadCrumbSliceText("Occ").trim();
                expected=arg1;
                Assert.assertEquals(actual,expected);
                break;
            case DATE_RANGE:
                actual=accountSummaryReportPage.getBreadCrumbSliceText(DATE_RANGE).trim();
                expected=arg1;
                Assert.assertEquals(actual,expected);
                break;
            case IMPACT_EVENT:
                actual=accountSummaryReportPage.getBreadCrumbSliceText(IMPACT_EVENT).trim();
                expected=arg1;
                Assert.assertEquals(actual,expected);
                break;


        }
    }

    @And("I Open date range calender icon.")
    public void iOpenDateRangeCalenderIcon() {
        accountSummaryReportPage.clickDateRangeCalendarIcon();
    }

    @And("Select date {string} and {string} date in the calender.")
    public void selectDateAndDateInTheCalender(String arg0, String arg1) {
        CalenderPop calenderPop=new CalenderPop(driver);
        LocalDate startDate=calculateDate(arg0);
        LocalDate endDate=calculateDate(arg1);
        calenderPop.selectDateRange(startDate,endDate);
        calenderPop.getCalenderCloseBtn().click();
    }

    private LocalDate calculateDate(String dateString){
        LocalDate date=null;
        if(dateString.contains("-")){
            String[] data=dateString.split("-");
            date=LocalDate.now().minusDays(Integer.parseInt(data[1]));
        }else if(dateString.contains("+")) {
            String[] data = dateString.split("\\+");
            date = LocalDate.now().plusDays(Integer.parseInt(data[1]));
        }
        return date;
    }



    @Then("BreadCrum slice text for {string} should be of selected date {string} and {string}.")
    public void breadcrumSliceTextForShouldBeOfSelectedDateAnd(String arg0, String arg1, String arg2) {
        String expected_date = accountSummaryReportPage.getDateLabelToBeDisplayedInBreadCrumb(calculateDate(arg1), calculateDate(arg2));
        String actual_date=accountSummaryReportPage.getBreadCrumbSliceText(arg0).trim();
    }

    @When("I Open the report criteria")
    public void iOpenTheReportCriteria() {
        accountSummaryReportPage.clickReportCriteriaIcon();
    }

    @Then("Grid should have columns.")
    public void gridShouldHaveColumns(List<String> expectedList) {
        List<String> actualGridColumns = accountSummaryReportPage.getGridColumnHeaders();
        Assert.assertEquals(actualGridColumns,expectedList);
    }
}
