package com.ideas.chimps.bddselenium.util;

import com.relevantcodes.extentreports.ExtentReports;
import org.apache.log4j.Logger;

import java.util.Date;

public class ExtentManager {
    static Date date = new Date();
    public static ExtentReports extent;
    public static String filename = "" + "result" + ".html";
    public static String reportPath = "./Results/"+filename;
    private static Logger log;

    public static ExtentReports getInstance(){
        if (extent == null) {
            log=LogInitilizer.getLogger();
            extent = new ExtentReports(reportPath, true);
            log.debug("Initilizing report at - "+reportPath);
            extent.loadConfig(new ResourceUtil().getFile("extent-config.xml"));
        }
        return extent;
    }
}
