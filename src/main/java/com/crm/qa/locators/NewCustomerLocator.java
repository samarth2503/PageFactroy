package com.crm.qa.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewCustomerLocator {
	
	@FindBy(xpath="//input[@name='name']")
	public WebElement custName; 
	
	@FindBy(xpath="//input[@name=\"rad1\"]")
	public WebElement custgender; 
	
	@FindBy(xpath="//textarea[@name=\"addr\"]")
	public WebElement custaddress;
	
	@FindBy(xpath="//input[@name='city']")
	public WebElement custcity;
	
	@FindBy(xpath="//input[@name='state']")
	public WebElement custstate;
	
	@FindBy(xpath="//input[@name='pinno']")
	public WebElement custpincode;
	
	@FindBy(xpath="//input[@name='telephoneno']")
	public WebElement custtelenum;
	
	@FindBy(xpath="//input[@name='emailid']")
	public WebElement custemail;
	
	@FindBy(xpath="//input[@name='sub']")
	public WebElement submit;
	
	@FindBy(css="#dob")
	public WebElement custdob;
	
	@FindBy(xpath="//a[contains(text(),\"Continue\")]")
	public WebElement Continue;
	
	@FindBy(xpath="//a[contains(text(),\"Home\")]")
	public WebElement home;

}
