package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Page Factory or OR:
	@FindBy(xpath = "//td[contains(text(), 'User: PARSHVA ALKESHKUMAR PATEL')]")
	WebElement UserNameLable;
	
	@FindBy(xpath = "//a[contains(text(), 'Contacts')]")
	WebElement ContactsLink;
	
	@FindBy(xpath = "//a[contains(text(), 'New Contact')]")
	WebElement NewContactsLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Tasks')]")
	WebElement TasksLink;
	
	
	//Initializing the Page Objects:
		public HomePage()  {
			
		    PageFactory.initElements(driver, this);	
			}
		
	//Action
		
		public String VerifyHomePageTitle() {
			return driver.getTitle();
		}
		public ContactsPage ClickOnContactsLink() {
			ContactsLink.click();
			return new ContactsPage();
		}
		public DealsPage ClickOnDealsLink() {
			DealsLink.click();
			return new DealsPage();
		}
		public TasksPage ClickOnTasksLink() {
			TasksLink.click();
			return new TasksPage();
		}
		public boolean VerifyCorrectUserName() {
			return UserNameLable.isDisplayed();
		}
		public void clickonnewContactList() {
			Actions action = new Actions(driver);
			action.moveToElement(ContactsLink).build().perform();
			NewContactsLink.click();
	
		}



}
