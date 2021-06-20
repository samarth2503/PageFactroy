package com.crm.qa.actions;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Base.BasePage;

public class LoginPage extends BasePage{
	
	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//input[@name='txtUsername']")
	public WebElement username;
	
	@FindBy(xpath="//input[@name='txtPassword']")
	public WebElement password;
	
	@FindBy(xpath="//input[@id='btnLogin']")
	public WebElement loginbtn;
	
	@FindBy(xpath="//div[contains(@id,'divLogo')]//img")
	public WebElement logo;
	
	@FindBy(xpath="//span[contains(@id,\"spanMessage\")]")
	public WebElement usertext;
	
	@FindBy(xpath="//span[contains(@id,\"spanMessage\")]")
	public WebElement pwdtext;
	
	public Homepage Login() throws IOException
	{
		username.sendKeys(p.getProperty("username"));
		
		password.sendKeys(p.getProperty("password"));
		
		loginbtn.click();
		
		return new Homepage();
	}
	
	public boolean isLogoDisplayed()
	{
		boolean flag=logo.isDisplayed();
		return flag;
	}
	
	public String emptyUsername()
	{
		username.sendKeys("");
		
		password.sendKeys(p.getProperty("password"));
		
		loginbtn.click();
		
		return usertext.getText();
	}
	
	public String emptyPassword()
	{
		username.sendKeys(p.getProperty("useraname"));
		
		password.sendKeys("");
		
		loginbtn.click();
		
		return pwdtext.getText();
	}
	
	
}
