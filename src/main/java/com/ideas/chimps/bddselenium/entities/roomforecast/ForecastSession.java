package com.ideas.chimps.bddselenium.entities.roomforecast;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class ForecastSession {

    private Integer propertyId;
    private String startDate;
    private String endDate;
    private String defaultCompareTo;
    private Map<String, List<Forecast>> sessions;

    public ForecastSession(Integer propertyId, String startDate, String endDate, String defaultCompareTo) {
        this.propertyId = propertyId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.defaultCompareTo = defaultCompareTo;
    }

    @Builder
    public ForecastSession(Integer propertyId, String startDate, String endDate, String defaultCompareTo, Map<String, List<Forecast>> sessions) {
        this.propertyId = propertyId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.defaultCompareTo = defaultCompareTo;
        this.sessions = sessions;
    }
}
