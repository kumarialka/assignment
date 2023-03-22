package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesInit {
	public Properties propinit() 
	{
		Properties prop = null;
		try {
			prop=new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//project.properties");
			prop.load(fis);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

}
