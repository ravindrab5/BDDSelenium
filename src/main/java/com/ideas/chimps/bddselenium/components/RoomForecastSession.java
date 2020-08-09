package com.ideas.chimps.bddselenium.components;


import com.ideas.chimps.bddselenium.entities.ManagementCompany;
import com.ideas.chimps.bddselenium.entities.Property;
import com.ideas.chimps.bddselenium.entities.roomforecast.ForecastSession;
import com.ideas.chimps.bddselenium.entities.roomforecast.ForecastSessionDTO;

import java.util.List;

public class RoomForecastSession extends ApiBase{

    public ForecastSession createForeCastSession(ManagementCompany managementCompany, Property property, List<ForecastSessionDTO> forecastSessionDto){
        ForecastSession forecastSession=(ForecastSession)mapperJson(jsonConfig.getForecastSession(),ForecastSession.class);
        forecastSession.getSessions().clear();

        return null;
    }

}
