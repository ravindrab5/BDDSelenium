package stepdefs.roomanalytics;


import com.ideas.chimps.bddselenium.actionhelpers.RoomAnalyticsActions;
import com.ideas.chimps.bddselenium.actionhelpers.UserTypeConstants;
import com.ideas.chimps.bddselenium.entities.ImpactEvent;
import com.ideas.chimps.bddselenium.entities.User;
import com.ideas.chimps.bddselenium.tests.TestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CheckDefaultCriteria extends TestBase {

    protected RoomAnalyticsActions roomAnalyticsActions;

    @Given("I navigate to prop homepage.")
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



    @When("^Report criteria should have sections \"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\" and \"(.*)\" section.$")
    public void report_criteria_should_have_sections(String dataRange,String primaryData,String comparativeData,String data,String runReportSection){
     //   roomAnalyticsPage=roomTrendDashBoard.clickRoomAnalyticsScorecard();
      //  roomAnalyticsPage.openCriteria();
        criteria=roomAnalyticsPage.getCriteriaPopupIfOpen();
        List<String> expected=new ArrayList<>();
        expected.add(dataRange);
        expected.add(primaryData);
        expected.add(comparativeData);
        expected.add(data);
        expected.add(runReportSection);
        Assert.assertEquals(criteria.getAllSectionsLabelString(),expected);
    }

    @Then("^Date Range section should have Calender with label \"(.*)\", \"(.*)\" label with year dropdown enabled,event list as disabled.$")
    public void data_ranage_sections_should_have_calender_with_label(String calenderLabel,String impactEventLable){
       Assert.assertEquals(criteria.getCalenderLabel(),calenderLabel);
       Assert.assertEquals(criteria.getImpactEventLabel(),impactEventLable);
       Assert.assertFalse(criteria.getImpactEventYear().isEnabled());
       Assert.assertFalse(criteria.getImpactEventListSelect().isEnabled());
    }

    @Then("^Primary Data source should have option of \"(.*)\",\"(.*)\",\"(.*)\" and none should be selected.$")
    public void primary_section_should_have_options_active_budget_last_submitted(String active,String budget,String lastSubmitted){
    List<String> expectedLabels=new ArrayList<>();
    expectedLabels.add(active);
    expectedLabels.add(budget);
    expectedLabels.add(lastSubmitted);
    Assert.assertEquals(criteria.getAllLabelsofPrimaryRadio(),expectedLabels);
    Assert.assertFalse(criteria.isAnyOfPrimaryRadioSelected());
    }

    @Then("^In Comparative Data section all comparative dropdowns should be disabled.$")
    public void comparative_data_section_all_comparative_dropdowns_should_be_disabled(){
        Assert.assertFalse(criteria.isAllDropdownOfComparativeEnabled());
    }

    @And("^Data Filters should have \"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\" present.$")
    public void data_filter_should_have_all_sections(String dowLabel,String occLabel,String segCategory,String subTotal,String pmsSegment){
        List<String> expected=new ArrayList<>();
        expected.add(dowLabel);
        expected.add(occLabel);
        expected.add(segCategory);
        expected.add(subTotal);
        expected.add(pmsSegment);
        Assert.assertEquals(criteria.getListDataFilterLabelsString(),expected);
    }

    @And("^Days of Week should have options for days of week.$")
    public void days_of_week_should_have_options_for_dow(){
        List<String> expected=new ArrayList<>();
        expected.add("Days of Week");
        expected.add("All Days Of Week");
        expected.add("Weekdays");
        expected.add("Monday");
        expected.add("Tuesday");
        expected.add("Wednesday");
        expected.add("Thursday");
        expected.add("Friday");
        expected.add("Weekends");
        expected.add("Saturday");
        expected.add("Sunday");
        criteria.clickDayOfWeekDropDown();
        List<String> actual=criteria.getDowOptions();
        criteria.clickDayOfWeekDropDown();
        Assert.assertEquals(actual,expected);
   }

   @And("^Occ % should have minimum of 0 & maximum of 100 value.$")
    public void occ_percent_should_have_minimum_of_0_max_100(){
        Assert.assertEquals(criteria.getSliderMinimum(),"0");
        Assert.assertEquals(criteria.getSliderMax(),"100");
   }

   @And("^Segment Category,Sub-Totals,Pms Segments should have data as configured for that property.$")
    public void seg_category_should_have_options(){
        List<String> expected_category=new ArrayList<>();
        expected_category.add("All Categories");
        expected_category.add("Hotel");
        expected_category.add("TRANSIENT");
        expected_category.add("Other Total");

       List<String> expected_segment=new ArrayList<>();
       expected_segment.add("All PMS Segment");
       expected_segment.add("Hotel");
       expected_segment.addAll(controller.getPropertyMarketSegmentList().stream().map((n)->n.getSegmentDescription()).collect(Collectors.toList()));

       criteria.getCategoryDropDown().click();
       List<String> actual_categoryOptions=criteria.getCategoryOptions();
       criteria.getCategoryDropDown().click();
       Assert.assertEquals(actual_categoryOptions,expected_category);

       criteria.getSegmentSelectDropDown().click();
       List<String> actual_segmentOptions=criteria.getSegementOptions();
       criteria.getSegmentSelectDropDown().click();
       Assert.assertEquals(actual_segmentOptions,expected_segment);

   }

   @When("^I select Date range and then select primary data.$")
    public void i_select_the_date_range() {
    //   roomAnalyticsPage=roomTrendDashBoard.clickRoomAnalyticsScorecard();
     //  Assert.assertTrue(roomAnalyticsPage.isCriteriaPopupDisplayed());
      // criteria=roomAnalyticsPage.openCriteria();
       criteria=roomAnalyticsPage.getCriteriaPopupIfOpen();
       calenderPop=criteria.clickOnPrimaryDateRange();
       calenderPop.selectDateRange(LocalDate.now().plusDays(-2), LocalDate.now().plusDays(2));
       criteria.selectPrimaryData("Active");
   }

   @Then("^All dropdowns of the Comparative data gets enabled.$")
    public void all_dropdowns_of_comparative_data_gets_enabled() {
       Assert.assertTrue(criteria.isAllDropdownOfComparativeEnabled());
   }

    @Then("^I Select \"(.*)\" in primary, same range should not have \"(.*)\" as option.$")
    public void select_a_primary_then_same_range_should_not_have_that_option(String selectRadio,String selectedText){
        criteria.selectPrimaryData(selectRadio);
        Assert.assertTrue(criteria.hasNoSameRangeOption(selectedText));
   }

   @Then("^I Select all options from same range, then dropdown label should be \"(.*)\".$")
    public void when_i_select_all_dropDownOptions(String dropdownLabel){
       criteria.clickSameRangeDropDown();
       criteria.selectAllFromSameRange();
       Assert.assertEquals(criteria.getSameRangeSelectedText(),dropdownLabel);
   }

   @Given("^Report criteria should be open and calender,primary data should be selected.$")
    public void report_criteria_should_be_open(){
       i_select_the_date_range();
      // criteria=roomAnalyticsPage.getCriteriaPopupIfOpen();
   }

   @When("^I select (.*) in comparative dropdowns.$")
    public void i_select_in_comparative_dropdowns(String selectDropDownOption) throws InterruptedException {
      //  criteria.clickPriorYearDropDown();
        if(selectDropDownOption.equals("All")){
             criteria.clickPriorYearDropDown();
             criteria.selectAllFromPriorYearOption();
             criteria.clickPriorYearDropDown();

            criteria.clickPriorYearOneDropDown();
            criteria.selectAllFromPriorYearOneOption();
            criteria.clickPriorYearOneDropDown();
            Thread.sleep(10000);

        }else{
            criteria.clickPriorYearDropDown();
            criteria.selectOptionInPriorYear(selectDropDownOption);
        }
   }

   @Then("^Selected or all metrics (.*) should be displayed.$")
    public void drop_down_text_to_be_displayed(String textTobeDisplayed){
        Assert.assertEquals(criteria.getActions().priorYearSelectedText.get(),textTobeDisplayed);
 //      Assert.assertEquals(criteria.getPriorYearOneSelectedText(),textTobeDisplayed);
   }

    @Given("There should be impact event present for the property.")
    public void thereShouldBeImpactEventPresentForTheProperty() {
        controller.createImpactEvent();
        driver.navigate().refresh();
     //   roomAnalyticsPage=roomTrendDashBoard.clickRoomAnalyticsScorecard();
    }

   @When("I select impact event year {string}.")
    public void iselectImpactEventYear(String year) throws InterruptedException {
      //  Thread.sleep(60000);
        criteria=roomAnalyticsPage.openCriteria();
        criteria.clickImpactEventYearDropDown();
        criteria.selectImpactEventYear(year);
   }

   @Then("Only Repeating and Annual impact event should be present in impact event list.$")
    public void repeating_and_annual_impact_event_should_be_present(){
        criteria.selectImpactEventListDropdown();
        List<String> actual=criteria.getListOfImpactEventForSelectedYear();
        List<String> expected=controller.getImpactEvents().stream().filter((n)->n.getFrequency().equals("REPEATING") && n.getInterval().equals("Annual")).map(ImpactEvent::getName).collect(Collectors.toList());
        criteria.selectImpactEventListDropdown();
        Assert.assertEquals(actual,expected);
   }


    @When("I select impact event from list.")
    public void iSelectImpactEventFromList() {
        criteria.selectImpactEventListDropdown();
        criteria.selectImpactEventList(controller.getImpactEvents().stream().findFirst().map(ImpactEvent::getName).get());

    }

    @Then("Calender label should get changed and impact event name should be displayed.")
    public void calenderLabelShouldGetChangedAndImpactEventNameShouldBeDisplayed() {
        String impactEvent=controller.getImpactEvents().stream().findFirst().map(ImpactEvent::getName).get();
        String actual=criteria.getCalenderLabel();
        Assert.assertEquals(actual,impactEvent);
    }

    @When("I select primary data.")
    public void iSelectPrimaryData() {
        criteria.selectPrimaryData("Active");
    }

    @Then("Comparative dropdown should be enabled, prior year should be enabled if there are instance for last year present.")
    public void comparativeDropdownShouldBeEnabledPriorYearShouldBeEnabledIfThereAreInstanceForLastYearPresent() {
            Assert.assertTrue(criteria.getSameRangeDropdown().isEnabled());
            Assert.assertTrue(criteria.getPriorYearDropDown().isEnabled());
            Assert.assertTrue(criteria.getPriorYearOneDropdown().isEnabled());


    }

    @When("I select date range.")
    public void iSelectDateRange() {
        calenderPop=criteria.clickOnPrimaryDateRange();
        calenderPop.selectDateRange(LocalDate.now().plusDays(-2), LocalDate.now().plusDays(2));

    }

    @Then("Calender Label should get changed and impact event should get disabled.")
    public void calenderLabelShouldGetChangedAndImpactEventShouldGetDisabled() {
            Assert.assertFalse(criteria.getSelectImpactEventDropdown().isEnabled());
    }

    @And("I click on go.")
    public void iClickOnGo() {
        criteria.getGoBtn().click();

    }

    @Then("BreadCrum should have impact event name and its date.")
    public void breadcrumShouldHaveImpactEventNameAndItsDate() {
        Assert.assertEquals(roomAnalyticsPage.getBreadCrumImpactEventlabel().getText().trim(),controller.getImpactEvents().stream().findFirst().map(ImpactEvent::getName).get());
    }


}
