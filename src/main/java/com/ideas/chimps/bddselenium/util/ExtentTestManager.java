package com.ideas.chimps.bddselenium.util;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExtentTestManager {
    static ExtentReports report = ExtentManager.getInstance();

    static Map<Integer, ExtentTest> map = new HashMap<Integer, ExtentTest>();
    static Set<String> testNames=new HashSet<String>();
    static Set<String> logFailPass=new HashSet<String>();

    public static synchronized ExtentTest startTest(String testName) {
        return startTest(testName, "");
    }

    public static synchronized ExtentTest startTest(String testName, String description) {
        int threadId=(int) Thread.currentThread().getId();

        if(!testNames.contains(testName)){
            testNames.add(testName);
            map.put((int) Thread.currentThread().getId(), report.startTest(testName, description));
        }
        return map.get(threadId);
    }

    public static synchronized ExtentTest getTest() {
        return map.get((int) Thread.currentThread().getId());
    }

    public static synchronized void endTest(String testName) {
        int threadId=(int) Thread.currentThread().getId();
        if(map.get(threadId).getTest().getName().equals(testName)) {
            report.endTest(map.get(threadId));
            report.flush();
        }
    }

    public static synchronized  void logPass(String testName){
        int threadId=(int) Thread.currentThread().getId();
        ExtentTest test=map.get(threadId);
     if(test.getTest().getName().equals(testName)) {
            if(!logFailPass.contains(testName)) {
                map.get(threadId).log(LogStatus.PASS, "Testcase Passed");
                logFailPass.add(testName);
            }
        }
    }

    public static synchronized  void logFail(String testName){
        int threadId=(int) Thread.currentThread().getId();
        ExtentTest test=map.get(threadId);
        if(test.getTest().getName().equals(testName)) {
            if(!logFailPass.contains(testName)) {
                map.get(threadId).log(LogStatus.FAIL, "Testcase Failed");
                logFailPass.add(testName);
            }
        }
    }
}
