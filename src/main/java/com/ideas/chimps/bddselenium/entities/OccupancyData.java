package com.ideas.chimps.bddselenium.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class OccupancyData {
    private int propertyId;
    private String occupancyDate;  // Should be of format  YYYY-MM-DD
    private int netAvlRms;
    private String source;
    private int hotelCapacity;
    private int oooRooms;
    private int roomsSold;
}
