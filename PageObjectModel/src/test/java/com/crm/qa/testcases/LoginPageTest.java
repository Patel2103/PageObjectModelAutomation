package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp()  {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String Title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(Title, "Free CRM - CRM software for customer relationship management, sales, and support.");
	}
	@Test(priority = 2)
	public void CrmLogoImageTest() {
		boolean Logo = loginPage.validateCRMLogo();
		Assert.assertTrue(Logo);
	}
	@Test(priority = 3)
	public void loginTest() throws IOException, InterruptedException {
		homePage = loginPage.login(prop.getProperty("UserName"), prop.getProperty("Password"));
		String HomePageTitle = homePage.VerifyHomePageTitle();
		Assert.assertEquals(HomePageTitle, "CRMPRO");
	
	}
	@Test(priority = 4)
	public void signUpButtonTest() {
		boolean SignUpButton = loginPage.validateSignupButton();
		Assert.assertTrue(SignUpButton);
	}
	
	@Test(priority = 5)
	public void PriceButtonTest() {
		boolean PriceButton = loginPage.validatePriceButtonAndClick();
		Assert.assertTrue(PriceButton);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
