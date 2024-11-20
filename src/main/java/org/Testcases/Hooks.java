package org.Testcases;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;


import io.cucumber.java.Before;


public class Hooks {
	SoftAssertions softAssertions = new SoftAssertions();
	
	 WebDriver driver;
	 @Before
	    public void setUp() throws InterruptedException {
		  driver = CustomWebDriverManager.getDriver();
	    }

//	    @After
//	    public void tearDown() {
//	    	
//	    	softAssertions.assertAll();
//	    	CustomWebDriverManager.quitDriver();
//	    	
//	    }
}
