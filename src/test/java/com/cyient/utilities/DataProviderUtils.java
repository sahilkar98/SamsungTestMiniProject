package com.cyient.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {
	
		
	@DataProvider
	public Object[][] inValidCredentialData() {
		Object[][] main = new Object[2][3];
		main[0][0] = "123";
		main[0][1] = "45";
		main[0][2] = "Incorrect ID or password.";
		

		main[1][0] = "678";
		main[1][1] = "90";
		main[1][2] = "Incorrect ID or password.";
		

		return main;

	}
	
	@DataProvider
	public Object[][] inValidCredentialExcelData() throws IOException {

		Object[][] main = ExcelUtils.sheetIntoObjectArray("src/test/resources/testData/SamsungTest.xlsx",
				"inValidCredentialData");
		return main;
	}
}
