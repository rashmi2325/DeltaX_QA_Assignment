package com.deltax.testcases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.deltax.lib.ValidateLoginPage;
import com.deltax.po.LoginPagePO;
import com.deltax.utilities.ExcelReader;

/**
 * 
 * @author Rashmi Kumari This is the test class which will execute the test
 *         cases added in testData file
 *
 */
public class LoginPageTest {

	public WebDriver driver;
	public String testDataFile = System.getProperty("user.dir") + File.separator + "TestData" + File.separator
			+ "LoginPageTestData.xlsx";

	/**
	 * Starts the Browser session before every test execution starts
	 * 
	 * @throws Exception
	 */
	@BeforeMethod
	public void startBrowserSession() throws Exception {
		try {
			System.out.println("Start The Browser Session before test execution");

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator
					+ "chromedriver_win32" + File.separator + "chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);

			driver.get("http://adjiva.com/qa-test/");

		} catch (Exception ex) {
			System.out.println("error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	/**
	 * To run testScenarios based on input from dataProvider
	 * 
	 * @param testScenario
	 * @param firstName
	 * @param lastName
	 * @param dept
	 * @param userName
	 * @param password
	 * @param confirmPassword
	 * @param email
	 * @param contact
	 * @param expectedResult
	 * @throws Exception
	 */
	@Test(dataProvider = "LoginTestData")
	public void runLoginTests(Object testScenario, Object firstName, Object lastName, Object dept, Object userName,
			Object password, Object confirmPassword, Object email, Object contact, Object expectedResult)
			throws Exception {

		System.out.println("******************************************");
		System.out.println("Executing TestCase : " + testScenario.toString());
		ValidateLoginPage validateLoginPage = new ValidateLoginPage();
		LoginPagePO loginPagePO = new LoginPagePO(driver);
		loginPagePO.setLoginPageValues(testScenario, firstName, lastName, dept, userName, password, confirmPassword,
				email, contact, expectedResult);
		validateLoginPage.validateTests(loginPagePO, testScenario.toString(), expectedResult.toString());

	}

	/**
	 * To get the data in dataProvider from excel testdata file
	 * 
	 * @return
	 * @throws Exception
	 */
	@DataProvider
	public Object[][] LoginTestData() throws Exception {
		Object[][] testObjArray = new ExcelReader().readTestDataFromExcel(testDataFile, "Sheet1");
		return (testObjArray);

	}

	/**
	 * This will close the browser session after every test case execution is
	 * completed
	 */
	@AfterMethod
	public void closeBrowserSession() {
		System.out.println("Closing The Browser Session after test execution");
		driver.quit();

	}

}
