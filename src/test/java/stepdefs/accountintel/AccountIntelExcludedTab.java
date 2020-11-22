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

import java.util.List;

public class AccountIntelExcludedTab extends TestBase {
    protected AccountIntelActions accountIntelActions;


    @Given("Navigate to property homepage.")
    public void navigateToPropertyHomePage(){
        driver=eventDriver.getDriver();
        driver.get(environment.getUrl());
        User user=new User(environment.getMarsUser(),environment.getMarsUserPass(), UserTypeConstants.MARS_ADMIN);
        accountIntelActions=new AccountIntelActions(driver,user);
        accountIntelActions.navigateToPropertyHome(controller.getManagementCompany(),controller.getProperty());
    }

    @And("Account Intel Data Should be present.")
    public void accountIntelDataShouldBePresent() {
        controller.createCompanyProfiles();
        controller.createCompanyProfileReservation();
    }

    @When("I navigate to account intel page and click on excluded tab.")
    public void iNavigateToAccountIntelPageAndClickOnExcludedTab() {
        profileManagementPage=accountIntelActions.navigateToAccountIntelAccounts();
        excludedProfilesPage=profileManagementPage.navigateToExcludedTab();
    }

    @And("I open the profile display criteria.")
    public void iOpenTheProfileDisplayCriteria() {
        driver.navigate().refresh();
        excludedProfilesPage.clickProfileDisplay();
    }


    @Then("Search result should display")
    public void searchResultShouldDisplay(DataTable dataTable) {
        List<String> actual=excludedProfilesPage.getSearchResults();
        List<String> expected=expectedList(dataTable);
        Assert.assertEquals(actual,expected);
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
        String actual=excludedProfilesPage.getErrorText();
        String expected=arg0;
        Assert.assertEquals(actual,expected);
    }

    @When("I enter rn to data as {string}.")
    public void iEnterRnToDataAs(String arg0) {
        excludedProfilesPage.enterRnToField(arg0);
    }

    @Then("Grid should contain data.")
    public void gridShouldContainData(DataTable dataTable) {
        List<String> expected=expectedList(dataTable);
        List<String> actual=excludedProfilesPage.allMasterProfiles();
        Assert.assertEquals(actual,expected);
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
        profileManagementPage=excludedProfilesPage.clickOnTabProfileManagement();
    }

    @Then("Profile {string} should be in activated state.")
    public void profileShouldBeInActivatedState(String arg0) {
        Assert.assertTrue(profileManagementPage.isProfileAccepted(arg0));
    }
}
