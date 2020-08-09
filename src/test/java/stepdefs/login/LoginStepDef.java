package stepdefs.login;

import com.ideas.chimps.bddselenium.tests.TestBase;

import io.cucumber.java.en.*;

public class LoginStepDef extends TestBase {

    @Given("^I am on Revplan System login page\\.$")
    public void navigateToRevplanSystem(){
        driver.get(environment.getUrl());
    }

    @When("^I fill in username for mars admin as \"([^\"]*)\"\\.$")
    public void i_fill_username(String username){
        loginPage.getUsername().sendKeys(username);
    }

    @When("^I fill in password for mars admin as \"([^\"]*)\"\\.$")
    public void i_fill_password(String password)
    {
        loginPage.getPassword().sendKeys(password);
    }

    @When("^I click on login button\\.$")
    public void i_click_on_login(){
        loginPage.getLoginBtn().click();
    }

    @Then("^management listing page should be displayed\\.$")
    public void managementListingPage() throws InterruptedException {
    }
}
