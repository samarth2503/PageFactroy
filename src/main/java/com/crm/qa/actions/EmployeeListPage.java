package com.crm.qa.actions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.crm.qa.Base.BasePage;
import com.crm.qa.locators.EmployeeListLocator;

public class EmployeeListPage extends BasePage{
	
	public EmployeeListLocator el;
	
	public EmployeeListPage() throws IOException {
		super();
		this.el = new EmployeeListLocator();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this.el);
	}
	
	public boolean deleteEmployee(String EmpName,String Id)
	{
		InsertText(el.employeeName,EmpName);
		InsertText(el.EmpId,Id);
		clickObj(el.searchbtn);
		driver.findElement(By.xpath("//table[@id='resultTable']//tbody//td//a[contains(text(),'"+Id+"')]//parent::td/preceding-sibling::td//input")).click();
		clickObj(el.deletebtn);
		clickObj(el.Ok);
		return TextToBePresent(el.successmsg,"Successfully Deleted");
	}

}
