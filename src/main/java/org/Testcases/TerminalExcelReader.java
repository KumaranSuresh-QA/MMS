package org.Testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TerminalExcelReader {
	
	private Workbook workbook;
    private Sheet sheet;

    public TerminalExcelReader(String filePath, String sheetName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet(sheetName);
    }

    public Map<String, String> readRowData(int rowIndex) {
        Map<String, String> rowData = new HashMap<>();
        Row headerRow = sheet.getRow(0); // Assumes headers are in the first row (index 0)
        Row dataRow = sheet.getRow(rowIndex);

        if (headerRow != null && dataRow != null) {
            Iterator<Cell> headerCells = headerRow.cellIterator();
            Iterator<Cell> dataCells = dataRow.cellIterator();

            while (headerCells.hasNext() && dataCells.hasNext()) {
                Cell headerCell = headerCells.next();
                Cell dataCell = dataCells.next();
                
                String header = headerCell.getStringCellValue();
                String value = dataCell.toString(); // Reads the cell as a string

                rowData.put(header, value);
            }
        }
        return rowData;
    }

	

}
