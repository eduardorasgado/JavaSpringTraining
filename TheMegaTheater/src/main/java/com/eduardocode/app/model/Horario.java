package com.eduardocode.app.model;

import java.util.Date;

public class Horario {
	private int id;
	private Pelicula pelicula;
	private Date fecha;
	private String hora; // HH:mm
	private double precio;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Horario [id=" + id + ", pelicula=" + pelicula + ", fecha=" + fecha + ", hora=" + hora + ", precio="
				+ precio + "]";
	}
	
}
