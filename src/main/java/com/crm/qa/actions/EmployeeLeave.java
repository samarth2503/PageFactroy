package com.crm.qa.actions;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.crm.qa.Base.BasePage;
import com.crm.qa.locators.EmployeeLeaveLocator;

public class EmployeeLeave extends BasePage {
	
	public EmployeeLeaveLocator ell;
	
	public EmployeeLeave() throws IOException {
		super();
		this.ell = new EmployeeLeaveLocator();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this.ell);
	}
	
	/**
	 * 
	 * @param leavetyp
	 * @param frmmonth
	 * @param frmyear
	 * @param tomonth
	 * @param toyear
	 * @return
	 */
	
	public boolean applyLeave(String leavetyp,String frmmonth,String frmyear,String tomonth,String toyear)
	{
		boolean check = true;
		selectFromDropdown(ell.leavetype, leavetyp);
		visibilityofelement(ell.leaveblc);
		clickObj(ell.fromdt);
		selectFromDropdown(ell.monthdrp,frmmonth);
		selectFromDropdown(ell.yeardrp,frmyear);
		
		clickObj(ell.todt);
		selectFromDropdown(ell.monthdrp,tomonth);
		selectFromDropdown(ell.yeardrp,toyear);
		
		if(compareText(ell.leaveblnc,"Balance not sufficent"))
		{
			check=false;
			log.info("Leave can't be applied as balance leave if not sufficent");
		}
		else if(compareText(ell.leaveblnc,"view details"))
		{
			check=true;
			log.info("Sufficent balance is available");
		}
		
		clickObj(ell.applybtn);
		
		return check;
		
	}
	
	public void myLeave()
	{
		
	}

}
