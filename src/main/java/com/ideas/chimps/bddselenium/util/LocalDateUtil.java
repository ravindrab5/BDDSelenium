package com.ideas.chimps.bddselenium.util;


import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LocalDateUtil {

    public String getTodayDate(){
        return LocalDate.now().toString();
    }

    public LocalDate getLocalDateToday(){
        return LocalDate.now();
    }
}
