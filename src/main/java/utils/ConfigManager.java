package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static final Properties PROPERTIES= new Properties();

    static{
        try(InputStream input= ConfigManager.class.getClassLoader().getResourceAsStream("config.properties")){

            if(input==null)
            {
                throw new RuntimeException("config.properties not found in classpath");
            }

            PROPERTIES.load(input);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Failed to load config.properties",e);
        }
    }

    public static String get(String key)
    {
        String value=PROPERTIES.getProperty(key);
        if(value==null || value.isEmpty())
        {
            throw new RuntimeException("Property "+key+" is missing in config.properties file");
        }
        return value.trim();
    }

    public static String getBaseUrl() {
        return get("baseURL");
    }

    public static String getBearerToken() {
        return get("bearertoken");
    }

    public static String getUserName() {
        return get("username");
    }
}
