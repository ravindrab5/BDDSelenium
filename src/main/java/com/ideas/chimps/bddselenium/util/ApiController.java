package com.ideas.chimps.bddselenium.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.ideas.chimps.bddselenium.actionhelpers.UserTypeConstants;
import com.ideas.chimps.bddselenium.components.ManagementCompanyData;
import com.ideas.chimps.bddselenium.components.PropertyUser;
import com.ideas.chimps.bddselenium.components.RdpData;
import com.ideas.chimps.bddselenium.components.UserAccess;
import com.ideas.chimps.bddselenium.config.ApiConfig;
import com.ideas.chimps.bddselenium.config.CommonConfig;
import com.ideas.chimps.bddselenium.config.Environment;
import com.ideas.chimps.bddselenium.config.JsonConfig;
import com.ideas.chimps.bddselenium.entities.*;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import lombok.Getter;
import net.minidev.json.JSONArray;
import org.apache.log4j.Logger;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import static io.restassured.RestAssured.*;


@Component
@Getter
public class ApiController {

    @Autowired
    protected Environment environment;

    @Autowired
    private ApiConfig apiConfig;

    @Autowired
    private CommonConfig commonConfig;

    @Autowired
    private JsonConfig jsonConfig;

    @Autowired
    private ManagementCompanyData managementCompanyData;

    @Autowired
    private JsonMapper jsonMapper;

    @Autowired
    UserAccess userAccess;

    private ManagementCompany managementCompany;

    private ManagementCompanyGeoSetup managementCompanyGeoSetup;

    private ManagementSegmentTypes managementSegmentTypes;

    private ManagementSegmentTypeDTO managementSegmentTypeDTO;

    private SegmentStruture segmentStruture;

    private Property property;

    private List<PropertyMarketSegment> propertyMarketSegmentList;

    private List<ManagementMarketSegment> managementMarketSegmentList;

    private List<ReferenceDataPoint> referenceDataPoints;

    private RdpData rdpData;

    private Logger logger;

    private String baseUrl;

    private String loginToken;

    private List<ImpactEvent> impactEvents;

    private User user;

    public ApiController(){
        logger=LogInitilizer.getLogger();
    }

    public Response login(){
        String loginJson="{\"uniqueEmail\":\""+environment.getMarsUser()+"\",\"password\":\""+environment.getMarsUserPass()+"\"}";
        logger.info("Logging into the system with payload "+loginJson);

        baseURI=environment.getApiUrl();

        logger.info("Base Uri - "+baseURI);

        Response response=given().header("content-type", "application/json").when().body(loginJson).post(apiConfig.getAuth());

        loginToken=response.getBody().jsonPath().getString("access_token");

        logger.info("Response : "+ " | "+response.statusCode()+" | "+response.statusLine());

        return response;
    }

    public ManagementCompany createManagementCompany(){
        managementCompany=managementCompanyData.getManagementCompany();

        String payload=getJsonStringFromEntity(managementCompany);
        logger.info("Creating the management company with payload "+payload+" PUT "+apiConfig.getManagementCompany());

        baseURI=environment.getApiUrl();

        Response response=given().header("content-type", "application/json").header("Authorization", "Bearer "+loginToken).when().body(payload).post(apiConfig.getManagementCompany());  // Creating the management company.
        logger.info("Response : "+response.statusCode()+" | "+response.statusLine());

        String jsonPath="$..managementCompanies[?(@.uniqueManagementCompanyName==\""+managementCompany.getManagementCompanyName().toLowerCase()+"\")].managementCompanyId";
        String json=given().header("content-type", "application/json").header("Authorization", "Bearer "+loginToken).when().get(apiConfig.getManagementCompanyList()+"?_="+ System.currentTimeMillis()).getBody().asString();

        JSONArray company_id= JsonPath.read(json,jsonPath);
        Integer companyId=Integer.parseInt(String.valueOf(company_id.get(0)));

        managementCompany.setManagementCompanyId(companyId);

        return managementCompany;
    }

