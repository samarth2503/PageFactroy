package com.crm.qa.actions;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Base.BasePage;
import com.crm.qa.locators.NewCustomerLocator;

public class NewCustomer extends BasePage {
	
	public NewCustomerLocator ncl;
	public NewCustomer() throws IOException {
		super();
		ncl = new NewCustomerLocator();
		PageFactory.initElements(driver, ncl);
		// TODO Auto-generated constructor stub
	}

	
	
	public void addCustomer(String name,String address,String city,String state,String pinno,String telephoneno,String emailid,String dob)
	{
		ncl.custName.sendKeys(name);
		
		ncl.custdob.sendKeys(dob);
		
		ncl.custaddress.sendKeys(address);
		
		ncl.custcity.sendKeys(city);
		
		ncl.custstate.sendKeys(state);
		
		ncl.custpincode.sendKeys(pinno);
		
		ncl.custtelenum.sendKeys(telephoneno);
		
		ncl.custemail.sendKeys(emailid);
		
		ncl.submit.click();
		
	}
	
	public NewCustomer navigateTo() throws IOException
	{
		return hp.newCustomer();
	}
	
	
	

}
