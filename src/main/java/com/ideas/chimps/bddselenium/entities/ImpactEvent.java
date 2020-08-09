package com.ideas.chimps.bddselenium.entities;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class ImpactEvent {
    private String name;
    private String revImpact;
    private String effect;
    private String type;

    @Override
    public String toString() {
        return "ImpactEvent{" +
                "name='" + name + '\'' +
                ", revImpact='" + revImpact + '\'' +
                ", effect='" + effect + '\'' +
                ", type='" + type + '\'' +
                ", frequency='" + frequency + '\'' +
                ", managementCompanyId='" + managementCompanyId + '\'' +
                ", propertyId='" + propertyId + '\'' +
                ", interval='" + interval + '\'' +
                ", duration='" + duration + '\'' +
                ", eventInstances=" + eventInstances +
                '}';
    }

    private String frequency;
    private String managementCompanyId;
    private String propertyId;
    private String interval;
    private String duration;
    private List<EventInstances> eventInstances;
}
