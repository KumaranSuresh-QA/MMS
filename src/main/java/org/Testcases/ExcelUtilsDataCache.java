package org.Testcases;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

//public class ExcelUtilsDataCache {
//
//	private generateFaker fakerUtil = new generateFaker();
//	private Set<String> existingBankNames = new HashSet<>();
//
//	private static ExcelUtilsDataCache instance;
//	private Map<String, List<Map<String, String>>> cachedData;
//
//	// Private constructor to implement Singleton pattern
//	private ExcelUtilsDataCache() {
//		cachedData = new HashMap<>(); // Initialize the cache map
//	}
//
//	// Get the single instance of this class (Singleton pattern)
//	public static ExcelUtilsDataCache getInstance() {
//		if (instance == null) {
//			instance = new ExcelUtilsDataCache();
//		}
//		return instance;
//	}
//
//	// Method to load data from Excel into the cache (only once)
//	public void loadData(String excelPath) throws IOException {
//		if (cachedData.isEmpty()) { // Load data only if cache is empty
//			ExcelUtils utils = new ExcelUtils();
//			cachedData = utils.getAllData(excelPath);
//
//			if (cachedData == null || cachedData.isEmpty()) {
//				System.out.println("Error: Failed to load data from Excel. Cache is empty.");
//			} else {
//				System.out.println("Data loaded successfully into cache.");
//				randomvaluegenerate();
//			}
//		} else {
//			System.out.println("Data already loaded in cache, skipping reload.");
//		}
//	}
//
//	// Retrieve cached data for a specific sheet
//	public List<Map<String, String>> getCachedData(String sheetName) {
//		List<Map<String, String>> sheetData = cachedData.get(sheetName);
//		if (sheetData == null) {
//			System.out.println("Warning: No data found for sheet '" + sheetName + "'. Returning empty list.");
//			return Collections.emptyList(); // Return empty list if sheet data is not found
//		}
//		return sheetData;
//	}
//
//	// Method to update cached data for a specific sheet
//	public void setCachedData(String sheetName, List<Map<String, String>> data) {
//		if (data != null) {
//			cachedData.put(sheetName, data); // Update the cache with new data for the given sheet
//			System.out.println("Data updated for sheet: " + sheetName);
//		} else {
//			System.out.println("Warning: Attempted to update sheet '" + sheetName + "' with null data.");
//		}
//	}
//
//	// Example method for generating random values (implement this based on your
//	// requirements)
//	public void randomvaluegenerate() {
//		Map<String, List<Map<String, String>>> allSheetData = cachedData;
//		generateFaker faker = new generateFaker();
//		for (String sheetName : allSheetData.keySet()) { // Loop through each sheet
//			List<Map<String, String>> sheetData = allSheetData.get(sheetName); // Get data for the current sheet
//			System.out.println("Processing sheet: " + sheetName); // Optional: log the current sheet name
//			for (Map<String, String> rowData : sheetData) { // Loop through each row in the sheet
//				for (String key : rowData.keySet()) {
//					String value = rowData.get(key);
//
//					// Check for placeholders and replace with generated values
//					if ("Random.Bank".equalsIgnoreCase(value)) {
//						value = fakerUtil.generateValidBankName(fakerUtil.faker, existingBankNames);
//					} else if ("Random.Address".equalsIgnoreCase(value)) {
//						value = fakerUtil.generateRandomAddress(fakerUtil.faker);
//					} else if ("Random.Gst".equalsIgnoreCase(value)) {
//						value = fakerUtil.generateValidGST();
//					} else if ("Random.Pan".equalsIgnoreCase(value)) {
//						value = fakerUtil.generateValidPAN();
//					}
//					// Update the rowData with the generated value
//					rowData.put(key, value);
//				}
//
//			}
//
//			setCachedData(sheetName, sheetData);
//		}
//
//	}
//
//	public Map<String, List<Map<String, String>>> getData() {
//		return cachedData;
//
//	}
//
//}

public class ExcelUtilsDataCache {

	private generateFaker fakerUtil = new generateFaker();
	private Set<String> existingBankNames = new HashSet<>();
	private Set<String> existingAadhaarNumbers = new HashSet<>();
	private Set<String> existingUniqueReferenceNumber = new HashSet<>();

