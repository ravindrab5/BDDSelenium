package com.ideas.chimps.bddselenium.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
public class ReferenceDataPoint {
    private String occupancyDate; // Should be of format  YYYY-MM-DD
    private int propertyId;
    private String source;
    private String segment;
    private Double rn;
    private Double revenue;
    private List<Map<String,String>> tags;
    private String _class;
    private String stream;
    @Override
    public String toString() {
        return "{" +
                "occupancyDate='" + occupancyDate + '\'' +
                ", propertyId=" + propertyId +
                ", source='" + source + '\'' +
                ", segment='" + segment + '\'' +
                ", rn=" + rn +
                ", revenue=" + revenue +
                '}';
    }
}
