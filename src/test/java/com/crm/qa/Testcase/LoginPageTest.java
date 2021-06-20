package com.crm.qa.Testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.qa.Base.BasePage;
import com.crm.qa.actions.LoginPage;

public class LoginPageTest extends BasePage{

	public LoginPage lp;
	public LoginPageTest() throws IOException {
		super();
		Initalize();
		lp= new LoginPage();
		// TODO Auto-generated constructor stub
	}
	
	@Test(priority=1)
	public void logoTest()
	{
		boolean flag = lp.isLogoDisplayed();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=4)
	public void loginTest() throws IOException
	{
		lp.Login();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@Test(priority=3)
	public void emptyPwdTest()
	{
		String errormsg = lp.emptyPassword();
		Assert.assertEquals(errormsg, "Password cannot be empty");
		
	}
	
	@Test(priority=2)
	public void emptyUserTest()
	{
		String errormsg = lp.emptyUsername();
		Assert.assertEquals(errormsg, "Username cannot be empty");
		
	}
	
	

}
