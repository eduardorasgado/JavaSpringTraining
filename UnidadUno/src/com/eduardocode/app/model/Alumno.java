package com.eduardocode.app.model;

import java.util.Date;

public class Alumno extends Persona{
	private String control;
	private Date fechaIngreso;
	
	public Alumno(String nombre, int edad) {
		super(nombre, edad);
		System.out.println("Se ha creado un alumno");
		// creando una fecha
		this.fechaIngreso = new Date();
	}

	public String getControl() {
		return control;
	}

	public void setControl(String control) {
		this.control = control;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String toString() {
		return "Alumno [ Nombre="
				+ this.getNombre()
				+" Numero de control=" 
				+ control + ", fecha de ingreso=" 
				+ fechaIngreso + "]";
	}
	
	
	
}
