package com.ideas.chimps.bddselenium.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ManagementSegmentTypeDTO {
    private String managementCompanyId;

    private String managementSegmentTypeId;

    private String managementSegmentName;

    private String virtualType;

    private String virtualTypeName;

    private Integer propertyId;

    private List<SegmentCategory> segmentCategory;
}
