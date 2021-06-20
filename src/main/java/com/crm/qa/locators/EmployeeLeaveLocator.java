package com.crm.qa.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeLeaveLocator {
	
	@FindBy(id="applyleave_txtLeaveType")
	public WebElement leavetype;
	
	@FindBy(xpath="//div[@id=\"applyleave_leaveBalance\"]//a")
	public WebElement leaveblc;
	
	@FindBy(id="applyleave_txtFromDate")
	public WebElement fromdt;
	
	@FindBy(id="applyleave_txtToDate")
	public WebElement todt;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	public WebElement monthdrp;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	public WebElement yeardrp;
	
	@FindBy(id="applyBtn")
	public WebElement applybtn;
	
	@FindBy(xpath="//div[@id=\"applyleave_leaveBalance\"]//a")
	public WebElement leaveblnc;
	
	@FindBy(xpath="//div[@class=\"message success fadable\"]")
	public WebElement successmsg;
	
	"Successfully Submitted"
	
}
