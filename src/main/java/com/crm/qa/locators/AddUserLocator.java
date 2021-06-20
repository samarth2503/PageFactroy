package com.crm.qa.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserLocator {
	
	@FindBy(id="btnAdd")
	public WebElement addbtn;
	
	@FindBy(xpath="//select[@id='systemUser_userType']")
	public WebElement usertype;
	
	@FindBy(id="systemUser_employeeName_empName")
	public WebElement empname;
	
	@FindBy(id="systemUser_userName")
	public WebElement username;
	
	@FindBy(xpath="//select[@id='systemUser_status']")
	public WebElement status;
	
	@FindBy(id="systemUser_password")
	public WebElement password;
	
	@FindBy(id="systemUser_confirmPassword")
	public WebElement cnfpwd;
	
	@FindBy(id="btnSave")
	public WebElement Savebtn;
	
	@FindBy(xpath="//table[@id='resultTable']//tbody//tr")
	public WebElement tabledata;
	
	@FindBy(xpath="//div[@id='mainMenu']//b[contains(text(),'Admin')]")
	public WebElement Admin; 
	
	@FindBy(xpath="//div[@id='mainMenu']//a[text()='Job']")
	public WebElement job;
	
	@FindBy(xpath="//div[@id='mainMenu']//a[contains(text(),'Job Titles')")
	public WebElement jobtitle;
	
	@FindBy(id="jobTitle_jobTitle")
	public WebElement jobtlefeild;
	
	

}
