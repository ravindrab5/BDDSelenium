package stepdefs.accountintel;

import com.ideas.chimps.bddselenium.actionhelpers.AccountIntelActions;
import com.ideas.chimps.bddselenium.actionhelpers.UserTypeConstants;
import com.ideas.chimps.bddselenium.entities.User;
import com.ideas.chimps.bddselenium.tests.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class AccountIntelExcludedTab extends TestBase {
    protected AccountIntelActions accountIntelActions;


    @Given("Navigate to property homepage.")
    public void navigateToPropertyHomePage() {
        driver = eventDriver.getDriver();
        driver.get(environment.getUrl());
        User user = new User(environment.getMarsUser(), environment.getMarsUserPass(), UserTypeConstants.MARS_ADMIN);
        accountIntelActions = new AccountIntelActions(driver, user);
        accountIntelActions.navigateToPropertyHome(controller.getManagementCompany(), controller.getProperty());
    }

    @And("Account Intel Data Should be present.")
    public void accountIntelDataShouldBePresent() {
        controller.createCompanyProfiles();
        controller.createCompanyProfileReservation();
    }

    @When("I navigate to account intel page and click on excluded tab.")
    public void iNavigateToAccountIntelPageAndClickOnExcludedTab() {
        profileManagementPage = accountIntelActions.navigateToAccountIntelAccounts();
        excludedProfilesPage = profileManagementPage.navigateToExcludedTab();
    }

    @And("I open the profile display criteria.")
    public void iOpenTheProfileDisplayCriteria() {
        driver.navigate().refresh();
        excludedProfilesPage.clickProfileDisplay();
    }


    @Then("Search result should display")
    public void searchResultShouldDisplay(List<String> data) {
        List<String> actual = excludedProfilesPage.getSearchResults();
        List<String> expected = data;
        Assert.assertEquals(actual, expected);
    }


    @And("Search profile {string} in profile search.")
    public void searchProfileInProfileSearch(String arg0) {
        excludedProfilesPage.searchProfileAndGetResult(arg0);
    }

    @And("I enter rn from data as {string}.")
    public void iEnterRnFromDataAs(String arg0) {
        excludedProfilesPage.enterRnFromData(arg0);
    }

    @And("Click on Go button.")
    public void clickOnGoButton() {
        excludedProfilesPage.clickGoButton();
    }

    @Then("Error message {string}.")
    public void errorMessage(String arg0) {
        String actual = excludedProfilesPage.getErrorText();
        String expected = arg0;
        Assert.assertEquals(actual, expected);
    }

    @When("I enter rn to data as {string}.")
    public void iEnterRnToDataAs(String arg0) {
        excludedProfilesPage.enterRnToField(arg0);
    }

    @Then("Grid should contain data.")
    public void gridShouldContainData(DataTable dataTable) {
        List<String> expected = expectedList(dataTable) == null ? new ArrayList<>() : expectedList(dataTable);
        List<String> actual = excludedProfilesPage.allMasterProfiles();
        Assert.assertEquals(actual, expected);
    }

    @And("Search profile {string} in profile search and select.")
    public void searchProfileInProfileSearchAndSelect(String arg0) {
        excludedProfilesPage.searchProfileAndSelect(arg0);

    }

    @And("I Click on the edit icon")
    public void iClickOnTheEditIcon() {
        excludedProfilesPage.clickEditIcon();
    }

    @And("I activate a account {string}.")
    public void iActivateAAccount(String arg0) {
        excludedProfilesPage.activateAccount(arg0);
    }

    @And("I click on the save icon.")
    public void iClickOnTheSaveIcon() {
        excludedProfilesPage.clickSave();
    }

    @When("I navigate to profile management tab.")
    public void iNavigateToProfileManagementTab() {
        profileManagementPage = excludedProfilesPage.clickOnTabProfileManagement();
    }

    @Then("Profile {string} should be in activated state.")
    public void profileShouldBeInActivatedState(String arg0) {
        Assert.assertTrue(profileManagementPage.isProfileAccepted(arg0));
    }

    @When("I navigate to account intel profile management tab.")
    public void iNavigateToAccountIntelProfileManagementTab() {
        profileManagementPage = accountIntelActions.navigateToAccountIntelAccounts();
    }

    @And("I click on edit icon in profile management tab.")
    public void iClickOnEditIconInProfileManagementTab() {
        profileManagementPage.clickEditIcon();
    }

    @And("I exclude a account {string}.")
    public void iExcludeAAccount(String arg0) {
        profileManagementPage.markExcluded(arg0);
    }

    @And("I click on save icon in profile management tab.")
    public void iClickOnSaveIconInProfileManagementTab() {
        profileManagementPage.clickSave();
    }

    @And("I click on excluded tab.")
    public void iClickOnExcludedTab() {
        excludedProfilesPage = profileManagementPage.navigateToExcludedTab();
    }

    @And("Profile {string} should be in contracted state.")
    public void profileShouldBeInContractedState(String arg0) {
        profileManagementPage.isContractedProfile(arg0);
    }

    @Then("Profile display criteria should be in disabled state.")
    public void profileDisplayCriteriaShouldBeInDisabledState() {
        Assert.assertTrue(excludedProfilesPage.isProfileDisplayEnabled());
    }

    @And("Search profile {string} and select.")
    public void searchProfile(String arg0) {
        excludedProfilesPage.searchProfileAndSelect(arg0);
    }

    @And("I Click on the Star Reactivate Icon.")
    public void iClickOnTheStarReactivateIcon() {
        excludedProfilesPage.clickStarReactivateIcon();
    }

    @Then("Reset button should be is {string} state.")
    public void resetButtonShouldBeIsState(String arg0) {
        if (arg0.equals("enabled")) {
            Assert.assertTrue(excludedProfilesPage.isResetButtonEnabled());
        } else {
            Assert.assertFalse(excludedProfilesPage.isResetButtonEnabled());
        }
    }

    @When("I click on the Accept All.")
    public void iClickOnTheAcceptAll() {
        excludedProfilesPage.clickAcceptAll();
    }

    @And("I Click on the reset button and close.")
    public void iClickOnTheResetButtonAndClose() {
        excludedProfilesPage.clickResetButton();
        excludedProfilesPage.closeButtonStarAction();
    }

    @When("I click on the cancel icon.")
    public void iClickOnTheCancelIcon() {
        excludedProfilesPage.clickCancelSaveButton();
    }

    @Then("Profile {string} should be in excluded state.")
    public void profileShouldBeInExcludedState(String arg0) {
        excludedProfilesPage.isProfileExcluded(arg0);
    }

    @And("I mark an account {string} excluded.")
    public void iMarkAnAccountExcluded(String arg0) {
        profileManagementPage.excludeAccount(arg0);
    }

    @When("I activate all from star reactivate feature and close.")
    public void iActivateAllFromStarReactivateFeature() {
        excludedProfilesPage.clickAcceptAll();
        excludedProfilesPage.closeButtonStarAction();
    }

    @Then("Profile {string} should be in pending state.")
    public void profileShouldBeInPendingState(String arg0) {
        Assert.assertFalse(profileManagementPage.isProfilePending(arg0));
    }

    @And("I select sorting order as low to high.")
    public void iSelectSortingOrderAsLowToHigh() {
        excludedProfilesPage.selectSortProfile("RN Production Low to High");
    }

    @And("I select sorting order as high to low.")
    public void iSelectSortingOrderAsHighToLow() {
        excludedProfilesPage.selectSortProfile("RN Production High to Low");
    }

    @And("I search and select profile.")
    public void iSearchAndSelectProfile(DataTable dataTable) {
        List<String> data=expectedList(dataTable);
        for(String dat:data){
            excludedProfilesPage.searchProfileAndSelect(dat);
        }

    }
}
