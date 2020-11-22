package stepdefs.accountintel;

import com.ideas.chimps.bddselenium.actionhelpers.AccountIntelActions;
import com.ideas.chimps.bddselenium.actionhelpers.UserTypeConstants;
import com.ideas.chimps.bddselenium.entities.User;
import com.ideas.chimps.bddselenium.tests.TestBase;

import com.ideas.chimps.bddselenium.views.ExcludedProfilesPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProfileManagement extends TestBase {

    protected AccountIntelActions accountIntelActions;


    @Given("User navigate to property homepage.")
    public void iNavigateToPropertyHomePage(){
        driver=eventDriver.getDriver();
        driver.get(environment.getUrl());
        User user=new User(environment.getMarsUser(),environment.getMarsUserPass(), UserTypeConstants.MARS_ADMIN);
        accountIntelActions=new AccountIntelActions(driver,user);
        accountIntelActions.navigateToPropertyHome(controller.getManagementCompany(),controller.getProperty());

        
    }

    @And("Profiles and its reservation are populated already.")
    public void profilesAndItsReservationArePopulatedAlready() {
        controller.createCompanyProfiles();
        controller.createCompanyProfileReservation();
    }

    @When("I navigate to account intel page.")
    public void iNavigateToAccountIntelPage() {
        profileManagementPage=accountIntelActions.navigateToAccountIntelAccounts();
    }

    @And("Select the criteria with sort low to high for rn.")
    public void selectTheCriteriaWithSortLowToHighForRn() {
        profileManagementPage.openProfileDisplayPopup();
        profileManagementPage.selectSortProfile("RN Production Low to High");
        profileManagementPage.clickGoButton();
    }

    @And("Select the criteria with sort high to low for rn.$")
    public void selectTheCriteriaWithSortHighToLowForRn() {
        profileManagementPage.openProfileDisplayPopup();
        profileManagementPage.selectSortProfile("RN Production High to Low");
        profileManagementPage.clickGoButton();
    }

    /*@Then("The profiles should be displayed in sorted order from high to low.")
    public void theProfilesShouldBeDisplayedInSortedOrderFromHighToLow() {
    }*/

    @Then("The profiles should be displayed in sorted order from low to high.")
    public void theProfilesShouldBeDisplayedInSortedOrderFromLowToHigh() {

    }

    @And("Link profile.")
    public void linkProfile(DataTable dataTable) {
        List<Map<String,String>> profile=dataTable.asMaps(String.class,String.class);
        selectTheCriteriaWithSortLowToHighForRn();
        for(Map<String,String> prof:profile){
            profileManagementPage.clickEditIcon();
            profileManagementPage.linkProfile(prof.get("Master_Profile"), prof.get("Subprofile"));
            profileManagementPage.clickSave();
        }

    }

    @Then("Grid should contain profiles.")
    public void gridShouldContainProfiles(DataTable dataTable) {
        List<String> actualList = profileManagementPage.allMasterProfiles();
        List<String> expected=expectedList(dataTable);
        Assert.assertEquals(actualList,expected);

        //dataTable.asMaps().get("Profiles")
    }

    @And("Select {string} as profile type in criteria.")
    public void selectAsProfileTypeInCriteria(String arg0) {
        profileManagementPage.profileTypeSelectOnly(arg0);
    }

    @And("Select the sort order as low to high from criteria.")
    public void selectTheSortOrderAsLowToHighFromCriteria() {
        profileManagementPage.selectSortProfile("RN Production Low to High");
    }

    @And("Click on the go button.")
    public void clickOnTheGoButton() {
        profileManagementPage.clickGoButton();
    }

    @And("I click on edit button.")
    public void iClickOnEditButton() {

    }

    @And("I Autolink profiles.")
    public void iAutolinkProfiles(DataTable dataTable) {
        List<Map<String,String>> profile=dataTable.asMaps(String.class,String.class);
        for(Map<String,String> prof:profile){
            profileManagementPage.autolinkProfiles(prof.get("Profile"), Arrays.asList(prof.get("Autolink_Name").split(",")));
            profileManagementPage.clickautolinkSaveButton();
            profileManagementPage.clickautolinkCloseButton();
        }
    }

    @When("I Autolink profiles and wait for error.")
    public void iAutolinkProfilesAndWaitForError(DataTable dataTable) {
        List<Map<String,String>> profile=dataTable.asMaps(String.class,String.class);
        for(Map<String,String> prof:profile){
            profileManagementPage.autolinkProfiles(prof.get("Profile"), Arrays.asList(prof.get("Autolink_Name").split(",")));
            profileManagementPage.clickautolinkSaveButton();
        }
    }

    @Then("Profiles should have subprofiles.")
    public void profilesShouldHaveSubprofiles(DataTable dataTable) {
        List<Map<String,String>> profile=dataTable.asMaps(String.class,String.class);
        profileManagementPage.checkSubProfileCheckBox();
        for(Map<String,String> prof:profile){
            List<String> expected_subprofiles=Arrays.asList(prof.get("Subprofiles").split(","));
            List<String> actual_subprofiles = profileManagementPage.getAllSubProfilesLinkedToMasterProfile(prof.get("Profiles"));
            Assert.assertEquals(actual_subprofiles,expected_subprofiles);
        }
    }

    @When("I delete first autolink of profile {string}.")
    public void iDeleteFirstAutolinkOfProfile(String arg0) {
        profileManagementPage.openAutolinkPopupFor(arg0);
        profileManagementPage.clickAutolinkEditIcon();
        profileManagementPage.clickDeleteButtonInAutolink();
        profileManagementPage.clickAutolinkErrorOkButton();

    }

    @And("Click on the {string} button of autolink.")
    public void clickOnTheButtonOfAutolink(String arg0) {
        profileManagementPage.clickautolinkSaveButton();

    }

    @Then("I should get popup with message {string}")
    public void iShouldGetPopupWithMessage(String arg0) {
        String expected=arg0;
        String actual = profileManagementPage.getErrorTextFromPopupForAutolink();
        Assert.assertEquals(actual,expected);
    }

    @When("I mark the profile {string} as pending.")
    public void iMarkTheProfileAsPending(String arg0) {
        profileManagementPage.clickEditIcon();
        profileManagementPage.markPendingOrAccepted(arg0);
        profileManagementPage.clickSave();
    }

    @When("I navigate to excluded tab.")
    public void iNavigateToExcludedTab() {
        excludedProfilesPage=profileManagementPage.navigateToExcludedTab();
    }

    @And("Activate profile {string}.")
    public void activateProfile(String arg0) {
        excludedProfilesPage.clickEditIcon();
        excludedProfilesPage.activateAccount(arg0);
        excludedProfilesPage.clickSave();
    }

    @And("I navigate to account intel tab.")
    public void iNavigateToAccountIntelTab() {
        profileManagementPage=excludedProfilesPage.clickOnTabProfileManagement();
    }

    @When("I exclude profile {string}.")
    public void iExcludeProfile(String arg0) {
        profileManagementPage.clickEditIcon();
        profileManagementPage.markExcluded(arg0);
        profileManagementPage.clickSave();

    }

    @Then("I should see {int} accounts autolinked to {string}.")
    public void iShouldSeeAccountsAutolinkedTo(int arg0, String arg1) {
        profileManagementPage.openAutolinkPopupFor(arg1);

        Assert.assertEquals(profileManagementPage.getNumberOfAccountsInAutolinkConfig(), arg0);

    }

    @Then("Message {string} should be displayed.")
    public void messageShouldBeDisplayed(String arg0) {
        String actualMsg = profileManagementPage.getMessageInAutolinkPopup();
        String expectedMsg=arg0;
        profileManagementPage.clickautolinkCloseButton();
        Assert.assertEquals(actualMsg,expectedMsg);
    }

    public List<String> expectedList(DataTable dataTable){
        return dataTable.asLists(String.class).stream().flatMap(List::stream).collect(Collectors.toList()).stream().map(Object::toString).collect(Collectors.toList());
    }

    @And("Open the report criteria.")
    public void openTheReportCriteria() {
        profileManagementPage.openProfileDisplayPopup();
    }

    @And("Click on {string} button of autolink.")
    public void clickOnButtonOfAutolink(String arg0) {
        profileManagementPage.clickautolinkCloseButton();
    }


    @When("I click on edit button on grid.")
    public void iClickOnEditButtonOnGrid() {
        profileManagementPage.clickEditIcon();
    }

    @And("I link profile {string} to {string}.")
    public void iLinkProfileTo(String arg0, String arg1) {
        profileManagementPage.linkProfile(arg1,arg0);
    }

    @And("I click on the save button of grid.")
    public void iClickOnTheSaveButtonOfGrid() {
        profileManagementPage.clickSave();
    }


    @And("I click on the ok button of error message.")
    public void iClickOnTheOkButtonOfErrorMessage() {
        profileManagementPage.clickOk();
    }

    @And("I click on the star action icon.")
    public void iClickOnTheStarActionIcon() {
        profileManagementPage.clickStarReactivateIcon();
    }

    @And("I click on the accept all and close popup.")
    public void iClickOnTheAcceptAllAndClosePopup() {
        profileManagementPage.clickAcceptAll();
        profileManagementPage.closeButtonStarAction();
    }

    @And("Activate profile {string} in profile management screen.")
    public void activateProfileInProfileManagementScreen(String arg0) {
        profileManagementPage.activateAccount(arg0);
    }
}
