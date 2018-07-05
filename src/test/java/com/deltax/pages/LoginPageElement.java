package com.deltax.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Rashmi Kumari This class holds all the LoginPage Elements
 *
 */
public class LoginPageElement {
	public WebDriver driver;
	public By firstName = By.xpath("/html/body/div/form/fieldset/div[1]/div/div/input");
	public By lastName = By.xpath("/html/body/div/form/fieldset/div[2]/div/div/input");
	public By dept = By.xpath("/html/body/div/form/fieldset/div[3]/div/div/select");
	public By username = By.xpath("/html/body/div/form/fieldset/div[4]/div/div/input");
	public By password = By.xpath("/html/body/div/form/fieldset/div[5]/div/div/input");
	public By confirmPassword = By.xpath("/html/body/div/form/fieldset/div[6]/div/div/input");
	public By email = By.xpath("/html/body/div/form/fieldset/div[7]/div/div/input");
	public By contact = By.xpath("/html/body/div/form/fieldset/div[8]/div/div/input");
	public By submit = By.xpath("/html/body/div/form/fieldset/div[10]/div/button");

	public By firstNameInvalidValueMessage = By.xpath("/html/body/div/form/fieldset/div[1]/div/small[1]");
	public By firstNameEmptyMessage = By.xpath("/html/body/div/form/fieldset/div[1]/div/small[2]");

	public By lastNameInvalidValueMessage = By.xpath("/html/body/div/form/fieldset/div[2]/div/small[1]");
	public By lastNameEmptyMessage = By.xpath("/html/body/div/form/fieldset/div[2]/div/small[2]");

	public By userNameInvalidValueMessage = By.xpath("/html/body/div/form/fieldset/div[4]/div/small[1]");
	public By userNameEmptyMessage = By.xpath("/html/body/div/form/fieldset/div[4]/div/small[2]");

	public By passwordInvalidValueMessage = By.xpath("/html/body/div/form/fieldset/div[5]/div/small[1]");
	public By passwordEmptyMessage = By.xpath("/html/body/div/form/fieldset/div[5]/div/small[2]");

	public By confirmPasswordInvalidValueMessage = By.xpath("/html/body/div/form/fieldset/div[6]/div/small[1]");
	public By confirmPasswordEmptyMessage = By.xpath("/html/body/div/form/fieldset/div[6]/div/small[2]");

	public By emailInvalidValueMessage = By.xpath("/html/body/div/form/fieldset/div[7]/div/small[2]");
	public By emailEmptyMessage = By.xpath("/html/body/div/form/fieldset/div[7]/div/small[1]");
	public By contactInvalidValueMessage = By.xpath("/html/body/div/form/fieldset/div[8]/div/small");

	public By successLogin = By.xpath("/html/body/div/form/fieldset/legend/center/h2/b");

	public LoginPageElement(WebDriver driver) {
		this.driver = driver;
	}

}
