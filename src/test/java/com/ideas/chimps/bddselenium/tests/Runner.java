package com.ideas.chimps.bddselenium.tests;




import com.ideas.chimps.bddselenium.util.ArgumentHandler;
import com.ideas.chimps.bddselenium.util.DynamicTestNG;

import java.util.HashMap;
import java.util.Map;

public class Runner {
    public static void main(String args[]) throws Throwable {
        ArgumentHandler argumentHandler=new ArgumentHandler(args);

        DynamicTestNG dynamicTestNG= new DynamicTestNG();
        Map<String,String> params=new HashMap<>();
        params.put("env",argumentHandler.getEnvironment());

        params.put("tags",argumentHandler.getTags());
        dynamicTestNG.runTestNGTest(params);
    }


}
