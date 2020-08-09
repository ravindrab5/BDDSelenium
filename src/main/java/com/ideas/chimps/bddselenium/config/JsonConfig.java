package com.ideas.chimps.bddselenium.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class JsonConfig {
    @Value("${managementCompany}")
    private String managementCompany;

    @Value("${impactevent}")
    private String impactEvent;

    @Value("${forecastSession}")
    private String forecastSession;

}