	private static ExcelUtilsDataCache instance;
	private Map<String, List<Map<String, String>>> cachedData;
	// Private constructor to implement Singleton pattern
	private ExcelUtilsDataCache() {
		cachedData = new HashMap<>(); // Initialize the map
	}

	// Get the single instance of this class
	public static ExcelUtilsDataCache getInstance() {
		if (instance == null) {
			instance = new ExcelUtilsDataCache();
		}
		return instance;
	}

	// Method to load data from Excel into the cache (only once)
	public void loadData(String excelPath) throws InvalidFormatException, IOException {
		if (cachedData.isEmpty()) { // Check if cache is empty before loading data
			ExcelUtils utils = new ExcelUtils(); // Assuming ExcelUtils is a utility class for reading Excel data
			cachedData = utils.getAllData(excelPath); // Load all sheets at once into the cache
			System.out.println(
					"===============excelPathexcelPathexcelPathexcelPath===============================" + excelPath);
			randomvaluegenerate();
		}
	}

	// Retrieve cached data for a specific sheet
	public List<Map<String, String>> getCachedData(String sheetName) {
		return cachedData.get(sheetName); // Return data for the requested sheet
	}

	// Method to update cached data for a specific sheet
	public void setCachedData(String sheetName, List<Map<String, String>> data) {
		cachedData.put(sheetName, data); // Update the cache with new data for the given sheet
	}

	public void randomvaluegenerate() {
		Map<String, List<Map<String, String>>> allSheetData = cachedData;
		new generateFaker();
		for (String sheetName : allSheetData.keySet()) { // Loop through each sheet
			List<Map<String, String>> sheetData = allSheetData.get(sheetName); // Get data for the current sheet
			System.out.println("Processing sheet: " + sheetName); // Optional: log the current sheet name
			for (Map<String, String> rowData : sheetData) { // Loop through each row in the sheet
				for (String key : rowData.keySet()) {
					String value = rowData.get(key);

					// Check for placeholders and replace with generated values
					if ("Random.Bank".equalsIgnoreCase(value)) {
						value = fakerUtil.generateValidBankName(fakerUtil.faker, existingBankNames);
					} else if ("Random.Address".equalsIgnoreCase(value)) {
						value = fakerUtil.generateRandomAddress();
					} else if ("Random.Gst".equalsIgnoreCase(value)) {
						value = fakerUtil.generateValidGST();
					} else if ("Random.Pan".equalsIgnoreCase(value)) {
						value = fakerUtil.generateValidPAN();
					} else if ("Random.Name".equalsIgnoreCase(value)) {
						value = fakerUtil.generateRandomName();
					} else if ("Random.Number".equalsIgnoreCase(value)) {
						value = fakerUtil.generateMobileNumber();
					} else if ("Random.Email".equalsIgnoreCase(value)) {
						value = fakerUtil.generateEmail();
					} else if ("Random.AccountNumber".equalsIgnoreCase(value)) {
						value = fakerUtil.generateValidBankAccountNumber();
					} else if ("Random.Code".equalsIgnoreCase(value)) {
						value = fakerUtil.generateValidAggregatorCode();
					} else if ("Random.Aadhaar".equalsIgnoreCase(value)) {
						value = fakerUtil.generateValidAadhaar(fakerUtil.faker, existingAadhaarNumbers);
					} else if ("Random.Passport".equalsIgnoreCase(value)) {
						value = fakerUtil.generateIndianPassportNumber();
					} else if ("Random.UniqueRefNumber".equalsIgnoreCase(value)) {
						value = fakerUtil.generateValidUniqueReferenceNumber(fakerUtil.faker,
								existingUniqueReferenceNumber);
					} else if ("Random.Image".equalsIgnoreCase(value)) {
						value = fakerUtil.generateImage(sheetName);
					}

					// Update the rowData with the generated value
					rowData.put(key, value);
				}

			}

			setCachedData(sheetName, sheetData);
		}

	}

	public Map<String, List<Map<String, String>>> getData() {
		return cachedData;

	}
}
