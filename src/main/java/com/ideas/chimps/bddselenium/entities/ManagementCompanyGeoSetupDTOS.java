package com.ideas.chimps.bddselenium.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ManagementCompanyGeoSetupDTOS {
    private String id;

    private String name;

    private int sequenceNo;

    private List<String> childs;
}
