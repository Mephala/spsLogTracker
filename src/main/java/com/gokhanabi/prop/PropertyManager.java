package com.gokhanabi.prop;

import org.apache.log4j.Logger;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Masraf2 on 12/8/2015.
 */
public class PropertyManager {
    private static PropertyManager ourInstance = new PropertyManager();
    private Logger logger = Logger.getLogger(this.getClass());
    private final Map<String,String> propMap = new HashMap<>();

    public static synchronized PropertyManager getInstance() {
        return ourInstance;
    }

    private PropertyManager() {
        logger.info("Constructing property manager...");
        Properties props = new Properties();
        try {
            props.load(this.getClass().getClassLoader().getResourceAsStream("logTrackerProperties.properties"));
            Enumeration<Object> keys =  props.keys();
            while (keys.hasMoreElements()) {
                Object o =  keys.nextElement();
                String key = (String) o;
                String value = props.getProperty(key) ;
                propMap.put(key,value);
            }
        } catch (Throwable t) {
            logger.fatal("Failed to construct property manager.",t);
            System.exit(-1);
        }
    }

    public String getProperty(String propKey) {
        return propMap.get(propKey);
    }

    public String getTestProperty(String propKey) {
        return propMap.get("test."+propKey);
    }
}
