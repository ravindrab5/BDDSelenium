package com.ideas.chimps.bddselenium.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class EventInstances {
    @Override
    public String toString() {
        return "EventInstances{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }

    private String startDate;
    private String endDate;
}
