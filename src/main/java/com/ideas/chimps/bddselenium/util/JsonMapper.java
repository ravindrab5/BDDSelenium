package com.ideas.chimps.bddselenium.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Component
public class JsonMapper {


    private ObjectMapper objectMapper;

    public JsonMapper(){
        objectMapper=new ObjectMapper();
    }

    public Object getData(String json,Class cls){
        String filepath =json;
                //this.getClass().getClassLoader().getResource(json).getFile();
        byte[] bytes = null;
        try {
            bytes = json.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Object obj = null;
        try {
            obj = objectMapper.readValue(bytes, cls);
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch(Exception e) {
            // Need to write Exception
            e.printStackTrace();
        }
        return obj;
    }
}
