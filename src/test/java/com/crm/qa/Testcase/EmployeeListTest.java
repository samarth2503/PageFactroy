package com.crm.qa.Testcase;

import java.io.IOException;
import java.util.Hashtable;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.crm.qa.Base.BasePage;
import com.crm.qa.Testdata.DatProviderUtil;
import com.crm.qa.actions.EmployeeListPage;
import com.crm.qa.actions.Homepage;

public class EmployeeListTest extends BasePage{
	
	public EmployeeListPage emplst;
	public Homepage hp;
	public EmployeeListTest() throws IOException {
		super();
		hp=lp.Login();
		emplst = hp.employeeList();
	}
	
	@Test(dataProvider="getData",dataProviderClass=DatProviderUtil.class)
	public void deleteEmployee(Hashtable<String,String> h)
	{
		boolean flag=emplst.deleteEmployee(h.get("EmpName"),h.get("EmpId"));
		Assert.assertTrue(flag);
	}

}
