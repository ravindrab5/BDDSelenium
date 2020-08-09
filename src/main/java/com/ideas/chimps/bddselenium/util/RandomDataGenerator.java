package com.ideas.chimps.bddselenium.util;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Random;


@Component
public class RandomDataGenerator {
    private String fullName;
    private String firstName;
    private String lastName;
    private String emailId;
    private String address;
    private String city;
    private String pinCode;
    private String clientCode;
    private String pmsCode;
    private static SecureRandom random = new SecureRandom();

    public String getMobileNo() {
        return mobileNo;
    }

    private String mobileNo;


    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    private String country;
    private String state;

    public String getManagementCompanyName() {
        return managementCompanyName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    private String managementCompanyName;
    private String propertyName;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private String phoneNumber;
    private Faker faker;


    public String getFullName() {
        return fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public String getClientCode(){return clientCode;}

    public String getPmsCode(){return pmsCode;}

    public RandomDataGenerator(){
        faker=new Faker(new Locale("en_IN"));
        firstName=faker.name().firstName();
        lastName=faker.name().lastName();
        fullName=firstName+" "+lastName;
        emailId=firstName+"."+lastName+"@ids.com";
        Address add=faker.address();
        address=add.fullAddress();
        city=add.city();
        pinCode=add.zipCode();
        phoneNumber=faker.phoneNumber().phoneNumber();
        managementCompanyName=faker.company().name();
        propertyName=managementCompanyName+"-"+faker.company().name();
        country=add.country();
        state=add.state();
        mobileNo="9873"+new Random().nextInt(999999);

        clientCode=generateRandomString(4);
        pmsCode=generateRandomString(4);
    }

    public String generateRandomString(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz".toUpperCase();

        SecureRandom random = new SecureRandom();

        if (length < 1) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {

            // 0-62 (exclusive), random returns 0-61
            int rndCharAt = random.nextInt(chars.length());
            char rndChar = chars.charAt(rndCharAt);
            sb.append(rndChar);

        }
        return sb.toString();
    }
}


