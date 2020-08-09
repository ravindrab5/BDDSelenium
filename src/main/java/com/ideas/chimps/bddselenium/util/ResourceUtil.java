package com.ideas.chimps.bddselenium.util;

import java.io.InputStream;
import java.net.URL;

public class ResourceUtil {
    public InputStream getFileAsStream(String fileName) {

        StringBuilder result = new StringBuilder("");

        // Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        return classLoader.getResourceAsStream(fileName);
        //File file = new File(classLoader.getResource(fileName).getFile());
        //return file;
    }

    public URL getFile(String fileName) {

        StringBuilder result = new StringBuilder("");

        // Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();

        //System.out.println(classLoader.getResource(fileName).getFile());
      //  File file = new File(classLoader.getResource(fileName).getFile());
        return classLoader.getResource(fileName);
    }


}
