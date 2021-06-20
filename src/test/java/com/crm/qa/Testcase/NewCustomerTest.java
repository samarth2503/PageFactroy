package com.crm.qa.Testcase;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Base.BasePage;
import com.crm.qa.Testdata.DatProviderUtil;
import com.crm.qa.actions.Homepage;
import com.crm.qa.actions.NewCustomer;

public class NewCustomerTest extends BasePage{

	public NewCustomer nc;
	public Homepage hp;
	
	public NewCustomerTest() throws IOException {
		super();
		Initalize();
		hp = lp.Login();
	}
	
	@BeforeMethod()
	public void beforeMethod() throws IOException
	{
		nc=hp.newCustomer();
	}
	
	@Test(dataProviderClass=DatProviderUtil.class,dataProvider="getData")
	public void addCustomerTest(Hashtable<String,String> h)
	{
		log.start("addCustomerTest");
		nc.addCustomer(h.get("Name"), h.get("Address"), h.get("City"), h.get("State"), h.get("Pincode"), h.get("Telephoneno"), h.get("Emailid"), h.get("dob"));
		Assert.assertEquals("Customer Registered Successfully !!!", driver.findElement(By.xpath("//p[contains(text(),\"Customer\")]")).getText());
		log.end();
		
	}
	
	

}
