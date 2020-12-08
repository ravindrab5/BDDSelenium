package com.ideas.chimps.bddselenium.actionhelpers;

import com.ideas.chimps.bddselenium.entities.User;
import com.ideas.chimps.bddselenium.views.AccountSummaryReportPage;
import com.ideas.chimps.bddselenium.views.ProfileManagementPage;
import com.ideas.chimps.bddselenium.views.PropertyHomePage;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class AccountIntelActions extends ActionBase{



    public AccountIntelActions(EventFiringWebDriver driver, User user) {
        super(driver, user);

    }

    public ProfileManagementPage navigateToAccountIntelAccounts(){
        return propertyHomePage.navigateToAccounts();
    }

    public AccountSummaryReportPage navigateToAccountsProduction(){
        return propertyHomePage.navigateToProduction();
    }
}
