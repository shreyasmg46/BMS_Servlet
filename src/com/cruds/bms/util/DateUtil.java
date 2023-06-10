package com.cruds.bms.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	private static final SimpleDateFormat dateTimeFormatter =
			new SimpleDateFormat("yyyy-MM-dd");
	
	public static java.sql.Date strToSQLDate(String strDate)
	{
		java.util.Date date = null;
		try {
			date = dateTimeFormatter.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new java.sql.Date(date.getTime());
	}
	
	public static java.sql.Date getCurrDateAsSQLDate()
	{
		java.util.Date date = new Date();
		
		/*
		 * java.util.Date date = null; try { date = new
		 * SimpleDateFormat("yyyy-MM-dd").parse("2022-07-30"); } catch (ParseException
		 * e1) { 
		 */
		
	    java.sql.Date rDate = new java.sql.Date(date.getTime()); 
	    return rDate;
	
	}

}
