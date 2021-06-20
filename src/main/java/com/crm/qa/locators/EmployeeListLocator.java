package com.crm.qa.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeListLocator {
	
	
	@FindBy(className="ac_input inputFormatHint")
	public WebElement employeeName;
	
	@FindBy(id="searchBtn")
	public WebElement searchbtn;
	
	@FindBy(className="inputFormatHint")
	public WebElement EmpId;
	
	@FindBy(id="btnDelete")
	public WebElement deletebtn;
	
	@FindBy(xpath="//div[@class='modal-footer']//input[@id='dialogDeleteBtn']")
	public WebElement Ok;
	
	@FindBy(xpath="//div[@class='message success fadable']")
	public WebElement successmsg;
}
