package com.eduardocode.app.model;

import java.util.Date;

public class Noticia {
	private int id;
	private String titulo;
	private Date fechaPublicacion;
	private String detalle;
	private String status;
	
	public Noticia() {
		System.out.println("[NUEVA NOTICIA CREADA]");
		// el atributo de fecha se crea de forma automatica
		this.fechaPublicacion = new Date();
		this.status = "Activa";
	}

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
		System.out.println("Set titulo");
		this.titulo = titulo;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		System.out.println("Set detalle");
		this.detalle = detalle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		System.out.println("Set status");
		this.status = status;
	}

	@Override
	public String toString() {
		return "Noticia [id=" + id + ", titulo=" + titulo + ", fechaPublicacion=" + fechaPublicacion + ", detalle="
				+ detalle + ", status=" + status + "]";
	}
}
