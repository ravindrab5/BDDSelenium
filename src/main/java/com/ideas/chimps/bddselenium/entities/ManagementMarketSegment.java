package com.ideas.chimps.bddselenium.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ManagementMarketSegment {
    private String managementCompanyId;

    private String typeId;

    private String typeName;

    private int virtualType;

    private String virtualTypeName;

    private String companySegmentCode;

    private String segmentDescription;

    private String forecastMethod;

    private boolean showCheck;

    private String nameSpace;

    private int segmentRank;

    private List<String> erpCodeUnit;

    private List<String> erpCodeRev;

    private String categoryName;

    private String categoryRank;

    private String subCategoryName;

    private String subcategoryRank;

    private Boolean disabled;
}
