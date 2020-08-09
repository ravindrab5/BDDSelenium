package com.ideas.chimps.bddselenium.util;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class UiLocalDateUtil {
    private Map<Integer,String> month;
    private LocalDate startDate;
    private LocalDate endDate;

    public UiLocalDateUtil(LocalDate startDate,LocalDate endDate){
        this.startDate = startDate;
        this.endDate=endDate;
        month=new HashMap<>();
        month.put(1,"Jan");
        month.put(2,"Feb");
        month.put(3,"Mar");
        month.put(4,"Apr");
        month.put(5,"May");
        month.put(6,"Jun");
        month.put(7,"Jul");
        month.put(8,"Aug");
        month.put(9,"Sep");
        month.put(10,"Oct");
        month.put(11,"Nov");
        month.put(12,"Dec");
    }

    public String getMonth(int val){
        return month.get(val);
    }

    public int getNoOfPrevClicksForYear(){
        int minYearInCalender=LocalDate.now().getYear();
        int maxYearInCalender=minYearInCalender+9;

        return getPrevCount(minYearInCalender);

    }

    public int getNoOfNextClicksForYear(){
        int minYearInCalender=LocalDate.now().getYear();
        int maxYearInCalender=minYearInCalender+9;

        return getNextCount(maxYearInCalender);

    }


    private int getPrevCount(int minYearInCalender){
        int count=0;
        while(startDate.getYear()<minYearInCalender){
            minYearInCalender-=9;
            count++;
        }
        return count;
    }

    private int getNextCount(int maxYearInCalender){
        int count=0;
        while(endDate.getYear()>maxYearInCalender){
            maxYearInCalender+=9;
            count++;
        }
        return count;
    }

    public String getCriteriaDateRangeFormattedText(){
        //Jan 24, 2020 - Jan 28, 2020

        String start_month=getMonth(startDate.getMonthValue());
        String end_month=getMonth(endDate.getMonthValue());
        String format=start_month+" "+startDate.getDayOfMonth()+", "+startDate.getYear()+" - "+end_month+" "+endDate.getDayOfMonth()+", "+endDate.getYear();
        return format;

    }

}
