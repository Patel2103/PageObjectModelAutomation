package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath = "//td[contains(text(), 'Contacts')]")
	WebElement ContactsLable;
	
	@FindBy(id = "first_name")
	WebElement FirstName;
	
	@FindBy(id = "surname")
	WebElement LastName;
	
	@FindBy(name = "client_lookup")
	WebElement Company;
	
	@FindBy(xpath = "//input[@type = 'submit' and @value = 'Save']")
	WebElement SaveButton;
	
	//Initializing the Page Objects:
			public ContactsPage()  {
				
			    PageFactory.initElements(driver, this);	
				}
			
	public boolean verifyContactsLable() {
		return ContactsLable.isDisplayed();
	}
	
	public void selectContactsByName(String Name) {
		driver.findElement(By.xpath("//a[text()='"+Name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	
	}
	public void createNewContact(String Title, String FTName, String LTName, String Comp) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(Title);
		
		FirstName.sendKeys(FTName);
		LastName.sendKeys(LTName);
		Company.sendKeys(Comp);
		SaveButton.click();

	}

			
			
	


}
