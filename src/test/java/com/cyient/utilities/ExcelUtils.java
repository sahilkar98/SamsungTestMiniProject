package com.cyient.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static Object[][] sheetIntoObjectArray(String filePath, String sheetName) throws IOException {
		FileInputStream file = new FileInputStream(filePath);

		XSSFWorkbook book = new XSSFWorkbook(file);

		XSSFSheet sheet = book.getSheet(sheetName);

		int rowCount = sheet.getPhysicalNumberOfRows();

		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();

		Object[][] main = new Object[rowCount - 1][cellCount];

		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				XSSFRow row = sheet.getRow(i);
				XSSFCell cell = row.getCell(j);
				DataFormatter format = new DataFormatter();
				String cellValue = format.formatCellValue(cell);

				main[i - 1][j] = cellValue;

			}
		}

		return main;
	}
}
