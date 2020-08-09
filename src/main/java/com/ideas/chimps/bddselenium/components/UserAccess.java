package com.ideas.chimps.bddselenium.components;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ideas.chimps.bddselenium.config.ApiConfig;
import com.ideas.chimps.bddselenium.config.CommonConfig;
import com.ideas.chimps.bddselenium.config.Environment;
import com.ideas.chimps.bddselenium.config.JsonConfig;
import com.ideas.chimps.bddselenium.entities.*;
import com.ideas.chimps.bddselenium.util.LogInitilizer;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


@Component
public abstract class UserAccess {
    protected ManagementCompany managementCompany;
    protected Property property;
    protected Logger logger;

    @Autowired
    protected Environment environment;

    @Autowired
    protected ApiConfig apiConfig;

    @Autowired
    protected CommonConfig commonConfig;

    @Autowired
    protected JsonConfig jsonConfig;

    private ObjectMapper objectMapper;

    protected String loginToken;


    public UserAccess(){
        logger= LogInitilizer.getLogger();
    }

    public Object mapperJson(String filepath,Class cls){
        File f=new File(this.getClass().getClassLoader().getResource(filepath).getPath());
        Object obj=null;
        objectMapper=new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return objectMapper.readValue(f,cls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }

    protected String getJsonStringFromEntity(Object obj){
        ObjectMapper Obj = new ObjectMapper();
        String jsonStr=null;
        try {
            // get Oraganisation object as a json string
            jsonStr = Obj.writeValueAsString(obj);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    public Response login(){
        String loginJson="{\"uniqueEmail\":\""+environment.getMarsUser()+"\",\"password\":\""+environment.getMarsUserPass()+"\"}";
        logger.info("Logging into the system with payload "+loginJson);

        baseURI=commonConfig.getBaseApiUrl();

        Response response=given().header("content-type", "application/json").when().body(loginJson).post(apiConfig.getAuth());

        loginToken=response.getBody().jsonPath().getString("access_token");

        logger.info("Response : "+ " | "+response.statusCode()+" | "+response.statusLine());

        return response;
    }

    public Response doPost(Object object,String api){

        String payload=getJsonStringFromEntity(object);
        logger.info("Creating the user  with payload "+payload+" PUT "+api);

        baseURI=commonConfig.getBaseApiUrl();

        Response response=given().header("content-type", "application/json").header("Authorization", "Bearer "+loginToken).when().body(payload).post(api);  //Creating the user
        logger.info("Response : "+response.statusCode()+" | "+response.statusLine());
        return response;
    }

    public Response setPassword(String emailId){

        logger.info("Chaning password of user - "+emailId);

        baseURI=commonConfig.getBaseApiUrl();

        Map<String,String> queryParams=new HashMap<String,String>();
        queryParams.put("uniqueEmailId",emailId);

        Response response=given().header("content-type", "application/json").header("Authorization", "Bearer "+loginToken).when().queryParams(queryParams).post(apiConfig.getSetPassword());  //Creating the user
        logger.info("Response : "+response.statusCode()+" | "+response.statusLine());
        return response;
    }

    public abstract void createUserData(Map<String,String> permissions,ManagementCompany managementCompany, Property property);

    public abstract User createUser();

}
