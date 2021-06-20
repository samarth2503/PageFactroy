package com.crm.qa.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.qa.actions.Homepage;
import com.crm.qa.actions.LoginPage;
import com.crm.qa.utilites.Constants;
import com.crm.qa.utilites.Log;

import Capablity.Capablities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public Properties p;
	public static Log log = new Log(); 
	public Homepage hp;
	public LoginPage lp;
	public static WebDriver driver;
	public WebDriverWait wait;
	public static ExtentHtmlReporter htmlreport;
	public ExtentReports extent;
	public ExtentTest test;
	public Actions ac;
	public BasePage() throws IOException
	{
		FileInputStream f = new FileInputStream(System.getProperty("user.dir").concat("\\src\\main\\java\\com\\crm\\qa\\configration\\config.properties"));
		p = new Properties();
		p.load(f);
		initalize();
	}
	
	public void initalize() throws IOException
	{
		String browser=null;
		Capabilities cap=null;
		
		if(Constants.browser.equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir").concat("chromedriver-1.exe"));
			WebDriverManager.chromedriver().setup();
			Map<String,Object> prefs = new HashMap<String,Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);						// This will stop the notification pop-up
			prefs.put("credentials_enable_service", false);												// this will stop the pop-up to save crdentails
			prefs.put("profile.password.manager_enabled", false);										// This will stop pop-up for passowrd save.
			ChromeOptions opt = new ChromeOptions();
			//opt.addArguments("disable-infobars");
			//opt.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver();
			cap = (Capabilities) ((RemoteWebDriver) driver).getCapabilities();
			
			cap.getVersion();
			cap.getVersion();
			log.debug("--Launching Chrome Browser");
		}
		
		htmlreport = new ExtentHtmlReporter("D:\\Selenium WorkSpace\\PageFactory\\ExtentReport\\Report.html");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("Orange HRM Report");
		htmlreport.config().setDocumentTitle("Ornage HTML Automation Report");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlreport);
		
		extent.setSystemInfo("Browser",cap.getBrowserName());
		extent.setSystemInfo("OS", cap.getBrowserName());
		extent.setSystemInfo("Platform", cap.getPlatform().toString());
		extent.setSystemInfo("Tester Name", "Samarth Jain");
		
		driver.get(Constants.testurl);
		driver.manage().timeouts().pageLoadTimeout(10l, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.implicitywait, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		wait = new WebDriverWait(driver,15);
		ac = new Actions(driver);
		lp = new LoginPage();		
	}
	
	public WebElement getElement(String path) throws InterruptedException
	{
		WebElement element=null;
		try {
			Thread.sleep(1000);
			element=driver.findElement(By.xpath(path));
			log.info("Element found with xpath "+path);
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
			log.error("No such Elment found with "+path);
		}
		return element;
	}
	
	public void navigateTosubmenu(WebDriver driver,WebElement source,WebElement target)
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(source).click(target);
	}
	
	public void scrolldown(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView(true);",element);
	}
	
	public void selectFromDropdown(WebElement element,String data)
	{
		Select s = new Select(element);
		
		List<WebElement> option = s.getOptions();
		//element.findElements(By.tagName("option"));
		for(int i=0;i<option.size();i++)
		{
			if(option.get(i).getText().equals(data))
			{
				s.selectByVisibleText(data);
				log.info("Option "+data+" is selected");
				break;
			}
			else
			{
				log.info("Option "+data+" is not available");
			}
		}
	}
	
	public void enterTextJS(WebDriver driver,String data,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='"+data+"'", element);
	}
	
	public void clickObj(WebElement element)
	{
		scrolldown(element);
		element.click();
		log.info("Element is clicked");
	}
	
	public void waitforVisibility(By locator)
	{
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean InsertText(WebElement element,String data)
	{
		try {
			 if(data.equals(""))
			 {
				 return true;
			 }
			 else
			 {
				 element.clear();
				 element.sendKeys(data);
				 log.info("Text "+data+ " is insert ");
				 return true;
			 }
		}
		catch(NoSuchElementException e)
		{
			log.info("No Such Element found with "+element);
			log.error(e.getMessage());
			return false;
		}
	}
	
	public void captureScreenshot(String testName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		String df = new SimpleDateFormat("YYYY-MM-dd HH:MM").format(new Date());
		
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		
		String path = "D:\\Selenium WorkSpace\\PageFactory\\ExtentReport"+testName+"-"+df+".html";
		
		File destFile = new File(path);
		
		FileUtils.copyFile(srcFile, destFile);
		
	}
	
	public boolean TextToBePresent(WebElement element,String text)
	{
		try {
			wait.until(ExpectedConditions.textToBePresentInElement(element, text));
			return true;
		}
		catch(Exception e)
		{
			log.error("The text "+text+" is not present");
			return false;
		}
	}
	
	/*public List<String> getElements(String path)
	{
		List<WebElement> elements = driver.findElements(By.xpath(path));
		List<String> explist = new ArrayList<String>();
		for(int i=1;i<=elements.size();i++)
		{
			List<WebElement> text = elements.get(i).findElements(By.tagName("td"));
			for(int j=2;j<=5;j++)
			{
				String data = text.get(j).getText();
				if(data!=null)
				{
					explist.add(data);
				}
			}
		}
		return explist;
	}*/
	
	public String gettext(WebElement element)
	{
		String text = element.getText();
		return text;
	}
	
	public boolean visibilityofelement(WebElement element)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		}
		catch(Exception e)
		{
			log.error("Element is not visbile");
			return false;
		}
	}
	
	public boolean compareText(WebElement element,String text)
	{
		String data = gettext(element);
		
		if(data.equals(text))
		{
			log.info("Text is equal");
			return true;
		}
		else
		{
			log.error("Text is not equal");
			return false;
		}
	}

}
