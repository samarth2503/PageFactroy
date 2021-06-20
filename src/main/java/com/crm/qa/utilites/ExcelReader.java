package com.crm.qa.utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public FileInputStream input;
	
	public ExcelReader(String filepath) throws IOException
	{
		try {
			input = new FileInputStream(filepath);
			workbook = new XSSFWorkbook(input);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			e.getMessage();
		}
		
	}
	
	public String getCellData(String sheetname, int rowNum,int colNum)
	{
		String data=null;
		int index = workbook.getSheetIndex(sheetname);
		
		if(index==-1)
		{
			data = null;
		}
		
		row = sheet.getRow(rowNum);
		
		if(row==null)
		{
			data=null;
		}
		
		cell=row.getCell(colNum);
		
		if(cell==null)
		{
			data=null;
		}
		
		data = cell.getStringCellValue();
		return data;
	}
	
	
	public String getCellByColName(String sheetname, int rowNum,String colName)
	{
		String data=null;
		int index = workbook.getSheetIndex(sheetname);
		
		if(index==-1)
		{
			data = null;
		}
		
		row = sheet.getRow(0);
		int colCount=0;
		if(row==null)
		{
			data=null;
		}
		
		for(int i=0;i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).equals(colName))
			{
				colCount=i;
			}
		}
		
		cell=row.getCell(colCount);
		
		if(cell==null)
		{
			data=null;
		}
		
		data = cell.getStringCellValue();
		return data;
	}
	
	
	public boolean isSheetExist(String sheetname)
	{
		int index = workbook.getSheetIndex(sheetname);
		
		if(index==-1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public boolean addColumn(String sheetname,String colName)
	{
		int index = workbook.getSheetIndex(sheetname);
		boolean flag=false;
		
		if(index == -1)
		{
			return flag;
		}
		
		row = sheet.getRow(0);
		
		if(row==null)
		{
			return flag;
		}
		
		cell = row.getCell(row.getLastCellNum());
		if(cell==null)
		{
			cell.setCellValue(colName);
			flag=true;
		}
		
		return flag;
	}

}
