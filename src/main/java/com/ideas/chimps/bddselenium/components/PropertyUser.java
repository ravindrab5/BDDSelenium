package com.ideas.chimps.bddselenium.components;

import com.ideas.chimps.bddselenium.actionhelpers.UserTypeConstants;
import com.ideas.chimps.bddselenium.entities.*;
import com.ideas.chimps.bddselenium.util.RandomDataGenerator;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;



@Component
@Getter
public class PropertyUser extends UserAccess {

    private String payload;
    private com.ideas.chimps.bddselenium.entities.PropertyUser propertyUser;

    @Override
    public void createUserData(Map<String,String> permissions,ManagementCompany managementCompany, Property property) {
        RandomDataGenerator randomDataGenerator=new RandomDataGenerator();
        String firstname=randomDataGenerator.getFirstName();
        String lastname=randomDataGenerator.getLastName();
        String email=randomDataGenerator.getEmailId();
        String title=firstname+lastname;
        String displayName=title;
        propertyUser=(com.ideas.chimps.bddselenium.entities.PropertyUser)mapperJson("jsons/createPropertyUser.json", com.ideas.chimps.bddselenium.entities.PropertyUser.class);
        propertyUser.setFirstName(firstname);
        propertyUser.setLastName(lastname);
        propertyUser.setEmail(email);
        propertyUser.setTitle(title);
        propertyUser.setDisplayName(displayName);

        propertyUser.setPropertyId(String.valueOf(property.getPropertyId()));
        propertyUser.setManagementCompanyId(String.valueOf(managementCompany.getManagementCompanyId()));

       propertyUser.getModuleLevelAccessInfo().get(0).get("intel").stream().flatMap((n)->n.getSubModules().stream()).forEach((submodule)->{
           submodule.setAction(permissions.get(submodule.getModule()));
       });

        propertyUser.getModuleLevelAccessInfo().get(1).get("planning").stream().flatMap((n)->n.getSubModules().stream()).forEach((submodule)->{
            submodule.setAction(permissions.get(submodule.getModule()));
        });

        propertyUser.getModuleLevelAccessInfo().get(2).get("management").stream().flatMap((n)->n.getSubModules().stream()).forEach((submodule)->{
            submodule.setAction(permissions.get(submodule.getModule()));
        });
        payload=getJsonStringFromEntity(propertyUser);

    }

    @Override
    public User createUser() {
        login();
        doPost(propertyUser,apiConfig.getPropertyUser());
        setPassword(propertyUser.getEmail());
        User user=new User(propertyUser.getEmail(),"ID6asMar5", UserTypeConstants.PROPERTY_USER);
        return user;
    }
}
