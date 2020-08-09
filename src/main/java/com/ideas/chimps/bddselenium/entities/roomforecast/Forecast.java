package com.ideas.chimps.bddselenium.entities.roomforecast;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Forecast {

    private String sessionName;
    private String startLogic;
    private String compareTo;

    public Forecast(String sessionName, String startLogic, String compareTo) {
        this.sessionName = sessionName;
        this.startLogic = startLogic;
        this.compareTo = compareTo;
    }
}
