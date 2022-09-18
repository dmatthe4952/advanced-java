package model;

import java.util.Properties;

import application.App;

public class Profile {
	public static Properties getProperties(String name) {
		Properties props = new Properties();
		String env = System.getProperty("env");
		if (env == null) {
			env = "dev";
		}
		System.out.println("Running config for " + name + " in " + env + " environment");
		String propertiesFile = String.format("/config/%s.%s.properties",name, env);
		try {
			props.load(App.class.getResourceAsStream(propertiesFile));
		} catch (Exception e1) {
			throw new RuntimeException("Cannot load or use property file " + propertiesFile);
		}		
		return props;
	}

}
