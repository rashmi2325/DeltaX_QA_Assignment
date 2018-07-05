package com.deltax.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * This class reads the test data from excel file and passes on to data provider
 * 
 * @author Rashmi Kumari
 *
 */
public class ExcelReader {

	/**
	 * Reads the testData from excel and stores in array
	 * 
	 * @param FilePath
	 * @param SheetName
	 * @return
	 * @throws Exception
	 */
	public Object[][] readTestDataFromExcel(String FilePath, String SheetName) throws Exception {
		XSSFSheet ExcelWSheet = null;

		XSSFWorkbook ExcelWBook;

		String[][] testDataArr = null;

		try {
			// Access the required test data sheet
			InputStream ExcelFile = new FileInputStream(FilePath);
			System.out.println("Reading data from TestData Excel File :" + FilePath);

			try {
				ExcelWBook = new XSSFWorkbook(ExcelFile);

				ExcelWSheet = ExcelWBook.getSheet(SheetName);

			} catch (Exception e) {

				System.out.println("Exception is : " + e.getMessage());
				e.printStackTrace();
			}
			if (ExcelWSheet != null) {
				System.out.println("***** Reading the " + SheetName + " in excel file " + FilePath + " ******** \n");

				int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();

				int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();

				int ci = 0, cj = 0;
				testDataArr = new String[noOfRows - 1][noOfColumns];

				for (int i = 1; i < noOfRows; i++) {
					for (int j = 0; j < noOfColumns; j++) {
						DataFormatter df = new DataFormatter();

						testDataArr[ci][cj] = df.formatCellValue(ExcelWSheet.getRow(i).getCell(j));
						cj++;
					}
					cj = 0;
					ci++;

				}

			}

			else {
				throw new Exception(" The sheet " + SheetName + " not found in the excel file " + FilePath);
			}

		}

		catch (FileNotFoundException e) {

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		catch (IOException e) {

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		return (testDataArr);

	}

}