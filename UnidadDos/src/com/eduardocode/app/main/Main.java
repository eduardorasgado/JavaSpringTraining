package com.eduardocode.app.main;

import javax.swing.JOptionPane;

import com.eduardocode.app.model.Alumno;
import com.eduardocode.app.model.Persona;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona p1 = new Persona("Eduardo", 24);
		Alumno a1 = new Alumno("Eduardo", 24);
		
		System.out.println(p1);
		
		// imprimiendo en una ventana
		JOptionPane.showMessageDialog(null, p1);
		JOptionPane.showMessageDialog(null, a1);
	}

}
