package stepdefs.accountintel;

import com.ideas.chimps.bddselenium.actionhelpers.AccountIntelActions;
import com.ideas.chimps.bddselenium.actionhelpers.UserTypeConstants;
import com.ideas.chimps.bddselenium.entities.User;
import com.ideas.chimps.bddselenium.tests.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

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

}
