package com.deltax.po;

import org.openqa.selenium.WebDriver;

import com.deltax.pages.LoginPageElement;

/**
 * 
 * @author Rashmi Kumari This class holds methods to pass and extract values to
 *         loginPage Elements
 */
public class LoginPagePO {
	public LoginPageElement loginPageElement;

	public LoginPagePO(WebDriver driver) {
		loginPageElement = new LoginPageElement(driver);
	}

	/**
	 * Set value in firstName Field
	 * 
	 * @param firstName
	 */
	public void typeFirstName(String firstName) {
		loginPageElement.driver.findElement(loginPageElement.firstName).sendKeys(firstName);
	}

	/**
	 * Set value in lastNme Field
	 * 
	 * @param lastName
	 */
	public void typeLastName(String lastName) {
		loginPageElement.driver.findElement(loginPageElement.lastName).sendKeys(lastName);
	}

	/**
	 * Select value in department Field
	 * 
	 * @param dept
	 */
	public void selectDept(String dept) {

		loginPageElement.driver.findElement(loginPageElement.dept).sendKeys(dept);
	}

	/**
	 * Set value in userName Field
	 * 
	 * @param userName
	 */
	public void typeUserName(String userName) {
		loginPageElement.driver.findElement(loginPageElement.username).sendKeys(userName);
	}

	/**
	 * Set value in password Field
	 * 
	 * @param password
	 */
	public void typePassword(String password) {
		loginPageElement.driver.findElement(loginPageElement.password).sendKeys(password);
	}

	/**
	 * Set value in confirmPassword Field
	 * 
	 * @param password
	 */
	public void typeConfirmPassword(String password) {
		loginPageElement.driver.findElement(loginPageElement.confirmPassword).sendKeys(password);
	}

	/**
	 * Set value in Email Field
	 * 
	 * @param email
	 */
	public void typeEmail(String email) {
		loginPageElement.driver.findElement(loginPageElement.email).sendKeys(email);
	}

	/**
	 * Set value in Contact Field
	 * 
	 * @param contact
	 */
	public void typeContact(String contact) {
		loginPageElement.driver.findElement(loginPageElement.contact).sendKeys(contact);
	}

	/**
	 * Click Submit button
	 */
	public void clickSubmit() {
		loginPageElement.driver.findElement(loginPageElement.submit).click();
	}

	/**
	 * To set the values in all the fields of the login page
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
	public void setLoginPageValues(Object testScenario, Object firstName, Object lastName, Object dept, Object userName,
			Object password, Object confirmPassword, Object email, Object contact, Object expectedResult)
			throws Exception {
		typeFirstName(firstName.toString());
		typeLastName(lastName.toString());
		selectDept(dept.toString());
		typeUserName(userName.toString());
		typePassword(password.toString());
		typeConfirmPassword(confirmPassword.toString());
		typeEmail(email.toString());
		typeContact(contact.toString());
		if (testScenario.toString().equals("TC_LoginWithContactInvalid")) {
			System.out.println("Don't Click submit");
		} else {
			clickSubmit();
		}

	}

}
