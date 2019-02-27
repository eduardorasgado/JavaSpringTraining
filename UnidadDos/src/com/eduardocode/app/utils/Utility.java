package com.eduardocode.app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
	
	public static Date stringToFecha(String fechaString) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			return formatter.parse(fechaString);
		} catch(ParseException error) {
			System.out.println("Error: "+ error.getMessage());
		}
		return null;
	}
}
