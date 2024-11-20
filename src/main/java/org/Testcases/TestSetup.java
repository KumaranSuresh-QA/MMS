package org.Testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.BeforeClass;

public class TestSetup {
    
	@BeforeClass // This will run once before all tests
    public static void setUp() throws InvalidFormatException, IOException {
//        ExcelDataCache cache = ExcelDataCache.getInstance();
//        System.out.println("Setting up before all tests...");
//        cache.loadData("C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Excel.xlsx"); // Load data only once
    }
	
}
