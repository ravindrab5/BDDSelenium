package com.ideas.chimps.bddselenium.actionhelpers;

import com.ideas.chimps.bddselenium.entities.RoomsAnalyticsReportCriteria;
import com.ideas.chimps.bddselenium.entities.User;
import com.ideas.chimps.bddselenium.views.RoomAnalyticsDisplayCriteria;
import com.ideas.chimps.bddselenium.views.RoomAnalyticsPage;
import com.ideas.chimps.bddselenium.views.RoomAnalyticsReportCriteria;
import com.ideas.chimps.bddselenium.views.RoomTrendDashBoard;
import lombok.Getter;
import org.openqa.selenium.support.events.EventFiringWebDriver;

@Getter
public class RoomAnalyticsActions extends ActionBase {
    private RoomTrendDashBoard roomTrendDashBoard;
    private RoomAnalyticsPage roomAnalyticsPage;
    private RoomAnalyticsReportCriteria criteria;
    private RoomAnalyticsDisplayCriteria roomAnalyticsDisplayCriteria;
    public RoomAnalyticsActions(EventFiringWebDriver driver, User user) {
        super(driver, user);
    }

    public void nagivateToRoomAnalytics(){
        roomTrendDashBoard=propertyHomePage.navigateToRoomTrend();
        roomAnalyticsPage=roomTrendDashBoard.clickRoomAnalyticsScorecard();
        criteria= roomAnalyticsPage.openCriteria();
        //criteria=roomAnalyticsPage.getCriteriaPopupIfOpen();
    }

    public void selectReportCriteria(RoomsAnalyticsReportCriteria reportCriteria){

        if(reportCriteria.getDateRange().getStartDate()!=null){
            calenderPop=criteria.clickOnPrimaryDateRange();
            calenderPop.selectDateRange(reportCriteria.getDateRange().getStartDate(),reportCriteria.getDateRange().getEndDate());
        }else if(reportCriteria.getImpactEvent()!=null){

        }

        criteria.selectPrimaryData(reportCriteria.getPrimaryDataType());

        if(reportCriteria.getPrimaryDataType().equals("Last Submitted")){

        }

        if(reportCriteria.getSameRange()!=null || reportCriteria.getSameRange().size()!=0){
            criteria.clickSameRangeDropDown();
            reportCriteria.getSameRange().stream().forEach((option)->{criteria.selectOptionInSameRange(option);});
            criteria.clickSameRangeDropDown();
        }

        if(reportCriteria.getPriorYear()!=null || reportCriteria.getPriorYear().size()!=0){
            criteria.clickPriorYearDropDown();
            reportCriteria.getSameRange().stream().forEach((option)->{criteria.selectOptionInPriorYear(option);});
            criteria.clickPriorYearDropDown();
        }

    }
}
