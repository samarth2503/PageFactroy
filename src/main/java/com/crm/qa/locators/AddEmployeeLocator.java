package com.crm.qa.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmployeeLocator {
	
	
	/* 
	 * Add employee
	 */
	@FindBy(xpath="//input[@id='firstName']")
	public WebElement firstname;
	
	@FindBy(xpath="//input[@id='lastName']")
	public WebElement lastname;
	
	@FindBy(xpath="//input[@name='employeeId']")
	public WebElement employeeid;
	
	@FindBy(xpath="//input[@id='btnSave']")
	public WebElement savebtn;
	
	/* 
	 * Personal Details of Employee
	 */
	@FindBy(xpath="//select[@id='personal_cmbNation']")
	public WebElement Nationality;
	
	@FindBy(xpath="//input[@id='personal_optGender_1']")
	public WebElement male;
	
	@FindBy(xpath="//input[@id='personal_optGender_2']")
	public WebElement female;
	
	@FindBy(xpath="//select[@id='personal_cmbMarital']")
	public WebElement maritalstatus;
	
	@FindBy(xpath="//input[@id='personal_DOB']")
	public WebElement dob;
	
	@FindBy(xpath="//select[@name='custom1']")
	public WebElement bloodgrp;
	
	@FindBy(xpath="//div[@class='personalDetails']//p//input[@value='Edit']")
	public WebElement editpd;
	
	@FindBy(xpath="//form[@name='frmEmpCustomFields']//p//input[@id='btnEditCustom']")
	public WebElement editCustom;
	
	@FindBy(xpath="//form[@id='frmEmpPersonalDetails']//input[@id='btnSave'")
	public WebElement savepd; 
	
	@FindBy(xpath="//form[@id='frmEmpCustomFields']//input[@id='btnEditCustom']")
	public WebElement savecustom;
	
	/* 
	 * Conatct Details of employee
	 */
	@FindBy(xpath="//input[@id='contact_street1']")
	public WebElement address1;
	
	@FindBy(xpath="//input[@id='contact_city']")
	public WebElement city;
	
	@FindBy(xpath="//input[@id='contact_province']")
	public WebElement state;
	
	@FindBy(xpath="//select[@id='contact_country']")
	public WebElement Country;
	
	@FindBy(xpath="//input[@id='contact_emp_mobile']")
	public WebElement Mobileno;
	
	@FindBy(xpath="//form[@id='frmEmpContactDetails']//p//input[@id='btnSave']")
	public WebElement savecntbtn; 
	
	
	/*
	 *  FetchText
	 */
	@FindBy(xpath="/html/body/div[1]/div[3]/div[1]/div[2]/div[2]/script/text()")
	public WebElement successmsg;
	
	/*
	 * Job
	 */

	@FindBy(xpath="//select[@id='job_job_title']")
	public WebElement jobtitle;
	
	@FindBy(xpath="//select[@id='job_emp_status']")
	public WebElement jobStatus;
	
	@FindBy(xpath="//select[@id='job_sub_unit']")
	public WebElement jobunit;
	
	@FindBy(xpath="job_contract_start_date")
	public WebElement startdatefeild;
	
	@FindBy(xpath="job_contract_end_date")
	public WebElement enddatefeild;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	public WebElement monthdrp;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	public WebElement yeardrp;
	
	@FindBy(xpath="//form[@id='frmEmpJobDetails']//li[10]//span")
	public WebElement todatemsg;
	
	@FindBy(xpath="//form[@id='frmEmpJobDetails']//li[9]//span")
	public WebElement fromdatemsg;
	
	@FindBy(xpath="//select[@id='job_eeo_category']")
	public WebElement jobCategory;
	
	@FindBy(xpath="//input[@id='btnTerminateEmployement']//preceding-sibling::input")
	public WebElement savebtnjob;
	
	/*
	 * MemberShip
	 */
	
	@FindBy(xpath="//select[@id='membership_membership']")
	public WebElement Memebership;
	
	@FindBy(xpath="//select[@id='membership_currency']")
	public WebElement Currency;
	
	@FindBy(id="membership_subscriptionAmount")
	public WebElement SubsAmt;
	
	@FindBy(id="membership_subscriptionCommenceDate")
	public WebElement CommenceDt;
	
	@FindBy(id="membership_subscriptionCommenceDate")
	public WebElement RenewalDt;
	
	
	
}
