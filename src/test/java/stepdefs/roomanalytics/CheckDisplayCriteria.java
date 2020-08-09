package stepdefs.roomanalytics;

import com.ideas.chimps.bddselenium.actionhelpers.RoomAnalyticsActions;
import com.ideas.chimps.bddselenium.actionhelpers.UserTypeConstants;
import com.ideas.chimps.bddselenium.entities.*;
import com.ideas.chimps.bddselenium.tests.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CheckDisplayCriteria extends TestBase {

    protected RoomAnalyticsActions roomAnalyticsActions;

    @Given("I navigate to property homepage.")
    public void iNavigateToPropertyHomepage() {
        driver=eventDriver.getDriver();
        driver.get(environment.getUrl());
        User user=new User(environment.getMarsUser(),environment.getMarsUserPass(), UserTypeConstants.MARS_ADMIN);
        roomAnalyticsActions=new RoomAnalyticsActions(driver,user);
        roomAnalyticsActions.navigateToPropertyHome(controller.getManagementCompany(),controller.getProperty());
        roomAnalyticsActions.nagivateToRoomAnalytics();
        propListing=roomAnalyticsActions.getPropListing();
        propertyHomePage=roomAnalyticsActions.getPropertyHomePage();
        roomTrendDashBoard=roomAnalyticsActions.getRoomTrendDashBoard();
        roomAnalyticsPage=roomAnalyticsActions.getRoomAnalyticsPage();
    }



    @When("I open the display criteria.")
    public void iOpenTheDisplayCriteria() {
        if(roomAnalyticsPage==null){
        roomAnalyticsPage=roomTrendDashBoard.clickRoomAnalyticsScorecard();}
        roomAnalyticsDisplayCriteria=roomAnalyticsPage.clickDisplayCriteria();
    //    roomAnalyticsDisplayCriteria.waitTillDisplayCriteriaVisible();
    }

    @Then("I should see {string},{string},{string} checkbox selected, {string} and {string} should be unchecked.")
    public void iShouldSeeCheckboxSelectedAndShouldBeUnchecked(String arg0, String arg1, String arg2, String arg3, String arg4) {
        Assert.assertTrue(roomAnalyticsDisplayCriteria.getRoomNightsCheckbox().isSelected());
        Assert.assertTrue(roomAnalyticsDisplayCriteria.getAverageRateCheckBox().isSelected());
        Assert.assertTrue(roomAnalyticsDisplayCriteria.getRoomRevenueCheckBox().isSelected());
        Assert.assertFalse(roomAnalyticsDisplayCriteria.getRevParCheckbox().isSelected());
        Assert.assertFalse(roomAnalyticsDisplayCriteria.getPercentContributionCheckbox().isSelected());
    }

    @And("{string} should be selected from Analysis Type.")
    public void shouldBeSelectedFromAnalysisType(String arg0) {
        Assert.assertTrue(roomAnalyticsDisplayCriteria.getDifferenceRadio().isSelected());
    }

    @And("Inventory Option should have label {string} intially and ADR Options should have {string}.")
    public void inventoryOptionShouldHaveLabelIntiallyAndADROptionsShouldHave(String arg0, String arg1) {
        Assert.assertEquals(roomAnalyticsDisplayCriteria.getInventoryOptionButton().getText(),arg0);
        Assert.assertEquals(roomAnalyticsDisplayCriteria.getAdrOptionButton().getText(),arg1);
    }

    @Then("Inventory options should have items - {string},{string},{string},{string},{string},{string},{string}.")
    public void inventoryOptionsShouldHaveItems(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) {
    List<String> expected=new ArrayList<>();
    expected.add(arg0);
        expected.add(arg1);
        expected.add(arg2);
        expected.add(arg3);
        expected.add(arg4);
        expected.add(arg5);
        expected.add(arg6);
        roomAnalyticsDisplayCriteria.openInvetoryDropdown();
        List<String> actualList=roomAnalyticsDisplayCriteria.getInventoryOptionsList();
        roomAnalyticsDisplayCriteria.openInvetoryDropdown();
        Assert.assertEquals(actualList,expected);

    }

    @And("ADR Options should have items - {string},{string}.")
    public void adrOptionsShouldHaveItems(String arg0, String arg1) {
        List<String> expected=new ArrayList<>();
        expected.add(arg0);
        expected.add(arg1);
        roomAnalyticsDisplayCriteria.openAdrDropdown();
        List<String> actualList=roomAnalyticsDisplayCriteria.getAdrOptions();
        roomAnalyticsDisplayCriteria.openAdrDropdown();
        Assert.assertEquals(actualList,expected);

    }

    @Given("Report criteria should be selected with required minimum criteria.")
    public void reportCriteriaShouldBeSelectedWithRequiredMinimumCriteria() {

        RoomsAnalyticsReportCriteria reportCriteria=new RoomsAnalyticsReportCriteria();
        DateRange dateRange=new DateRange();
        dateRange.setStartDate(LocalDate.now().minusDays(2));
        dateRange.setEndDate(LocalDate.now().plusDays(2));
        reportCriteria.setDateRange(dateRange);
        reportCriteria.setPrimaryDataType("Active");
        reportCriteria.setSameRange(Arrays.asList("Budget"));
        reportCriteria.setPriorYear(Arrays.asList("Active","Budget"));
        roomAnalyticsActions.selectReportCriteria(reportCriteria);

    }

    @And("Select {string},{string},{string} and click on go.")
    public void selectAndClickOnGo(String arg0, String arg1, String arg2) {
    }

    @Then("Report should have column added for {string},{string},{string}.")
    public void reportShouldHaveColumnAddedFor(String arg0, String arg1, String arg2) {
    }

    @And("Select all inventory options,adr option and click on go.")
    public void selectAllInventoryOptionsAdrOptionAndClickOnGo() throws InterruptedException {
        roomAnalyticsDisplayCriteria.clickInventoryOptionButton();
        roomAnalyticsDisplayCriteria.selectAllInventoryOptions();
        roomAnalyticsDisplayCriteria.clickInventoryOptionButton();
        roomAnalyticsDisplayCriteria.clickAdrOptionButton();
        roomAnalyticsDisplayCriteria.selectAllAdrOptions();
        roomAnalyticsDisplayCriteria.clickAdrOptionButton();
        roomAnalyticsReport=roomAnalyticsDisplayCriteria.clickGo();
    }

    @Then("Report should have rows added for statistics option and adr option.")
    public void reportShouldHaveRowsAddedForStatisticsOptionAndAdrOption() {
        roomAnalyticsReport.expandStatistics();
        List<String> actual=roomAnalyticsReport.getAllStatisticsOptionInReport();
        List<String> expected=Arrays.asList("Gross Avail Rooms","Net Avail Rooms","OOO Rooms","Paid Occupancy","Occupancy Group","Occupancy Transient","Financial Occupancy","ADR Inc Comp","ADR Exc Comp");
        Assert.assertEquals(actual,expected);
    }

    @Then("Report should get generated and should have all categories present.")
    public void reportShouldGetGeneratedAndShouldHaveAllCategoriesPresent() {
        List<String> actual=roomAnalyticsReport.getCategoryList();
        List<String> expected=controller.getSegmentStruture().getManagementSegmentTypeDTO().get(0).getSegmentCategory().stream().map(SegmentCategory::getCategoryName).collect(Collectors.toList());
        Assert.assertEquals(actual,expected);
    }

    @And("If I click on expand button for each category then respective segments should be present.")
    public void ifIClickOnExpandButtonForEachCategoryThenRespectiveSegmentsShouldBePresent() {
        roomAnalyticsReport.clickExpandTotal();
        List<String> expectedSubCategory=controller.getSegmentStruture().getManagementSegmentTypeDTO().stream().flatMap(segmentDto->segmentDto.getSegmentCategory().stream()).flatMap(segmentCategory -> segmentCategory.getCategorySubTotal().stream()).map(CategorySubTotal::getSubCategoryName).collect(Collectors.toList());
        List<String> actualSubCategory=roomAnalyticsReport.listofSubCateory();
        SoftAssert assertion=new SoftAssert();
        assertion.assertEquals(actualSubCategory,expectedSubCategory);

        List<String> expectedSegments=controller.getPropertyMarketSegmentList().stream().map(PropertyMarketSegment::getSegmentDescription).collect(Collectors.toList());
        List<String> actualSegments=roomAnalyticsReport.getLIstOfSegment();
        assertion.assertEquals(actualSegments,expectedSegments);
        assertion.assertAll();
    }

    @Then("Default display column should be {string},{string} and {string}.")
    public void defaultDisplayColumnShouldBeAnd(String rm, String adr, String revenue) {
        List<String> expected=Arrays.asList(rm,adr,revenue);
        List<String> actual=roomAnalyticsReport.getMetricOptionForPrimary("Active");
        Assert.assertEquals(actual,expected);
    }

    @And("Select all the metrics options and click on go.")
    public void selectAllTheMetricsOptionsAndClickOnGo() {
        Actions actions=new Actions(driver);
        actions.moveToElement(roomAnalyticsDisplayCriteria.getPercentContributionCheckbox()).click().build().perform();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions=new Actions(driver);
        actions.moveToElement(roomAnalyticsDisplayCriteria.getRevParCheckbox()).click().build().perform();

        roomAnalyticsReport=roomAnalyticsDisplayCriteria.clickGo();

    }


    @Then("In report I should see the selected metrics options {string},{string},{string},{string},{string},{string}.")
    public void inReportIShouldSeeTheSelectedMetricsOptions(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {
        List<String> expectedMetricsOption=Arrays.asList(arg0,arg1,arg2,arg3,arg4,arg5);
        List<String> actualMetricsOption=roomAnalyticsReport.getMetricOptionForPrimary("Active");
        Assert.assertEquals(actualMetricsOption,expectedMetricsOption);
    }
}
