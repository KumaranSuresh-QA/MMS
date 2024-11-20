package org.Testcases;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private Workbook workbook;

    // Method to load the Excel file
    public void setExcelFile(String excelFilePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(excelFilePath)) {
            workbook = new XSSFWorkbook(fis);
        }
    }

    // Method to retrieve all data from all sheets
    public Map<String, List<Map<String, String>>> getAllData(String excelFilePath) throws IOException {
        setExcelFile(excelFilePath);
        Map<String, List<Map<String, String>>> allData = new HashMap<>();

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet sheet = workbook.getSheetAt(i);
            String sheetName = sheet.getSheetName();
            List<Map<String, String>> sheetData = new ArrayList<>();

            // Get header row
            Row headerRow = sheet.getRow(0);
            if (headerRow == null) continue; // Skip empty sheets

            for (int j = 1; j <= sheet.getLastRowNum(); j++) { // Start from 1 to skip header
                Row row = sheet.getRow(j);
                if (row == null || isRowEmpty(row)) continue; // Skip empty rows
                Map<String, String> rowData = new HashMap<>();

                for (int k = 0; k < headerRow.getPhysicalNumberOfCells(); k++) {
                    Cell cell = row.getCell(k);
                    String header = getCellValue(headerRow.getCell(k)); // Get the header cell value
                    String value = getCellValue(cell); // Get the cell value
                    rowData.put(header, value);
                }
                sheetData.add(rowData);
            }
            allData.put(sheetName, sheetData);
        }

        return allData;
    }

    // Helper method to check if a row is empty
    private boolean isRowEmpty(Row row) {
        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            Cell cell = row.getCell(c);
            if (cell != null && cell.getCellType() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }

    // Helper method to get cell value as string
    private String getCellValue(Cell cell) {
        if (cell == null) {
            return ""; // Return empty string if the cell is null
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return cell.getNumericCellValue() % 1 == 0 ? String.valueOf((int) cell.getNumericCellValue()) : String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
            default:
                return ""; // Return empty string if cell is blank or unrecognized
        }
    }

    // Close the workbook to release resources
    public void close() throws IOException {
        if (workbook != null) {
            workbook.close();
            workbook = null;
        }
    }
}



//import java.io.File;
//
//
//
//public class ExcelUtils {
//    private Workbook workbook;
//
//    // Method to load the Excel file dynamically from the folder
//    public void setExcelFile(String folderPath) throws IOException {
//        File folder = new File(folderPath);
//        File[] files = folder.listFiles((dir, name) -> name.endsWith(".xlsx"));
//
//        if (files != null && files.length > 0) {
//            String excelFilePath = files[0].getAbsolutePath(); // Use the first .xlsx file found in the folder
//            System.out.println("Using Excel file: " + excelFilePath);
//
//            try (FileInputStream fis = new FileInputStream(excelFilePath)) {
//                workbook = new XSSFWorkbook(fis);
//            }
//        } else {
//            throw new IOException("No Excel file found in the specified directory: " + folderPath);
//            
//          
//        }
//        System.out.println("+++++++++++++++++++++++++++++++++++++"+ folderPath);
//    }
//
//    // Method to retrieve all data from all sheets
//    public Map<String, List<Map<String, String>>> getAllData(String folderPath) throws IOException {
//        setExcelFile(folderPath);
//        Map<String, List<Map<String, String>>> allData = new HashMap<>();
//
//        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
//            Sheet sheet = workbook.getSheetAt(i);
//            String sheetName = sheet.getSheetName();
//            List<Map<String, String>> sheetData = new ArrayList<>();
//
//            // Get header row
//            Row headerRow = sheet.getRow(0);
//            if (headerRow == null) continue; // Skip empty sheets
//
//            for (int j = 1; j <= sheet.getLastRowNum(); j++) { // Start from 1 to skip header
//                Row row = sheet.getRow(j);
//                if (row == null || isRowEmpty(row)) continue; // Skip empty rows
//                Map<String, String> rowData = new HashMap<>();
//
//                for (int k = 0; k < headerRow.getPhysicalNumberOfCells(); k++) {
//                    Cell cell = row.getCell(k);
//                    String header = headerRow.getCell(k).getStringCellValue();
//                    String value = getCellValue(cell);
//                    rowData.put(header, value);
//                }
//                sheetData.add(rowData);
//            }
//            allData.put(sheetName, sheetData);
//        }
//
//        return allData;
//    }
//
//    // Helper method to check if a row is empty
//    private boolean isRowEmpty(Row row) {
//        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
//            Cell cell = row.getCell(c);
//            if (cell != null && cell.getCellType() != CellType.BLANK) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    // Helper method to get cell value as string
//    private String getCellValue(Cell cell) {
//        if (cell == null) {
//            return "";
//        }
//        switch (cell.getCellType()) {
//            case STRING:
//                return cell.getStringCellValue();
//            case NUMERIC:
//                return cell.getNumericCellValue() % 1 == 0 ? String.valueOf((int) cell.getNumericCellValue()) : String.valueOf(cell.getNumericCellValue());
//            case BOOLEAN:
//                return String.valueOf(cell.getBooleanCellValue());
//            case FORMULA:
//                return cell.getCellFormula();
//            case BLANK:
//            default:
//                return "";
//        }
//    }
//
//    // Close the workbook to release resources
//    public void close() throws IOException {
//        if (workbook != null) {
//            workbook.close();
//            workbook = null;
//        }
//    }
//}



