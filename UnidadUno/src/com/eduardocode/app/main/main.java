package com.eduardocode.app.main;

import com.eduardocode.app.model.*;

public class main {

	// TEMARIO
	// paradigma de la prog orieintada a objetos
	// paradigma de la prog visual
	// Elementos de la .. objetos
	
	public static void main(String[] args) {
		System.out.println("Hola papu pro");
		
		// creando un objeto de tipo persona
		var p1 = new Persona("Eduardo", 24);
		System.out.println(p1.getNombre());
		
		// creando un objeto de tipo alumno
		var al1 = new Alumno("Nestor", 18);
		System.out.println(al1);
	}
}
