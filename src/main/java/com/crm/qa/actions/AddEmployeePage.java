package com.crm.qa.actions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Base.BasePage;
import com.crm.qa.locators.AddEmployeeLocator;

public class AddEmployeePage extends BasePage{
	
	public AddEmployeeLocator el;

	public AddEmployeePage() throws IOException {
		super();
		el = new AddEmployeeLocator();
		PageFactory.initElements(driver, el);
	}
	
	public void addEmployee(String first,String last)
	{
		el.firstname.sendKeys(first);
		
		el.lastname.sendKeys(last);
		
		scrolldown(el.savebtn);
		
		el.savebtn.click();
	}
	
	public void personalDetails(String gender,String country,String status,String DOB,String bloodgrp) throws InterruptedException
	{
		clickObj(el.editpd);
		
		if(gender.equals("Male"))
		{
			clickObj(el.male);
		}
		else
		{
			clickObj(el.female);
		}
		
		selectFromDropdown(el.Nationality,country);
		
		selectFromDropdown(el.maritalstatus,status);
		
		enterTextJS(driver,DOB,el.dob);
		
		clickObj(el.savepd);
		
		Thread.sleep(1000);
		
		clickObj(el.editCustom);
		
		selectFromDropdown(el.bloodgrp,bloodgrp);
		
		clickObj(el.savecntbtn);
		
		el.successmsg.getText();
	}
	
	public void addContactDetais(String address1,String city,String state,String Country,String mobileno)
	{
		clickObj(el.editpd);
		
		InsertText(el.address1,address1);
		
		InsertText(el.city,city);
		
		InsertText(el.state,state);
		
		InsertText(el.Country,Country);
		
		InsertText(el.Mobileno,mobileno);
		
		clickObj(el.savecntbtn);
	}
	
	public void addJob(String jobtitle,String jobstatus,String jobunit,String startmonth,String startyear,String endmonth,String endyear)
	{
		clickObj(el.editpd);
		
		selectFromDropdown(el.jobtitle,jobtitle);
		
		selectFromDropdown(el.jobStatus,jobstatus);
		
		selectFromDropdown(el.jobunit,jobunit);
		
		clickObj(el.startdatefeild);
		
		selectFromDropdown(el.monthdrp,startmonth);
		
		selectFromDropdown(el.yeardrp,startyear);
		
		clickObj(el.enddatefeild);
		
		selectFromDropdown(el.monthdrp,endmonth);
		
		selectFromDropdown(el.yeardrp,endyear);
		
		clickObj(el.savecntbtn);
	}
	
	public void addMemberShip(String membership,String subAmt,String Currency,String CommDate,String RenewalDate)
	{
		selectFromDropdown(el.Memebership,membership);
		
		InsertText(el.SubsAmt,subAmt);
		
		selectFromDropdown(el.Currency,Currency);
		
		String[] Comm = CommDate.split("-");
		
		String[] Renew = RenewalDate.split("-");
		
		clickObj(el.CommenceDt);
		
		selectFromDropdown(el.monthdrp,Comm[1]);
		
		selectFromDropdown(el.yeardrp,Comm[2]);
		
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td//a[contains(text(),'"+Comm[0]+"')]"));
		
		clickObj(el.RenewalDt);
		
		selectFromDropdown(el.monthdrp,Renew[1]);
		
		selectFromDropdown(el.yeardrp,Renew[2]);
		
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td//a[contains(text(),'"+Renew[0]+"')]"));
	}
	

}
