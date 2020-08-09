package com.ideas.chimps.bddselenium.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class PropertyUser {
    private int srNo;
    private String userAccountId;
    private String firstName;
    private String lastName;
    private String title;
    private String email;
    private String displayName;
    private String role;
    private List<String> userAccess;
    private boolean status;
    private String currentAction;
    private List<Map<String, List<ModuleAccess>>> moduleLevelAccessInfo;
    private String managementCompanyId;
    private String propertyId;
}
