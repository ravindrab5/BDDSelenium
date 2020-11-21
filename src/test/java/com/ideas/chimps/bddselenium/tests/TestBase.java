package com.ideas.chimps.bddselenium.tests;

import com.ideas.chimps.bddselenium.config.Environment;
import com.ideas.chimps.bddselenium.util.ApiController;
import com.ideas.chimps.bddselenium.util.EventDriver;
import com.ideas.chimps.bddselenium.util.LocalDateUtil;
import com.ideas.chimps.bddselenium.util.UiLocalDateUtil;
import com.ideas.chimps.bddselenium.views.*;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test
public class TestBase extends AbstractTestNGSpringContextTests {

    @Autowired
    protected EventDriver eventDriver;

    @Autowired
    protected Environment environment;

    @Autowired
    protected ApiController controller;

    protected EventFiringWebDriver driver;
    protected ManagementCompanyListingPage companyListingPage;
    protected PropertyListing propListing;
    protected PropertyHomePage propertyHomePage;
    protected RoomTrendDashBoard roomTrendDashBoard;
    protected RoomAnalyticsPage roomAnalyticsPage;
    protected RoomAnalyticsReportCriteria criteria;
    protected UiLocalDateUtil uiDateUtil;
    protected LoginPage loginPage;
    protected LocalDateUtil localDateUtil;
    protected CalenderPop calenderPop;
    protected RoomAnalyticsDisplayCriteria roomAnalyticsDisplayCriteria;
    protected RoomAnalyticsReport roomAnalyticsReport;
    protected ProfileManagementPage profileManagementPage;
    protected ExcludedProfilesPage excludedProfilesPage;

}


