package com.ideas.chimps.bddselenium.entities.accountintel;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PMSStayRaw {
    public static final String COLLECTION_PMS_STAY_RAW = "pmsStayRaw";

    private String id;
    protected Integer propertyId;
    protected Date occupancyDate;
    protected String propertyCode;
    protected Date retrievalDate;
    protected String confirmationNumber;
    protected Date bookedDate;
    protected Date cancellationDate;
    protected Date arrivalDate;
    protected Date departureDate;
    protected Integer reservationRoomCount;
    protected String marketSegment;
    protected String marketCode;
    protected String rateCode;
    protected String bookingChannel;
    protected String bookingSubChannel;
    protected String countryCode;
    protected String stateCode;
    protected String city;
    protected String postalCode;
    protected String reservationStatus;
    protected String isSharerRoom;
    protected String isPseudoRoom;
    protected String stayedRoomType;
    protected String bookedRoomType;
    protected Double roomRevenue;
    protected Double foodRevenue;
    protected Double otherRevenue;
    protected Double revenueNotAllocated;
    protected Double totalRevenue;
    // TODO: Room number should be a string for room numbers like "123A" - change once the Akka OTB job has been retired
    protected String roomNumber;
    protected Double foodBevRevenueIncludedInRate;
    protected Double otherRevenueIncludedInRate;
    protected Integer numberOfAdults;
    protected Integer numberOfChildren;
    protected String companyProfileID;
    protected String companyProfileName;
    protected String masterCompanyProfileID;
    protected String masterCompanyProfileName;
    protected String travelAgencyProfileID;
    protected String travelAgencyMasterProfileId;
    protected String travelAgencyMasterProfileName;
    protected String iataNumber;
    protected String agencyProfileName;
    protected String groupId;
    protected Double commissionPercent;
    protected String promotionCode;
    protected String paymentMethod;
    protected Double upsellRevenue;
    protected String correlationId;
}
