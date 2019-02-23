package com.eduardocode.app.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

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
	
	public static String guardarImagen(MultipartFile multiPart,
			HttpServletRequest request) {
		// Obtener el nombre original del archivo
		var nombreOriginal = multiPart.getOriginalFilename();
		
		// quitando espacios del nombre del archivo imagen
		nombreOriginal = nombreOriginal.replace(" ", "-");
		
		// el argumento de split es un reges por lo que a el punto lo
		// tomamos como caracter especial en vez de regex al ponerle \\
		// como se puede ver aqui:
		// https://www.journaldev.com/634/regular-expression-in-java-regex-example
		String[] nombreArray = nombreOriginal.split("\\.");
		String extension = nombreArray[nombreArray.length-1];
		
		// reemplazando el nombre y agregando caracteres extra para evitar repeticion
		// de nombre de imagenes
		var diffCharacters = randomCharGenerator(8);
		nombreOriginal = nombreOriginal.replace("."+extension, diffCharacters+"."+extension);
		
		// Obtener la ruta absoluta del directorio images
		// apache-tomcat/webapps/cineapp/resources/images/
		var rutaFinal = request.getServletContext()
				.getRealPath("/resources/images/");
		try {
			// Formamos el nombre del archivo para guardarlo en el disco
			// duro
			var imageFile = new File(rutaFinal + nombreOriginal);
			
			System.out.println("ruta completa: "+ imageFile.getAbsolutePath());
			
			// Aqui se guarda fisicamente el archivo en el disco duro
			multiPart.transferTo(imageFile);
			return nombreOriginal;
		} catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
			return null;
		}
	}
	
	public static String randomCharGenerator(int count) {
		// genera una cadena de caracteres alfanumericos que se usa
		// para evitar imagenes con nombres duplicados
		String CARACTERES  = "ABCDEFGHIJKLMNOPQRSTUWVXYZ0123456789";
		StringBuilder builderr = new StringBuilder();
		while(count-- != 0) {
			// tomar aleatoriamente un caracter y agregarlo al builder
			int character = (int) (Math.random() * CARACTERES.length());
			builderr.append(CARACTERES.charAt(character));
		}
		return builderr.toString();
	}
}
