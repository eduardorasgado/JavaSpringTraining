package com.eduardocode.app.model;

import java.util.Date;

// esta clase es un modelo y se representara como un java bean
public class Pelicula {

	// las propiedades esran privadas y podran ser
	// accesadas con setters / getters
	private int id;
	private String titulo;
	private int duracion = 100;
	private String clasificacion = "B";
	private String genero;
	private String imagen = "cinema.png"; // valor por default
	private Date fechaEstreno;
	private String status = "Activa";
	
	public Pelicula() {
		// default constructor
		System.out.println("Se ha creado una pelicula");
	}
	
	// acceso a atibutos
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		if(!imagen.isEmpty()) {
			this.imagen = imagen;
		}
	}
	public Date getFechaEstreno() {
		return fechaEstreno;
	}
	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	// formato del despliegue actual del objeto
	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", duracion=" + duracion + ", clasificacion="
				+ clasificacion + ", genero=" + genero + ", imagen=" + imagen + ", fechaEstreno=" + fechaEstreno
				+ ", status=" + status + "]";
	}	
}
