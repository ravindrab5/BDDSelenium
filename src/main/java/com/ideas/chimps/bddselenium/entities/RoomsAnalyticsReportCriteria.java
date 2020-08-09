package com.ideas.chimps.bddselenium.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RoomsAnalyticsReportCriteria {
    private DateRange dateRange;
    private ImpactEvent impactEvent;
    private String impactEventYear;
    private String primaryDataType;
    private String primaryLastSubmissionName;
    private List<String> sameRange;
    private List<String> priorYear;
    private List<String> priorYearOne;
    private List<String> priorYearTwo;
    private List<String> dayOfWeek;
    private Integer occupancyStart;
    private Integer occupancyEnd;
    private List<String> categories;
    private List<String> subcategories;
    private List<String> segments;
}


