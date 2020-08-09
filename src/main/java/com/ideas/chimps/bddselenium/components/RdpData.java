package com.ideas.chimps.bddselenium.components;


import com.ideas.chimps.bddselenium.entities.ReferenceDataPoint;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
public class RdpData {
    private List<ReferenceDataPoint> allReferenceDataPoints;
    private double totalRn;
    private double totalRev;


    public RdpData(){
        allReferenceDataPoints=new ArrayList<ReferenceDataPoint>();
        totalRev=0;
        totalRn=0;
    }

    // method startDate,EndDate,list of segment,rn,revenue,source

    public List<ReferenceDataPoint> generateRdpData(LocalDate startDate, LocalDate endDate, List<String> segments, double rn, double rev, String source, int propertyId){
        List<LocalDate> dates=new ArrayList<LocalDate>();
        LocalDate sdate=startDate;
        for(;!(sdate.toString().equals(endDate.toString()));){
            dates.add(sdate);
            sdate=sdate.plusDays(1);
        }
        dates.add(endDate);
        List<ReferenceDataPoint> referenceDataPoints=new ArrayList<ReferenceDataPoint>();
        dates.stream().forEach(date->{
            segments.stream().forEach(segment->{
                ReferenceDataPoint rdp=new ReferenceDataPoint();
                rdp.setOccupancyDate(date.toString());
                rdp.setPropertyId(propertyId);
                rdp.setSource(source);
                rdp.setRn(rn);
                rdp.setRevenue(rev);
                rdp.setSegment(segment);
                rdp.set_class("com.ideas.chimps.data.dto.ReferenceDataPointAggregation");
                rdp.setStream("ROOMS");
                rdp.setTags(new ArrayList<>());
                referenceDataPoints.add(rdp);
                totalRn+=rn;
                totalRev+=rev;
             });
        });
        allReferenceDataPoints.addAll(referenceDataPoints);
      return referenceDataPoints;
    }

 }
