package com.crm.qa.Testdata;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import com.crm.qa.utilites.Constants;

public class DatProviderUtil {
	
	public ExcelReader ex;
	
	
	@DataProvider
	public Object[][] getData(Method m)
	{
		ex = new ExcelReader(Constants.Excelpath);
		String sheetname = m.getName();
		
		Object obj[][] = new Object[ex.getRowCount(sheetname)][1];
		
		Hashtable<String,String> h = new Hashtable<String,String>();
		for(int i=0;i<ex.getRowCount(sheetname);i++)
		{
			for(int j=0;j<ex.getColumncount(sheetname);j++)
			{
				h.put(ex.getCellData1(sheetname, j, 0), ex.getCellData1(sheetname, j, i+1));
			}
			
			obj[i][0]=h;
		}
		
		return obj;
	}

}
