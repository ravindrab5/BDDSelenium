package com.ideas.chimps.bddselenium.entities.accountintel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CompanyProfile {
    private Integer propertyId;
    private String companyProfileID;
    private String companyProfileName;
    private String masterCompanyProfileID;
    private Status status;
    private boolean contract;
    private boolean autoLink;
    private List<String> autoLinkConfig;
    private Date createdDate;
    private Date lastModifiedDate;
    private DataType dataType;
}

