package com.ideas.chimps.bddselenium.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DateRange {
    private  LocalDate startDate;
    private LocalDate endDate;
}
