package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException  {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		testUtil = new TestUtil();
		dealsPage = new DealsPage();
		tasksPage = new TasksPage();
		
		contactsPage = new ContactsPage();
		loginPage.login(prop.getProperty("UserName"), prop.getProperty("Password"));
		
	}
	
	@Test(priority=1)
	public void VerifyHomePageTitle() {
		String HomePageTitle = homePage.VerifyHomePageTitle();
		Assert.assertEquals(HomePageTitle, "CRMPRO", "HomePage Title Not Matched");
	}
	
	@Test(priority=2)
	public void VerifyUserNameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.VerifyCorrectUserName());
	}
	@Test (priority=3)
	public void VerifyContactsLinkTest() {
		testUtil.switchToFrame();
		contactsPage = homePage.ClickOnContactsLink();
		Assert.assertTrue(contactsPage.verifyContactsLable());
	}
	@Test (priority=4)
	public void VerifyDealsLinkTest() {
		testUtil.switchToFrame();
		dealsPage = homePage.ClickOnDealsLink();
	
	}
	@Test(priority=5)
	public void VerifyTasksLinkTest() {
		testUtil.switchToFrame();
		tasksPage = homePage.ClickOnTasksLink();
	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
