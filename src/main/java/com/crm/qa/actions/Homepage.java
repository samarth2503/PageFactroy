package com.crm.qa.actions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.crm.qa.Base.BasePage;
import com.crm.qa.locators.AddEmployeeLocator;
import com.crm.qa.locators.HomePageLocator;

public class Homepage extends BasePage {
	
	HomePageLocator home; 
	public Homepage() throws IOException {
		super();
		this.home = new HomePageLocator();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(driver, home);
	}

	public WebDriver driver;
	
	
	public AddEmployeePage addEmployee() throws IOException
	{
		navigateTosubmenu(driver,home.PIM,home.AddEmployee);
		return new AddEmployeePage();
	}
	
	public AddUser adduser() throws IOException
	{
		navigateTosubmenu(driver,home.Admin,home.userMang);
		return new AddUser();
	}
	
	public EmployeeListPage employeeList() throws IOException
	{
		navigateTosubmenu(driver,home.PIM,home.empList);
		return new EmployeeListPage();
	}
	
	public EmployeeLeave employeeleave() throws IOException
	{
		navigateTosubmenu(driver,home.Leave,home.Apply);
		return new EmployeeLeave();
	}
	
	/*public EditCustomer editCustomer()
	{
		home.editcust.click();
		return new EditCustomer();
	} */
	
	public void newAccount()
	{
		home.newacc.click();
	}
	
	public void EditAccount()
	{
		home.editacc.click();
	}
	
	public void DeleteAccount()
	{
		home.deleteacc.click();
	}
	
}
