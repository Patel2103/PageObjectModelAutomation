package com.crm.qa.pages;




import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase  {
	

	//Page Factory or OR:
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type = 'submit']")
	WebElement loginbutton;
	
	@FindBy(xpath = "//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement crmLogo;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signupbutton;
	
	@FindBy(xpath= "//a[contains(text(),'Pricing')]")
	WebElement PriceButton;
	
	
	//Initializing the Page Objects:
	public LoginPage()  {
		
	    PageFactory.initElements(driver, this);	
		}
	
	//Action
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	public boolean validateCRMLogo() {
		return crmLogo.isDisplayed();
	}
	public HomePage login(String un, String pwd) throws IOException, InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(5000);
		loginbutton.click();
		
		return new HomePage();
		
		
		
	}
	public boolean validateSignupButton() {
		return signupbutton.isDisplayed();
		
	}
	public boolean validatePriceButtonAndClick()  {
		 return PriceButton.isDisplayed();
		
	}
	public void ClickonPriceButton () {
		PriceButton.click();
	}
	
	
	
}



