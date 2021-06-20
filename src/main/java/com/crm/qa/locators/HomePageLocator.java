package com.crm.qa.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocator {
	
	
	@FindBy(xpath="//div[@id=\"mainMenu\"]//li//a//b[contains(text(),'PIM')]")
	public WebElement PIM;
	
	@FindBy(xpath="//div[@id=\"mainMenu\"]//b[contains(text(),'PIM')]//ul//lia[contains(text(),\"Add Employee\")]")
	public WebElement AddEmployee;
	
	@FindBy(xpath="//div[@id='mainMenu']//b[contains(text(),'Admin')]")
	public WebElement Admin; 
	
	@FindBy(xpath="//div[@id='mainMenu']//a[contains(text(),'User Management')]")
	public WebElement userMang;
	
	@FindBy(xpath="//a[contains(text(),\"Employee List\")]")
	public WebElement empList;
	
	@FindBy(xpath="//ul[@class=\"menusubnav\"]//li//a[contains(text(),\"Delete Account\")]")
	public WebElement deleteacc;
	
	@FindBy(xpath="//ul[@class=\"menusubnav\"]//li//a[contains(text(),\"New Account\")]")
	public WebElement newacc;
	
	@FindBy(xpath="//ul[@class=\"menusubnav\"]//li//a[contains(text(),\"Edit Account\")]")
	public WebElement editacc;
	
	@FindBy(xpath="//div[@id='mainMenu']//b[text()=\"Leave\"]")
	public WebElement Leave;
	
	@FindBy(xpath="//div[@id=\"mainMenu\"]//a[contains(text(),'Apply')]")
	public WebElement Apply;
	
	

}
