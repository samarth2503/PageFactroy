package com.crm.qa.Testcase;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.Test;

import com.crm.qa.Base.BasePage;
import com.crm.qa.Testdata.DatProviderUtil;
import com.crm.qa.actions.AddEmployeePage;

public class EmployeeTest extends BasePage{
	
	public AddEmployeePage emp;
	public EmployeeTest() throws IOException {
		super();
		emp = new AddEmployeePage();
		
	}
	
	@Test(dataProvider="getData",dataProviderClass=DatProviderUtil.class)
	public void addEmployeeTest(Hashtable<String,String> h)
	{
		test=extent.createTest("addEmployeeTest");
		emp.addEmployee(h.get("Firstname"),h.get("Lastname"));
	}
	
	@Test(dataProvider="getData",dataProviderClass=DatProviderUtil.class)
	public void addpersonalDetails(Hashtable<String,String> h) throws InterruptedException
	{
		test=extent.createTest("addEmployeeTest");
		emp.personalDetails(h.get("Gender"),h.get("Country"),h.get("Status"),h.get("DOB"),h.get("Bloodgroup"));
	}
	
	@Test
	public void addContactDetaisTest(Hashtable<String,String> h)
	{
		test=extent.createTest("addEmployeeTest");
		emp.addContactDetais(h.get("Address1"),h.get("City"),h.get("State"),h.get("Country"),h.get("MobileNo"));
	}

}
