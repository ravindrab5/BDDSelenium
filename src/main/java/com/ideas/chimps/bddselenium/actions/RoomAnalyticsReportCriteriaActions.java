package com.ideas.chimps.bddselenium.actions;

import com.github.javafaker.Bool;
import com.ideas.chimps.bddselenium.views.CalenderPop;
import com.ideas.chimps.bddselenium.views.RoomAnalyticsPage;
import com.ideas.chimps.bddselenium.views.RoomAnalyticsReport;
import com.ideas.chimps.bddselenium.views.RoomAnalyticsReportCriteria;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class RoomAnalyticsReportCriteriaActions {
    private RoomAnalyticsReportCriteria roomAnalyticsReportCriteria;

    public RoomAnalyticsReportCriteriaActions(RoomAnalyticsReportCriteria roomAnalyticsReportCriteria){
        this.roomAnalyticsReportCriteria=roomAnalyticsReportCriteria;
    }

    public Supplier<RoomAnalyticsReport> clickOnGoButton;
    public Supplier<List<String>> listOfImpactEventForSelectedYear;
    public Supplier<String> priorYearSelectedText=()->roomAnalyticsReportCriteria.getPriorYearSelectText().getText();
    public Supplier<String> priorYearOneSelectedText;
    public Supplier<String> sameRangeSelectedText;
    public Supplier<List<String>> categoryOptions;
    public Supplier<List<String>> segementOptions;
    public Supplier<String> sliderMinimum;
    public Supplier<String> sliderMax;
    public Supplier<List<String>> allLabelsofPrimaryRadio;
    public Supplier<WebElement> allSectionOfPrimaryData;
    public Supplier<List<String>> dowOptions;
    public Supplier<List<String>> listDataFilterLabelsString;
    public Supplier<List<WebElement>> dataFiltersLabels;
    public Supplier<Boolean> isAllDropdownOfComparativeEnabled;
    public Supplier<Boolean> isAnyOfPrimaryRadioSelected;
    public Supplier<String> calenderLabelText;
    public Supplier<WebElement> impactEventYear;
    public Supplier<String> impactEventLabelText;
    public Supplier<CalenderPop> clickOnPrimaryDateRange;
    public Supplier<RoomAnalyticsPage> clickGo;
    public Supplier<List<String>> allSectionsLabelString;

    public Predicate<String> hasNoSameRangeOption;
    public Predicate<String> isPrimarySelected;





}
