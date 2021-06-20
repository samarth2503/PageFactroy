package com.crm.qa.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.crm.qa.Base.BasePage;
import com.crm.qa.locators.AddUserLocator;
import com.crm.qa.locators.HomePageLocator;

public class AddUser extends BasePage {
	
	AddUserLocator addusrloc;

	public AddUser() throws IOException {
		super();
		this.addusrloc = new AddUserLocator();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(driver, this.addusrloc);
	}
	
	public boolean addUser(String role,String empname,String name,String Status,String pwd)
	{
		boolean check = true;
		clickObj(addusrloc.addbtn);
		selectFromDropdown(addusrloc.usertype,role);
		InsertText(addusrloc.empname,empname);
		InsertText(addusrloc.username,name);
		selectFromDropdown(addusrloc.status,Status);
		InsertText(addusrloc.password,pwd);
		InsertText(addusrloc.cnfpwd,pwd);
		clickObj(addusrloc.Savebtn);
		
		check=visibilityofelement(addusrloc.tabledata);
		
		List<WebElement> elements = driver.findElements(By.xpath("//table[@id='resultTable']//tbody//tr"));
		List<String> explist = new ArrayList<String>();
		String[] act = {name,role,empname,Status};
		List<String> actlist = Arrays.asList(act);
		for(int i=1;i<elements.size();i++)
		{
			List<WebElement> data = elements.get(i).findElements(By.tagName("td"));
			String un = gettext(driver.findElement(By.xpath("//table[@id='resultTable']//tbody//tr//td[2]//a")));
			explist.add(un);
			for(int j=3;j<=5;j++)
			{
				explist.add(data.get(j).getText());
			}
			
			if(explist.containsAll(actlist))
			{
				System.out.println("Match is found");
				System.out.println("Actual data is  "+actlist.toString()+" and expected is "+explist.toString());
				check=true;
			}
			else
			{
				System.out.println("No Match is found");
				System.out.println("Actual data is  "+actlist.toString()+" and expected is "+explist.toString());
				check=false;
			}
		}
		
		return check;
	}	

	
	public void addjobTitle(String jobtitle) throws IOException
	{
		navigateTosubmenu(driver,addusrloc.Admin,addusrloc.job);
		ac.moveToElement(addusrloc.jobtitle).click();
		driver.findElement(By.xpath("//table[@id='resultTable']//tbody//tr//td[2]//a[contains(text(),"+jobtitle+")]//parent::td//preceding-sibling::td//input")).click();
		clickObj(addusrloc.addbtn);
		
	}
	

}