    public Response doGeoSetup(){
        managementSegmentTypeDTO=managementCompanyData.getmanagementSegmentTypeDTO(managementCompany.getManagementCompanyId());
        managementCompanyGeoSetup=managementCompanyData.getManagementCompanyGeoSetup(managementCompany.getManagementCompanyName());

        String payload=getJsonStringFromEntity(managementCompanyGeoSetup);
        logger.info("Doing geo setup with payload : "+payload);

        String api=apiConfig.getGeoSetup().replace("#managementId",String.valueOf(managementCompany.getManagementCompanyId()));

        baseURI=environment.getApiUrl();


        Response response=given().header("content-type", "application/json").header("Authorization", "Bearer "+loginToken).when().body(payload).post(api);

        logger.info("Response - "+ response.statusCode() + " | "+response.statusLine());

        return response;

    }

    public Response defineSegmentTypes(){
        managementSegmentTypeDTO=managementCompanyData.getmanagementSegmentTypeDTO(managementCompany.getManagementCompanyId());
        managementSegmentTypes=managementCompanyData.getManagementSegmentTypes(managementSegmentTypeDTO,managementCompany.getManagementCompanyId());
        String payload=getJsonStringFromEntity(managementSegmentTypes);
        logger.info("Define the segment type + "+payload);

        Response response=given().header("content-type", "application/json").header("Authorization", "Bearer "+loginToken).when().body(payload).post(apiConfig.getManagementSegmentTypes()+"/"+managementCompany.getClientCode());
        logger.info("Response + "+response.statusCode()+" | "+response.getStatusLine());
        logger.info("Response - " + response.getBody().prettyPrint());
        return response;
    }



    public Response defineSegmentCategoryStructure(){
        segmentStruture=managementCompanyData.getSegmentStruture(managementSegmentTypeDTO);

        String payload=getJsonStringFromEntity(segmentStruture);
        logger.info("Defining management company segment category structure - "+payload);

        Response response=given().header("content-type", "application/json").header("Authorization", "Bearer "+loginToken).when().body(payload).post(apiConfig.getMarketSegmentStructure()+"/"+managementCompany.getClientCode());
        logger.info("Response + "+response.statusCode()+" | "+response.getStatusLine());

        return response;
    }

    public Response createProperty(){
        baseURI=environment.getApiUrl();
        logger.info("Base uri "+environment.getApiUrl());
        property=managementCompanyData.getProperty(String.valueOf(managementCompany.getManagementCompanyId()));
        String payload=getJsonStringFromEntity(property);
        logger.info("Creating property - "+payload);
        logger.info("Api path - "+apiConfig.getCreateProperty()+"/"+managementCompany.getClientCode());
        Response response=given()
                .header("content-type", "application/json")
                .header("Authorization", "Bearer "+loginToken)
                .when()
                .body(payload).post(apiConfig.getCreateProperty()+"/"+managementCompany.getClientCode().toLowerCase());


        logger.info("Response + "+response.statusCode()+" | "+response.getStatusLine());
        logger.info("Response + "+response.getBody());


        String jsonPath="$..propertyId";
        String responseJson=response.getBody().asString();

        JSONArray propertyId= JsonPath.read(responseJson,jsonPath);


        Integer propId=Integer.parseInt(String.valueOf(propertyId.get(0)));

        logger.info("Response + "+response.statusCode()+" | "+response.getStatusLine());
        logger.info("Response + "+response.getBody());

        property.setPropertyId(propId);
        return response;

    }

    public Response createCompanySegment(){
        managementMarketSegmentList =managementCompanyData.getCompanyMarketSegment(String.valueOf(managementCompany.getManagementCompanyId()));
        String payload=getJsonStringFromEntity(managementMarketSegmentList);
        logger.info("Createing the management company market segment +"+payload);

        Map<String,Integer> queryParams=new HashMap<String,Integer>();
        queryParams.put("managementCompanyId",managementCompany.getManagementCompanyId());
        logger.info("With Query params - "+queryParams);

        Response response=given().header("content-type", "application/json").header("Authorization", "Bearer "+loginToken).when().body(payload).queryParams(queryParams).post(apiConfig.getManagementSegmentStruture());
        logger.info("Response + "+response.statusCode()+" | "+response.getStatusLine());

        return null;

    }


