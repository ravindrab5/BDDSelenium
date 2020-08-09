package com.ideas.chimps.bddselenium.util;

import lombok.Getter;
import org.apache.commons.cli.*;

@Getter
public class ArgumentHandler {
    private String[] args;
    private String tags;
    private String environment;

    public ArgumentHandler(String[] args){
        this.args=args;
        tags="";
        Options option=new Options();
        option.addOption("env",true,"Set the environment on which it is to be run");
        option.addOption("tags",true,"tags which needs to be run");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd=null;

        try {
            cmd=parser.parse(option,args);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        tags=cmd.getOptionValue("tags");
        tags=tags.replace(","," or ");

        if(tags==null){
            tags="";
        }

        environment=cmd.getOptionValue("env");

        if(environment==null){
            System.exit(0);
        }
    }



}
