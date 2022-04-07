package com.mystore.utils.ui;

public class SetSelenium {
	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
    public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
    
    public void setSelenium() {
    	
    	System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
    }
}
