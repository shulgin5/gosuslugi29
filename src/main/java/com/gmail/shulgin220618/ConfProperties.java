package com.gmail.shulgin220618;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {
    protected static Properties PROPERTIES;

    static{
        try(FileInputStream fileInputStream = new FileInputStream("src/main/resources/conf.properties")){
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static String getProperty(String key){
        return PROPERTIES.getProperty(key);
    }
}
