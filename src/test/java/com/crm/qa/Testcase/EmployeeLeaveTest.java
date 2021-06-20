package com.crm.qa.Testcase;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.qa.Base.BasePage;
import com.crm.qa.actions.EmployeeLeave;

public class EmployeeLeaveTest extends BasePage{
	
	public EmployeeLeave el;
	public EmployeeLeaveTest() throws IOException {
		super();
		el = new EmployeeLeave();
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void applyLeaveTest(Hashtable<String,String> h)
	{
		boolean flag=el.applyLeave(h.get("leavetyp"), h.get("frmmonth"), h.get("frmyear"), h.get("tomonth"), h.get("toyear"));
		Assert.assertTrue(flag);
		String msg = gettext();
	}

}
