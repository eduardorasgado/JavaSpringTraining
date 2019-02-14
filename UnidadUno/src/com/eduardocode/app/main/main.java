package com.eduardocode.app.main;

import com.eduardocode.app.model.*;

public class main {

	// TEMARIO
	// paradigma de la prog orieintada a objetos
	// paradigma de la prog visual
	// Elementos de la .. objetos
	
	public static void main(String[] args) {
		// creando un objeto de tipo persona
		var p1 = new Persona("Eduardo", 24);
		System.out.println(p1.getNombre());
		// sobre escribimos el atributo nombre
		p1.setNombre("Pedro");
		System.out.println(p1.getNombre());
		p1.setEdad(24);
		System.out.println(p1.getEdad());
		
		System.out.println(p1);
		
		// Para el proximo martes crear dos clases mas
		// clase alumno
		// clase docente
		
		// creando un objeto de tipo alumno
		var al1 = new Alumno("Nestor", 18);
		System.out.println(al1);
		
		var d1 = new Docente("Alberto", 60);
		System.out.println(d1);
	}
}
