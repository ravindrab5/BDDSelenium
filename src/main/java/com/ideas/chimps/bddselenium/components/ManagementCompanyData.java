package com.ideas.chimps.bddselenium.components;


import com.ideas.chimps.bddselenium.entities.*;
import com.ideas.chimps.bddselenium.util.RandomDataGenerator;
import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManagementCompanyData {

    private ManagementCompany managementCompany;

    private ManagementCompanyGeoSetup managementCompanyGeoSetup;

    private ManagementSegmentTypes managementSegmentTypes;

    private SegmentStruture segmentStruture;

    private ManagementSegmentTypeDTO marketSegmentDto;

    private Property property;

    public ManagementCompanyData(){

    }

    public ManagementCompany getManagementCompany(){
        RandomDataGenerator dataGenerator=new RandomDataGenerator();
        Admins admins=new Admins("Mr.",dataGenerator.getFirstName(),dataGenerator.getLastName(),dataGenerator.getEmailId(),1);
        List<Admins> adminsList=new ArrayList<Admins>();
        adminsList.add(admins);
        return new ManagementCompany("MANAGEMENTCOMPANY",dataGenerator.getManagementCompanyName().replace("'",""),"mr",dataGenerator.getFirstName(),dataGenerator.getLastName(),dataGenerator.getAddress(),dataGenerator.getCountry(),"+91",dataGenerator.getCity(),dataGenerator.getPinCode(),"21",dataGenerator.getPhoneNumber(),"Mr.",dataGenerator.getFirstName(),dataGenerator.getLastName(), LocalDateTime.now().toLocalDate().toString(),"1",dataGenerator.getClientCode(),"Management Company",dataGenerator.getEmailId(),dataGenerator.getAddress(),dataGenerator.getState(),dataGenerator.getMobileNo(),dataGenerator.getEmailId(),null,adminsList);
    }

    public ManagementCompanyGeoSetup getManagementCompanyGeoSetup(String name){

        ManagementCompanyGeoSetupDTOS dtos1=new ManagementCompanyGeoSetupDTOS();
        ManagementCompanyGeoSetupDTOS dtos2=new ManagementCompanyGeoSetupDTOS();
        ManagementCompanyGeoSetupHeaders setupHeaders=new ManagementCompanyGeoSetupHeaders();
        managementCompanyGeoSetup=new ManagementCompanyGeoSetup();

        setupHeaders.setName(name);
        setupHeaders.setError(false);

        dtos1.setName("Pune");
        dtos1.setSequenceNo(0);

        dtos2.setName("Mumbai");
        dtos2.setSequenceNo(1);

        List<ManagementCompanyGeoSetupDTOS> dtoses=new ArrayList<ManagementCompanyGeoSetupDTOS>();
        dtoses.add(dtos1);
        dtoses.add(dtos2);

        List<ManagementCompanyGeoSetupHeaders> setHeaders=new ArrayList<ManagementCompanyGeoSetupHeaders>();
        setHeaders.add(setupHeaders);

        managementCompanyGeoSetup.setManagementCompanyGeoSetupDTOS(dtoses);
        managementCompanyGeoSetup.setManagementCompanyGeoSetupHeaders(setHeaders);

        return managementCompanyGeoSetup;
    }

    public ManagementSegmentTypeDTO getmanagementSegmentTypeDTO(Integer managementCompanyId){

        marketSegmentDto = new ManagementSegmentTypeDTO();
        marketSegmentDto.setManagementCompanyId(String.valueOf(managementCompanyId));
        marketSegmentDto.setManagementSegmentTypeId("1");
        marketSegmentDto.setManagementSegmentName("Hotel");
        marketSegmentDto.setVirtualType("1");
        marketSegmentDto.setVirtualTypeName("Hotel");
        return marketSegmentDto;

    }

    public ManagementSegmentTypes getManagementSegmentTypes(ManagementSegmentTypeDTO marketSegmentDto,Integer managementCompanyId){
        List<ManagementSegmentTypeDTO> segmentTypeDtos=new ArrayList<ManagementSegmentTypeDTO>();
        segmentTypeDtos.add(marketSegmentDto);
        managementSegmentTypes=new ManagementSegmentTypes();
        managementSegmentTypes.setManagementSegmentTypeDTO(segmentTypeDtos);
        return managementSegmentTypes;
    }

    public SegmentStruture getSegmentStruture(ManagementSegmentTypeDTO segmentTypeDTO){
        CategorySubTotal subcat1=new CategorySubTotal();
        subcat1.setSubCategoryName("Non Contracted");
        subcat1.setDisplayNo(1);
        subcat1.setSubCategoryId("");
        subcat1.setManagementCompanyId(String.valueOf(segmentTypeDTO.getManagementCompanyId()));

        CategorySubTotal subcat2=new CategorySubTotal();
        subcat2.setSubCategoryName("Contracted");
        subcat2.setDisplayNo(2);
        subcat2.setSubCategoryId("");
        subcat2.setManagementCompanyId(String.valueOf(segmentTypeDTO.getManagementCompanyId()));

        List<CategorySubTotal> catSubTotalList=new ArrayList<CategorySubTotal>();
        catSubTotalList.add(subcat1);
        catSubTotalList.add(subcat2);

        SegmentCategory segCat1=new SegmentCategory();

        segCat1.setCategoryName("TRANSIENT");
        segCat1.setSegmentType(1);
        segCat1.setManagementSegmentTypeId(1);
        segCat1.setDisplayNo(1);
        segCat1.setManagementCompanyId(String.valueOf(segmentTypeDTO.getManagementCompanyId()));
        segCat1.setSegmentCategoryId("");
        segCat1.setCategorySubTotal(catSubTotalList);

        SegmentCategory segCat2=new SegmentCategory();

        segCat2.setCategoryName("Other Total");
        segCat2.setSegmentType(1);
        segCat2.setManagementSegmentTypeId(1);
        segCat2.setDisplayNo(2);
        segCat2.setManagementCompanyId(String.valueOf(segmentTypeDTO.getManagementCompanyId()));
        segCat2.setSegmentCategoryId("");
        segCat2.setCategorySubTotal(new ArrayList<>());

        List<SegmentCategory> segCatList=new ArrayList<SegmentCategory>();
        segCatList.add(segCat1);
        segCatList.add(segCat2);

        segmentTypeDTO.setSegmentCategory(segCatList);
        List<ManagementSegmentTypeDTO> listSegTypeDTO=new ArrayList<ManagementSegmentTypeDTO>();
        listSegTypeDTO.add(segmentTypeDTO);
        SegmentStruture segmentStruture=new SegmentStruture();
        segmentStruture.setManagementSegmentTypeDTO(listSegTypeDTO);

        return segmentStruture;
    }


    public Property getProperty(String managementCompanyId){
        RandomDataGenerator dataGenerator=new RandomDataGenerator();
        property=new Property();
        property.setManagementCompanyId(managementCompanyId);
        property.setPropertyName(dataGenerator.getPropertyName().replace("'",""));
        property.setActivationStartDate(LocalDateTime.now().toLocalDate().toString());
        property.setActivationEndDate(LocalDateTime.now().toLocalDate().toString());
        property.setChimpsId("1");
        property.setSelectedTypeOfBussiness("1");
        property.setSelectedSubTypeOfBussiness("1");
        property.setLicenceContactInitial("mr");
        property.setLicenceContactFirstName(dataGenerator.getFirstName());
        property.setLicenceContactLastName(dataGenerator.getLastName());
        property.setContactTitle("PROPERTY");
        property.setAddressLine1(dataGenerator.getAddress());
        property.setAddressLine2(dataGenerator.getAddress());
        property.setCity(dataGenerator.getCity());
        property.setPostalCode(dataGenerator.getPinCode());
        property.setState(dataGenerator.getState());
        property.setCountry(dataGenerator.getCountry());
        property.setDiallingPrefix("+91");
        property.setAreaCode("20");
        property.setPhoneNumber(dataGenerator.getPhoneNumber());
        property.setContactEmail(dataGenerator.getEmailId());
        property.setMobileNumber(dataGenerator.getMobileNo());
        property.setAdmin1Initial("mr");
        property.setAdmin1FirstName(dataGenerator.getFirstName());
        property.setAdmin1LastName(dataGenerator.getLastName());
        property.setAdmin1Email(dataGenerator.getEmailId());
        property.setMeasurementName("Metric");
        property.setFiscalCurrency("INR");
        property.setTimeFormat("24 Hours Clock");
        property.setTimezone("(UTC+05:30) Asia/Kolkata");
        property.setDateFormat("DD/MM/YYYY");
        property.setSystemLanguage("1");
        property.setSelectedPmsList("1");
        property.setPmsId(dataGenerator.getPmsCode());
        property.setSelectedSnCList("1");
        property.setSnCId(dataGenerator.getPmsCode());
        property.setSelectedRmsList("2");
        property.setSelectedFrsList("1");
        property.setSnCCurrency("INR");
        property.setHotelCapacity(500);
        property.setFrsStructure(1);
        property.setComplex("No");
        property.setComplexRegion("");
        property.setLinkToComplex("");
        property.setPropertyOperationSetups(new PropertyOperationSetups());
        RandomDataGenerator dataGenerator1=new RandomDataGenerator();
        Admins admins=new Admins("Mr.",dataGenerator1.getFirstName(),dataGenerator1.getLastName(),dataGenerator1.getEmailId(),1);

        List<Admins> adminlist=new ArrayList<Admins>();
        adminlist.add(admins);

        property.setAdmins(adminlist);
        return property;
    }

    public List<PropertyMarketSegment> getMarketSegment(String managementCompanyId, String propertyId){
        PropertyMarketSegment seg1=new PropertyMarketSegment();
        seg1.setManagementCompanyId(managementCompanyId);
        seg1.setTypeId("1");
        seg1.setTypeName("Hotel");
        seg1.setVirtualType(1);
        seg1.setVirtualTypeName("Hotel");
        seg1.setPropertyId(propertyId);
        seg1.setPropertySegmentCode("RET1P");
        seg1.setSegmentDescription("RET1");
        seg1.setForecastMethod("SEGMENT_PICKUP");
        seg1.setShowCheck(true);
        seg1.setNameSpace("MARKETSEGMENT");
        seg1.setPropertySegmentRank(1);
        seg1.setErpCodeUnit(new ArrayList<>());
        seg1.setErpCodeRev(new ArrayList<>());
        seg1.setCategoryName("TRANSIENT");
        seg1.setCategoryRank("1");
        seg1.setSubCategoryName("Non Contracted");
        seg1.setSubcategoryRank("1");
        seg1.setCompanySegmentCode("RET1SP");
        seg1.setSegmentRank("1");

        PropertyMarketSegment seg2=new PropertyMarketSegment();
        seg2.setManagementCompanyId(managementCompanyId);
        seg2.setTypeId("1");
        seg2.setTypeName("Hotel");
        seg2.setVirtualType(1);
        seg2.setVirtualTypeName("Hotel");
        seg2.setPropertyId(propertyId);
        seg2.setPropertySegmentCode("RET2P");
        seg2.setSegmentDescription("RET2");
        seg2.setForecastMethod("SEGMENT_PICKUP");
        seg2.setShowCheck(true);
        seg2.setNameSpace("MARKETSEGMENT");
        seg2.setPropertySegmentRank(2);
        seg2.setErpCodeUnit(new ArrayList<>());
        seg2.setErpCodeRev(new ArrayList<>());
        seg2.setCategoryName("TRANSIENT");
        seg2.setCategoryRank("1");
        seg2.setSubCategoryName("Non Contracted");
        seg2.setSubcategoryRank("1");
        seg2.setCompanySegmentCode("RET2SP");
        seg2.setSegmentRank("2");


        PropertyMarketSegment seg3=new PropertyMarketSegment();
        seg3.setManagementCompanyId(managementCompanyId);
        seg3.setTypeId("1");
        seg3.setTypeName("Hotel");
        seg3.setVirtualType(1);
        seg3.setVirtualTypeName("Hotel");
        seg3.setPropertyId(propertyId);
        seg3.setPropertySegmentCode("RET1NAP");
        seg3.setSegmentDescription("RET1NAP");
        seg3.setForecastMethod("SEGMENT_PICKUP");
        seg3.setShowCheck(true);
        seg3.setNameSpace("MARKETSEGMENT");
        seg3.setPropertySegmentRank(3);
        seg3.setErpCodeUnit(new ArrayList<>());
        seg3.setErpCodeRev(new ArrayList<>());
        seg3.setCategoryName("TRANSIENT");
        seg3.setCategoryRank("1");
        seg3.setSubCategoryName("Non Contracted");
        seg3.setSubcategoryRank("1");
        seg3.setCompanySegmentCode("RET1SNAP");
        seg3.setSegmentRank("3");

        PropertyMarketSegment seg4=new PropertyMarketSegment();
        seg4.setManagementCompanyId(managementCompanyId);
        seg4.setTypeId("1");
        seg4.setTypeName("Hotel");
        seg4.setVirtualType(1);
        seg4.setVirtualTypeName("Hotel");
        seg4.setPropertyId(propertyId);
        seg4.setPropertySegmentCode("NLRA1P");
        seg4.setSegmentDescription("NLRA1");
        seg4.setForecastMethod("SEGMENT_PICKUP");
        seg4.setShowCheck(true);
        seg4.setNameSpace("MARKETSEGMENT");
        seg4.setPropertySegmentRank(4);
        seg4.setErpCodeUnit(new ArrayList<>());
        seg4.setErpCodeRev(new ArrayList<>());
        seg4.setCategoryName("TRANSIENT");
        seg4.setCategoryRank("1");
        seg4.setSubCategoryName("Contracted");
        seg4.setSubcategoryRank("2");
        seg4.setCompanySegmentCode("NLRA1SP");
        seg4.setSegmentRank("4");

        PropertyMarketSegment seg5=new PropertyMarketSegment();
        seg5.setManagementCompanyId(managementCompanyId);
        seg5.setTypeId("1");
        seg5.setTypeName("Hotel");
        seg5.setVirtualType(1);
        seg5.setVirtualTypeName("Hotel");
        seg5.setPropertyId(propertyId);
        seg5.setPropertySegmentCode("NLRA2P");
        seg5.setSegmentDescription("NLRA2");
        seg5.setForecastMethod("SEGMENT_PICKUP");
        seg5.setShowCheck(true);
        seg5.setNameSpace("MARKETSEGMENT");
        seg5.setPropertySegmentRank(5);
        seg5.setErpCodeUnit(new ArrayList<>());
        seg5.setErpCodeRev(new ArrayList<>());
        seg5.setCategoryName("TRANSIENT");
        seg5.setCategoryRank("1");
        seg5.setSubCategoryName("Contracted");
        seg5.setSubcategoryRank("2");
        seg5.setCompanySegmentCode("NLRA2SP");
        seg5.setSegmentRank("5");

        PropertyMarketSegment seg6=new PropertyMarketSegment();
        seg6.setManagementCompanyId(managementCompanyId);
        seg6.setTypeId("1");
        seg6.setTypeName("Hotel");
        seg6.setVirtualType(1);
        seg6.setVirtualTypeName("Hotel");
        seg6.setPropertyId(propertyId);
        seg6.setPropertySegmentCode("Revenue Only");
        seg6.setSegmentDescription("Revenue Only");
        seg6.setForecastMethod("REVENUE_ONLY");
        seg6.setShowCheck(true);
        seg6.setNameSpace("MARKETSEGMENT");
        seg6.setPropertySegmentRank(6);
        seg6.setErpCodeUnit(new ArrayList<>());
        seg6.setErpCodeRev(new ArrayList<>());
        seg6.setCategoryName("TRANSIENT");
        seg6.setCategoryRank("1");
        seg6.setSubCategoryName("Contracted");
        seg6.setSubcategoryRank("2");
        seg6.setCompanySegmentCode("Revenue OnlyS");
        seg6.setSegmentRank("6");


        PropertyMarketSegment seg7=new PropertyMarketSegment();
        seg7.setManagementCompanyId(managementCompanyId);
        seg7.setTypeId("1");
        seg7.setTypeName("Hotel");
        seg7.setVirtualType(1);
        seg7.setVirtualTypeName("Hotel");
        seg7.setPropertyId(propertyId);
        seg7.setPropertySegmentCode("SegAP");
        seg7.setSegmentDescription("SegAP");
        seg7.setForecastMethod("BLK_AIR_CREW");
        seg7.setShowCheck(true);
        seg7.setNameSpace("MARKETSEGMENT");
        seg7.setPropertySegmentRank(7);
        seg7.setErpCodeUnit(new ArrayList<>());
        seg7.setErpCodeRev(new ArrayList<>());
        seg7.setCategoryName("Other Total");
        seg7.setCategoryRank("2");
        seg7.setCompanySegmentCode("SegSAP");
        seg7.setSegmentRank("7");

        PropertyMarketSegment seg8=new PropertyMarketSegment();
        seg8.setManagementCompanyId(managementCompanyId);
        seg8.setTypeId("1");
        seg8.setTypeName("Hotel");
        seg8.setVirtualType(1);
        seg8.setVirtualTypeName("Hotel");
        seg8.setPropertyId(propertyId);
        seg8.setPropertySegmentCode("SegBP");
        seg8.setSegmentDescription("SegBP");
        seg8.setForecastMethod("BLK_AIR_CREW");
        seg8.setShowCheck(true);
        seg8.setNameSpace("MARKETSEGMENT");
        seg8.setPropertySegmentRank(8);
        seg8.setErpCodeUnit(new ArrayList<>());
        seg8.setErpCodeRev(new ArrayList<>());
        seg8.setCategoryName("Other Total");
        seg8.setCategoryRank("2");
        seg8.setCompanySegmentCode("SegSBP");
        seg8.setSegmentRank("8");


        PropertyMarketSegment seg9=new PropertyMarketSegment();
        seg9.setManagementCompanyId(managementCompanyId);
        seg9.setTypeId("1");
        seg9.setTypeName("Hotel");
        seg9.setVirtualType(1);
        seg9.setVirtualTypeName("Hotel");
        seg9.setPropertyId(propertyId);
        seg9.setPropertySegmentCode("RoomsOnly");
        seg9.setSegmentDescription("RoomsOnly");
        seg9.setForecastMethod("BLK_AIR_CREW");
        seg9.setShowCheck(true);
        seg9.setNameSpace("MARKETSEGMENT");
        seg9.setPropertySegmentRank(9);
        seg9.setErpCodeUnit(new ArrayList<>());
        seg9.setErpCodeRev(new ArrayList<>());
        seg9.setCategoryName("Other Total");
        seg9.setCategoryRank("2");
        seg9.setCompanySegmentCode("RoomsSOnly");
        seg9.setSegmentRank("9");

        List<PropertyMarketSegment> segs=new ArrayList<PropertyMarketSegment>();
        segs.add(seg1);
        segs.add(seg2);
        segs.add(seg3);segs.add(seg4);segs.add(seg5);segs.add(seg6);segs.add(seg7);segs.add(seg8);segs.add(seg9);

        return segs;


    }


    public List<ManagementMarketSegment> getCompanyMarketSegment(String managementCompanyId){
        ManagementMarketSegment seg1=new ManagementMarketSegment();
        seg1.setManagementCompanyId(managementCompanyId);
        seg1.setTypeId("1");
        seg1.setTypeName("Hotel");
        seg1.setVirtualType(1);
        seg1.setVirtualTypeName("Hotel");
        seg1.setCompanySegmentCode("RET1SP");
        seg1.setSegmentDescription("RET1S");
        seg1.setForecastMethod("SEGMENT_PICKUP");
        seg1.setShowCheck(true);
        seg1.setNameSpace("MARKETSEGMENT");
        seg1.setSegmentRank(1);
        seg1.setErpCodeUnit(new ArrayList<>());
        seg1.setErpCodeRev(new ArrayList<>());
        seg1.setCategoryName("TRANSIENT");
        seg1.setCategoryRank("1");
        seg1.setSubCategoryName("Non Contracted");
        seg1.setSubcategoryRank("1");

        ManagementMarketSegment seg2=new ManagementMarketSegment();
        seg2.setManagementCompanyId(managementCompanyId);
        seg2.setTypeId("1");
        seg2.setTypeName("Hotel");
        seg2.setVirtualType(1);
        seg2.setVirtualTypeName("Hotel");
        seg2.setCompanySegmentCode("RET2SP");
        seg2.setSegmentDescription("RET2S");
        seg2.setForecastMethod("SEGMENT_PICKUP");
        seg2.setShowCheck(true);
        seg2.setNameSpace("MARKETSEGMENT");
        seg2.setSegmentRank(2);
        seg2.setErpCodeUnit(new ArrayList<>());
        seg2.setErpCodeRev(new ArrayList<>());
        seg2.setCategoryName("TRANSIENT");
        seg2.setCategoryRank("1");
        seg2.setSubCategoryName("Non Contracted");
        seg2.setSubcategoryRank("1");

        ManagementMarketSegment seg3=new ManagementMarketSegment();
        seg3.setManagementCompanyId(managementCompanyId);
        seg3.setTypeId("1");
        seg3.setTypeName("Hotel");
        seg3.setVirtualType(1);
        seg3.setVirtualTypeName("Hotel");
        seg3.setCompanySegmentCode("RET1SNAP");
        seg3.setSegmentDescription("RET1NAP");
        seg3.setForecastMethod("SEGMENT_PICKUP");
        seg3.setShowCheck(true);
        seg3.setNameSpace("MARKETSEGMENT");
        seg3.setSegmentRank(3);
        seg3.setErpCodeUnit(new ArrayList<>());
        seg3.setErpCodeRev(new ArrayList<>());
        seg3.setCategoryName("TRANSIENT");
        seg3.setCategoryRank("1");
        seg3.setSubCategoryName("Non Contracted");
        seg3.setSubcategoryRank("1");

        ManagementMarketSegment seg4=new ManagementMarketSegment();
        seg4.setManagementCompanyId(managementCompanyId);
        seg4.setTypeId("1");
        seg4.setTypeName("Hotel");
        seg4.setVirtualType(1);
        seg4.setVirtualTypeName("Hotel");
        seg4.setCompanySegmentCode("NLRA1SP");
        seg4.setSegmentDescription("NLRA1S");
        seg4.setForecastMethod("SEGMENT_PICKUP");
        seg4.setShowCheck(true);
        seg4.setNameSpace("MARKETSEGMENT");
        seg4.setSegmentRank(4);
        seg4.setErpCodeUnit(new ArrayList<>());
        seg4.setErpCodeRev(new ArrayList<>());
        seg4.setCategoryName("TRANSIENT");
        seg4.setCategoryRank("1");
        seg4.setSubCategoryName("Contracted");
        seg4.setSubcategoryRank("2");

        ManagementMarketSegment seg5=new ManagementMarketSegment();
        seg5.setManagementCompanyId(managementCompanyId);
        seg5.setTypeId("1");
        seg5.setTypeName("Hotel");
        seg5.setVirtualType(1);
        seg5.setVirtualTypeName("Hotel");
        seg5.setCompanySegmentCode("NLRA2SP");
        seg5.setSegmentDescription("NLRA2S");
        seg5.setForecastMethod("SEGMENT_PICKUP");
        seg5.setShowCheck(true);
        seg5.setNameSpace("MARKETSEGMENT");
        seg5.setSegmentRank(5);
        seg5.setErpCodeUnit(new ArrayList<>());
        seg5.setErpCodeRev(new ArrayList<>());
        seg5.setCategoryName("TRANSIENT");
        seg5.setCategoryRank("1");
        seg5.setSubCategoryName("Contracted");
        seg5.setSubcategoryRank("2");

        ManagementMarketSegment seg6=new ManagementMarketSegment();
        seg6.setManagementCompanyId(managementCompanyId);
        seg6.setTypeId("1");
        seg6.setTypeName("Hotel");
        seg6.setVirtualType(1);
        seg6.setVirtualTypeName("Hotel");
        seg6.setCompanySegmentCode("Revenue OnlyS");
        seg6.setSegmentDescription("Revenue OnlyS");
        seg6.setForecastMethod("REVENUE_ONLY");
        seg6.setShowCheck(true);
        seg6.setNameSpace("MARKETSEGMENT");
        seg6.setSegmentRank(6);
        seg6.setErpCodeUnit(new ArrayList<>());
        seg6.setErpCodeRev(new ArrayList<>());
        seg6.setCategoryName("TRANSIENT");
        seg6.setCategoryRank("1");
        seg6.setSubCategoryName("Contracted");
        seg6.setSubcategoryRank("2");


        ManagementMarketSegment seg7=new ManagementMarketSegment();
        seg7.setManagementCompanyId(managementCompanyId);
        seg7.setTypeId("1");
        seg7.setTypeName("Hotel");
        seg7.setVirtualType(1);
        seg7.setVirtualTypeName("Hotel");
        seg7.setCompanySegmentCode("SegSAP");
        seg7.setSegmentDescription("SegSAP");
        seg7.setForecastMethod("BLK_AIR_CREW");
        seg7.setShowCheck(true);
        seg7.setNameSpace("MARKETSEGMENT");
        seg7.setSegmentRank(7);
        seg7.setErpCodeUnit(new ArrayList<>());
        seg7.setErpCodeRev(new ArrayList<>());
        seg7.setCategoryName("Other Total");
        seg7.setCategoryRank("2");

        ManagementMarketSegment seg8=new ManagementMarketSegment();
        seg8.setManagementCompanyId(managementCompanyId);
        seg8.setTypeId("1");
        seg8.setTypeName("Hotel");
        seg8.setVirtualType(1);
        seg8.setVirtualTypeName("Hotel");
        seg8.setCompanySegmentCode("SegSBP");
        seg8.setSegmentDescription("SegSBP");
        seg8.setForecastMethod("BLK_AIR_CREW");
        seg8.setShowCheck(true);
        seg8.setNameSpace("MARKETSEGMENT");
        seg8.setSegmentRank(8);
        seg8.setErpCodeUnit(new ArrayList<>());
        seg8.setErpCodeRev(new ArrayList<>());
        seg8.setCategoryName("Other Total");
        seg8.setCategoryRank("2");

        ManagementMarketSegment seg9=new ManagementMarketSegment();
        seg9.setManagementCompanyId(managementCompanyId);
        seg9.setTypeId("1");
        seg9.setTypeName("Hotel");
        seg9.setVirtualType(1);
        seg9.setVirtualTypeName("Hotel");
        seg9.setCompanySegmentCode("RoomsSOnly");
        seg9.setSegmentDescription("RoomsSOnly");
        seg9.setForecastMethod("BLK_AIR_CREW");
        seg9.setShowCheck(true);
        seg9.setNameSpace("MARKETSEGMENT");
        seg9.setSegmentRank(9);
        seg9.setErpCodeUnit(new ArrayList<>());
        seg9.setErpCodeRev(new ArrayList<>());
        seg9.setCategoryName("Other Total");
        seg9.setCategoryRank("2");

        List<ManagementMarketSegment> segs=new ArrayList<ManagementMarketSegment>();
        segs.add(seg1);
        segs.add(seg2);
        segs.add(seg3);segs.add(seg4);segs.add(seg5);segs.add(seg6);segs.add(seg7);segs.add(seg8);segs.add(seg9);
        return segs;
    }
}
