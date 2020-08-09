package com.ideas.chimps.bddselenium.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ManagementCompany {

    private Integer managementCompanyId;

    private String managementCompanyType;

    private String managementCompanyName;

    private String licenceContactInitial;

    private String licenceContactFirstName;

    private String licenceContactLastName;

    private String addressLine1;

    private String country;

    private String diallingPrefix;

    private String city;

    private String postalCode;

    private String areaCode;

    private String phoneNumber;

    private String admin1Initial;

    private String admin1FirstName;

    private String admin1LastName;

    private String activationDate;

    private String chimpsId;

    private String clientCode;

    private String contactTitle;

    private String contactEmail;

    private String addressLine2;

    private String state;

    private String mobileNumber;

    private String admin1Email;



    public ManagementCompany(String managementCompanyType, String managementCompanyName, String licenceContactInitial, String licenceContactFirstName, String licenceContactLastName, String addressLine1, String country, String diallingPrefix, String city, String postalCode, String areaCode, String phoneNumber, String admin1Initial, String admin1FirstName, String admin1LastName, String activationDate, String chimpsId, String clientCode, String contactTitle, String contactEmail, String addressLine2, String state, String mobileNumber, String admin1Email, String admin1Id, List<Admins> admins) {
        this.managementCompanyType = managementCompanyType;
        this.managementCompanyName = managementCompanyName;
        this.licenceContactInitial = licenceContactInitial;
        this.licenceContactFirstName = licenceContactFirstName;
        this.licenceContactLastName = licenceContactLastName;
        this.addressLine1 = addressLine1;
        this.country = country;
        this.diallingPrefix = diallingPrefix;
        this.city = city;
        this.postalCode = postalCode;
        this.areaCode = areaCode;
        this.phoneNumber = phoneNumber;
        this.admin1Initial = admin1Initial;
        this.admin1FirstName = admin1FirstName;
        this.admin1LastName = admin1LastName;
        this.activationDate = activationDate;
        this.chimpsId = chimpsId;
        this.clientCode = clientCode;
        this.contactTitle = contactTitle;
        this.contactEmail = contactEmail;
        this.addressLine2 = addressLine2;
        this.state = state;
        this.mobileNumber = mobileNumber;
        this.admin1Email = admin1Email;
        this.admin1Id = admin1Id;
        this.admin2Id = admin2Id;
        this.admins = admins;
    }

    private String admin1Id;

    private String admin2Id;

    private String deactivationDate;

    private List<Admins> admins;


    @Override
    public String toString() {
        return "ManagementCompany{" +
                "managementCompanyId=" + managementCompanyId +
                ", managementCompanyType='" + managementCompanyType + '\'' +
                ", managementCompanyName='" + managementCompanyName + '\'' +
                ", licenceContactInitial='" + licenceContactInitial + '\'' +
                ", licenceContactFirstName='" + licenceContactFirstName + '\'' +
                ", licenceContactLastName='" + licenceContactLastName + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", country='" + country + '\'' +
                ", diallingPrefix='" + diallingPrefix + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", admin1Initial='" + admin1Initial + '\'' +
                ", admin1FirstName='" + admin1FirstName + '\'' +
                ", admin1LastName='" + admin1LastName + '\'' +
                ", activationDate='" + activationDate + '\'' +
                ", chimpsId='" + chimpsId + '\'' +
                ", clientCode='" + clientCode + '\'' +
                ", contactTitle='" + contactTitle + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", state='" + state + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", admin1Email='" + admin1Email + '\'' +
                ", admin1Id='" + admin1Id + '\'' +
                ", admin2Id='" + admin2Id + '\'' +
                ", deactivationDate='" + deactivationDate + '\'' +
                ", admins=" + admins +
                '}';
    }
}
