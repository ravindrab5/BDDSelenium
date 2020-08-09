package com.ideas.chimps.bddselenium.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SegmentCategory {
    private String categoryName;

    private int segmentType;

    private int managementSegmentTypeId;

    private int displayNo;

    private String managementCompanyId;

    private String segmentCategoryId;

    private List<CategorySubTotal> categorySubTotal;
}
