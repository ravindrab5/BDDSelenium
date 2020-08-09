package com.ideas.chimps.bddselenium.components;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class UserPermissionData {
    private Map<String,String> propertyUserPermission;
    private Map<String,String> propertyAdminData;

    public UserPermissionData(){
        // default data setting.
        propertyUserPermission=new HashMap<>();
        propertyUserPermission.put("PACE_PICKUP","UPDATE");
        propertyUserPermission.put("GROUP_ANALYTICS","READ");
        propertyUserPermission.put("ROOMS","READ");
        propertyUserPermission.put("FOOD_BEVERAGE","UPDATE");
        propertyUserPermission.put("ROOMS_FORECASTING","READ");
        propertyUserPermission.put("RESIDENT_GUEST_FORECASTING","READ");
        propertyUserPermission.put("SUBMISSION_SCHEDULE","UPDATE");
        propertyUserPermission.put("FINANCIAL_EXPORT",null);
    }
}
