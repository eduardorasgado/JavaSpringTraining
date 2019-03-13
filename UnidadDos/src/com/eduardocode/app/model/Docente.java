package com.eduardocode.app.model;

import java.util.Date;

public class Docente {
	private String plaza;
	private Date fechaIngreso;
	private int control;
	public String getPlaza() {
		return plaza;
	}
	public void setPlaza(String plaza) {
		this.plaza = plaza;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public int getControl() {
		return control;
	}
	public void setControl(int control) {
		this.control = control;
	}
	
	
}
