package com.eduardocode.app.model;

public class Docente extends Persona {
	//
	private String cedula;
	private String especialidad;
	
	public Docente(String nombre, int edad) {
		// escriboendo las que extiendedn de la clase
		// heredada
		super(nombre, edad);
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return "Docente [cedula=" + cedula + ", especialidad=" + especialidad 
				+ ", Nombre=" + super.getNombre()
				+ ", Edad=" + super.getEdad() + "]";
	}
	
	
}
