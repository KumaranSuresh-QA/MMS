package org.Testcases;

	
	import java.io.IOException;
	import java.io.InputStream;
	import java.util.Properties;

	public class Config {
		private static Properties properties = new Properties();

	    static {
	        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
	            if (input != null) {
	                properties.load(input);
	            } else {
	                System.err.println("Sorry, unable to find config.properties");
	            }
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }

	    public static String getProperty(String key) {
	        return properties.getProperty(key);
	    }

	    public static int getWaitTime() {
	        String waitTime = properties.getProperty("DEFAULT_WAIT_TIME");
	        return waitTime != null ? Integer.parseInt(waitTime) : 30;  // default to 30 if not found
	    }
	    
	}