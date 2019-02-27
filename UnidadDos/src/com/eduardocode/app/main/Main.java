package com.eduardocode.app.main;

import javax.swing.JOptionPane;

import com.eduardocode.app.model.Alumno;
import com.eduardocode.app.model.Persona;
import com.eduardocode.app.utils.Utility;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String today = "26-02-2019";
		Persona p1 = new Persona("Eduardo", 24);
		Alumno a1 = new Alumno("Eduardo", 24);
		
		a1.setNombre("Brayan");
		a1.setControl(16190777);
		
		a1.setFechaIngreso(Utility.stringToFecha(today));
		
		System.out.println(p1);
		System.out.println(a1.getFechaIngreso());
		
		// imprimiendo en una ventana
		//JOptionPane.showMessageDialog(null, p1);
		//JOptionPane.showMessageDialog(null, a1);
	}

}
