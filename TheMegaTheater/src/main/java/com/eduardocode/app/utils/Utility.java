package com.eduardocode.app.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Utility {
	/*
	 * Esta clase incluye un conjunto de herramientas generales
	 * 
	 * */
	public static List<String> generateNextDays(int quantity){
		// generamos una lista de los siguientes n dias a la fecha
		// actual
		var dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		
		// la fecha de hoy
		var primerDia = new Date();
		
		// calculando la fecha de pasados los N dias a partir de hoy
		var calendario = Calendar.getInstance();
		calendario.add(Calendar.DAY_OF_MONTH, quantity); // agregando n dias
		var ultimoDia = calendario.getTime();
		
		var fechas = new ArrayList<String>();
		
		// obtener las fechas intermedias
		// calendario donde iran las fechas
		var g_cal = new GregorianCalendar();
		g_cal.setTime(primerDia);
		
		// agregando las fechas faltantes
		while(!g_cal.getTime().after(ultimoDia)) {
			// mientras no se haya llegado al ultimo dia
			// agregamos la fecha actual
			Date actualDate = g_cal.getTime();
			fechas.add(dateFormatter.format(actualDate));
			// avanzamos un dia
			g_cal.add(Calendar.DATE, 1);
		}
		
		return fechas;
	}
}
