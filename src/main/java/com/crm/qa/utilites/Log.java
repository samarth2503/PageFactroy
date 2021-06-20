package com.crm.qa.utilites;

import org.apache.log4j.Logger;

public class Log {
	
	public static Logger logs = Logger.getLogger(Log.class.getName());
	
	public void start(String testcase)
	{
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println();
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$"+   testcase    +"$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println();
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

	}
	
	public void debug(String msg)
	{
		logs.debug(msg);
	}
	
	public void error(String msg)
	{
		logs.error(msg);
	}
	
	public void warn(String msg)
	{
		logs.warn(msg);
	}
	
	public void fatal(String msg)
	{
		logs.fatal(msg);
	}
	
	public void info(String msg)
	{
		logs.info(msg);
	}
	
	public void end()
	{
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println();
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$"+   "END"   +"$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println();
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

	}
	

}
