package com.ideas.chimps.bddselenium.tests;

import com.ideas.chimps.bddselenium.actionhelpers.UserTypeConstants;
import com.ideas.chimps.bddselenium.components.PropertyUser;
import com.ideas.chimps.bddselenium.components.UserAccess;
import com.ideas.chimps.bddselenium.components.UserPermissionData;
import com.ideas.chimps.bddselenium.config.EnvironmentConfig;
import com.ideas.chimps.bddselenium.entities.Property;
import com.ideas.chimps.bddselenium.util.ApiController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUserModule {
    public static void main(String args[]) throws Exception{
    /*    System.setProperty("env","localhost");
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(EnvironmentConfig.class);
        PropertyUser controller=context.getBean("propertyUser",PropertyUser.class);
        UserPermissionData userPermissionData=new UserPermissionData();
        controller.createUserData(userPermissionData.getPropertyUserPermission());*/

        System.setProperty("env","qa2");
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(EnvironmentConfig.class);
        ApiController controller=context.getBean("apiController",ApiController.class);
///        System.out.println(controller.login().getBody().jsonPath().getString("access_token"));

        controller.login();
        System.out.println(controller.createManagementCompany());
        controller.doGeoSetup();
        Thread.sleep(2000);
        System.out.println(controller.defineSegmentTypes().statusCode());
        Thread.sleep(2000);
        System.out.println(controller.defineSegmentCategoryStructure().statusCode());
        Thread.sleep(2000);
        controller.createProperty();
        Thread.sleep(2000);
        controller.createCompanySegment();
        Thread.sleep(2000);
        controller.createSegment();
        //Thread.sleep(2000);
        //controller.deactiveManagementId();
        Thread.sleep(2000);
        //     controller.generateRdpData();
        //  System.out.println(new Date());
        controller.createImpactEvent();
       // PropertyUser controller=context.getBean("propertyUser",PropertyUser.class);
        UserPermissionData userPermissionData=new UserPermissionData();
        controller.createNewUser(UserTypeConstants.PROPERTY_USER,userPermissionData.getPropertyUserPermission());
        context.close();
    }
}
