package com.deltax.lib;

import org.testng.Assert;
import org.testng.Reporter;

import com.deltax.po.LoginPagePO;

/**
 * 
 * @author Rashmi Kumari This class is used for validating the response on the
 *         loginPage based on different user inputs.
 */
public class ValidateLoginPage {

	/**
	 * Validate the Test Scenarios by comparing actual result and expected Result.
	 * 
	 * @param loginPagePO
	 * @param testScenario
	 * @param expectedMessage
	 */
	public void validateTests(LoginPagePO loginPagePO, String testScenario, String expectedMessage) {
		try {
			String actualMessage = "";
			System.out.println("Expected message for testScenario  " + testScenario + " is: " + expectedMessage);
//Based on the test scenario we will be getting values and then compare
			switch (testScenario) {

			case "TC_LoginWithAllValidParams":

				actualMessage = loginPagePO.loginPageElement.driver
						.findElement(loginPagePO.loginPageElement.successLogin).getText();
				break;

			case "TC_LoginWithAllRequiredParams":
				actualMessage = loginPagePO.loginPageElement.driver
						.findElement(loginPagePO.loginPageElement.successLogin).getText();
				break;

			case "TC_LoginWithFirstnameEmpty":

				actualMessage = loginPagePO.loginPageElement.driver
						.findElement(loginPagePO.loginPageElement.firstNameEmptyMessage).getText();
				break;

			case "TC_LoginWithFirstnameInvalid":

				actualMessage = loginPagePO.loginPageElement.driver
						.findElement(loginPagePO.loginPageElement.firstNameInvalidValueMessage).getText();
				break;

			case "TC_LoginWithLastnameEmpty":

				actualMessage = loginPagePO.loginPageElement.driver
						.findElement(loginPagePO.loginPageElement.lastNameEmptyMessage).getText();

				break;

			case "TC_LoginWithLastnameInvalid":

				actualMessage = loginPagePO.loginPageElement.driver
						.findElement(loginPagePO.loginPageElement.lastNameInvalidValueMessage).getText();

				break;

			case "TC_LoginWithUsernameEmpty":

				actualMessage = loginPagePO.loginPageElement.driver
						.findElement(loginPagePO.loginPageElement.userNameEmptyMessage).getText();

				break;

			case "TC_LoginWithUsernameInvalid":

				actualMessage = loginPagePO.loginPageElement.driver
						.findElement(loginPagePO.loginPageElement.userNameInvalidValueMessage).getText();

				break;
			case "TC_LoginWithPasswordEmpty":

				actualMessage = loginPagePO.loginPageElement.driver
						.findElement(loginPagePO.loginPageElement.passwordEmptyMessage).getText();

				break;

			case "TC_LoginWithPasswordInvalid":

				actualMessage = loginPagePO.loginPageElement.driver
						.findElement(loginPagePO.loginPageElement.passwordInvalidValueMessage).getText();

				break;

			case "TC_LoginWithConfirmPasswordEmpty":

				actualMessage = loginPagePO.loginPageElement.driver
						.findElement(loginPagePO.loginPageElement.confirmPasswordEmptyMessage).getText();

				break;

			case "TC_LoginWithConfirmPasswordInvalid":

				actualMessage = loginPagePO.loginPageElement.driver
						.findElement(loginPagePO.loginPageElement.confirmPasswordInvalidValueMessage).getText();

				break;
			case "TC_LoginWithEmailEmpty":

				actualMessage = loginPagePO.loginPageElement.driver
						.findElement(loginPagePO.loginPageElement.emailEmptyMessage).getText();

				break;

			case "TC_LoginWithEmailInvalid":

				actualMessage = loginPagePO.loginPageElement.driver
						.findElement(loginPagePO.loginPageElement.emailInvalidValueMessage).getText();

				break;

			case "TC_LoginWithContactInvalid":

				actualMessage = loginPagePO.loginPageElement.driver
						.findElement(loginPagePO.loginPageElement.contactInvalidValueMessage).getText();

				break;

			default:
				System.out.println("No scenarios given");
			}

			System.out.println("Actual message received for testScenario  " + testScenario + " is: " + actualMessage);

			if (actualMessage.equals(expectedMessage)) {
				Assert.assertTrue(true, "Successfully validated the scenario " + testScenario);
				Reporter.log("Successfully validated the scenario " + testScenario, true);

			} else {
				Assert.fail("Failed to validated the scenario " + testScenario);
				Reporter.log("Failed to validated the scenario " + testScenario, true);

			}

		} catch (Exception ex) {
			System.out.println("Excetion occured while validating the test scenario ");
			ex.printStackTrace();
		}
	}
}
