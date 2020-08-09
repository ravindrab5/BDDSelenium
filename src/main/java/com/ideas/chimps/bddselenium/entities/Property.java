package com.ideas.chimps.bddselenium.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Property {
    private String managementCompanyId;

    private Integer propertyId;

    private String propertyName;

    private String activationStartDate;

    private String activationEndDate;

    private String chimpsId;

    private String selectedTypeOfBussiness;

    private String selectedSubTypeOfBussiness;

    private String licenceContactInitial;

    private String licenceContactFirstName;

    private String licenceContactLastName;

    private String contactTitle;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String postalCode;

    private String state;

    private String country;

    private String diallingPrefix;

    private String areaCode;

    private String phoneNumber;

    private String contactEmail;

    private String mobileNumber;

    private String admin1Id;

    private String admin1Initial;

    private String admin1FirstName;

    private String admin1LastName;

    private String admin1Email;

    private String admin2Id;

    private String admin2Initial;

    private String admin2FirstName;

    private String admin2LastName;

    private String admin2Email;

    private String measurementName;

    private String fiscalCurrency;

    private String timeFormat;

    private String timezone;

    private String dateFormat;

    private String systemLanguage;

    private String selectedPmsList;

    private String pmsId;

    private String selectedSnCList;

    private String snCId;

    private String selectedRmsList;

    private String rmsId;

    private String selectedFrsList;

    private String frsId;

    private String snCCurrency;

    private int hotelCapacity;

    private String apartmentCapacity;

    private String voCapacity;

    private String hostelAccommodationCapacity;

    private String associatePropertyCapacity;

    private int frsStructure;

    private String complex;

    private String complexRegion;

    private String linkToComplex;

    private PropertyOperationSetups propertyOperationSetups;

    private int geoId;

    private List<Admins> admins;

}