    public Response createSegment(){
        propertyMarketSegmentList =managementCompanyData.getMarketSegment(String.valueOf(managementCompany.getManagementCompanyId()),String.valueOf(property.getPropertyId()));
        String payload=getJsonStringFromEntity(propertyMarketSegmentList);
        logger.info("Create segment - "+payload);

        Map<String,Integer> queryParams=new HashMap<String,Integer>();
        queryParams.put("managementCompanyId",managementCompany.getManagementCompanyId());
        queryParams.put("propertyId",property.getPropertyId());
        logger.info("With query -"+queryParams);

        Response response=given().header("content-type", "application/json").header("Authorization", "Bearer "+loginToken).when().body(payload).queryParams(queryParams).post(apiConfig.getPropertySegmentStruture());
        logger.info("Response + "+response.statusCode()+" | "+response.getStatusLine());
        return response;

    }

    public Response deactiveManagementId(){
        String apiPath=apiConfig.getDeactiveManagementId().replace("#managementId",String.valueOf(managementCompany.getManagementCompanyId()));
        logger.info("Deactive the management company "+apiPath);

        Response response=given().header("content-type", "application/json").header("Authorization", "Bearer "+loginToken).when().put(apiPath);
        logger.info("Response + "+response.statusCode()+" | "+response.getStatusLine());

        return response;
    }

    public void generateRdpData(){
        List<String> segments= Arrays.asList("RET1P","RET2P","RET1NAP","NLRA1P","NLRA2P","Revenue Only","SegAP","SegBP","RoomsOnly");
        String source="ACTIVE";
        double rn=10;
        double rev=10;
        LocalDate startDate= LocalDate.now().plusDays(-2);
        LocalDate endDate=LocalDate.now().plusDays(2);

        rdpData=new RdpData();

        referenceDataPoints= rdpData.generateRdpData(startDate,endDate,segments,rn,rev,source,property.getPropertyId());

        Map<String,Integer> queryParams=new HashMap<String,Integer>();
        queryParams.put("propertyId",property.getPropertyId());

        String payload=getJsonStringFromEntity(referenceDataPoints);
        logger.info("Creating rdp data with + "+payload);

        Response response=given().header("content-type", "application/json").header("Authorization", "Bearer "+loginToken).when().body(payload).queryParams(queryParams).post(apiConfig.getRdpDataEndPoint());
        logger.info("Response + "+response.statusCode()+" | "+response.getStatusLine());

    }

    public void createImpactEvent(){
        org.json.simple.JSONArray jsonlist=(org.json.simple.JSONArray)getDataFromFile(jsonConfig.getImpactEvent());
        logger.info("Impact event read - "+jsonlist);
        impactEvents=new ArrayList<>();
        for(Object ievent:jsonlist) {
            ImpactEvent event = (ImpactEvent) jsonMapper.getData(ievent.toString(), ImpactEvent.class);
            event.setManagementCompanyId(String.valueOf(managementCompany.getManagementCompanyId()));
            event.setPropertyId(String.valueOf(property.getPropertyId()));

            Map<String, String> queryParams = new HashMap<String, String>();
            int month = LocalDate.now().getMonthValue();
            int monthAdd = 12 - LocalDate.now().getMonthValue();
            queryParams.put("startDate", "2020-01-01");
            queryParams.put("endDate", "2020-12-31");
            String payload = getJsonStringFromEntity(event);
            logger.info("Creating impact event with + " + payload);
            Response response = given().header("content-type", "application/json").header("Authorization", "Bearer " + loginToken)
                    .when()
                    .log().all()
                    .body(payload)
                    .queryParams(queryParams)
                    .post(apiConfig.getImpactEvent()+"/"+managementCompany.getClientCode().toLowerCase()+"/"+property.getPmsId());
            logger.info("Response + " + response.statusCode() + " | " + response.getStatusLine());
            if(response.statusCode()==200){
                impactEvents.add(event);
            }
        }
    }

    public User createNewUser(String userTypeConstants,Map<String,String> permissions){

        if(userTypeConstants.equals("PROPERTYUSER")){
           // userAccess=new PropertyUser();
            userAccess.createUserData(permissions,managementCompany,property);
            user=userAccess.createUser();
        }
        return user;
    }

    private Object getDataFromFile(String path){
        String filename =this.getClass().getClassLoader().getResource(path).getFile();
        logger.info("Impact event read filename - "+filename);
        JSONParser parser = new JSONParser();
        Object obj=null;
        try {
            obj = parser.parse(new FileReader(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    private String getJsonStringFromEntity(Object obj){
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





}
