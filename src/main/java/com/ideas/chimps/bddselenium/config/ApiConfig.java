package com.ideas.chimps.bddselenium.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ApiConfig {

    @Value("${auth}")
    private String auth;

    @Value("${createManagementCompany}")
    private String managementCompany;

    @Value("${managementCompanyList}")
    private String managementCompanyList;

    @Value("${geoSetup}")
    private String geoSetup;

    @Value("${managementSegmentTypes}")
    private String managementSegmentTypes;

    @Value("${marketSegmentStructure}")
    private String marketSegmentStructure;

    @Value("${createProperty}")
    private String createProperty;

    @Value("${propertySegmentStruture}")
    private String propertySegmentStruture;

    @Value("${managementSegmentStruture}")
    private String managementSegmentStruture;

    @Value("${deactiveManagementId}")
    private String deactiveManagementId;

    @Value("${rdpData}")
    private String rdpDataEndPoint;

    @Value("${impactEvent}")
    private String impactEvent;

    @Value("${propertyUser}")
    private String propertyUser;

    @Value("${propertyAdmin}")
    private String propertyAdmin;

    @Value("${managementAdmin}")
    private String managementAdmin;

    @Value("${setPassword}")
    private String setPassword;
}
