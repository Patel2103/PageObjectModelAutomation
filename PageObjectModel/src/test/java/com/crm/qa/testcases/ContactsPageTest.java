package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	
	String sheetName = "Contacts";
	
	public ContactsPageTest() {
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
		testUtil.switchToFrame();
		contactsPage = homePage.ClickOnContactsLink();		
	}
	
	@Test(priority=1)
	public void verifyContactsLable() {
		Assert.assertTrue(contactsPage.verifyContactsLable(), "Contacts Lable is missing on the page");
		
	}
	@Test(priority=2)
	public void selectSingleContactsTest() {
		contactsPage.selectContactsByName("virat kohali");
	}
	@Test(priority=3)
	public void selectMultipleContactsTest() {
		contactsPage.selectContactsByName("virat kohali");
		contactsPage.selectContactsByName("Sachin Tendulkar");
		contactsPage.selectContactsByName("rohit sharma");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[] [] = TestUtil.getTestData(sheetName);
		return data;
		}
	
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String Title, String FirstName, String LastName, String Company) {
		homePage.clickonnewContactList();
		//contactsPage.createNewContact("Mr.", "Mahendra Singh", "Dhoni", "CSK");
		contactsPage.createNewContact(Title, FirstName, LastName, Company);
	}
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
