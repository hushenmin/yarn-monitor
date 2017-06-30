package org.monitor.yarn.conf;

import java.io.*;
import java.util.Properties;

/**
 * Created by Administrator on 2017/6/13.
 */
public class PropertyFetcher {
    private  static  Properties pro = new Properties();
    static {
        try {
        InputStream in =PropertyFetcher.class
                .getClassLoader()
                .getResourceAsStream("yarncluster.properties");
            //System.out.println(in);
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("yarncluster.properties problem occurs");
        }
    }

    public  static  String  getProperty(String key){
        return  pro.getProperty(key);
    }

    public  static  Boolean getBoolean(String key){
        String value = pro.getProperty(key);
        try {
            return Boolean.valueOf(value);
        }catch (Exception e){
            e.printStackTrace();
        }
       return false;
    }

    public  static  Long getLong(String key){
        String value = pro.getProperty(key);
        try {
          return  Long.valueOf(value);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0L;
    }
    public static  int getInt(String key){
        String value = pro.getProperty(key);
            try {
                return Integer.valueOf(value);
            }catch (Exception e){
                e.printStackTrace();
            }
           return 0;
    }

}
