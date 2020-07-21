package com.dyt.ors.Config;

import org.openqa.selenium.WebDriver;

public class Config {
		
		public static WebDriver driver = null;
		public static final String URL = "http://13.233.50.231:8080/ORS_SIT/";
		public static String Browser = "chrome";
		public static String CurrentTestCaseName = "";
		public static String TestDataPath = "F:\\vijju\\project_ORS\\TestData\\OrbitScience_data.xlsx";
		public static String ResultsPath = System.getProperty("user.dir")+"//Results//";
	
	}


