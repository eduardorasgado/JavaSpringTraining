package com.eduardocode.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// anotaciones para Spring Data JPA
// debe pertenecer al paquete javax.persistence
@Entity
// configuracion de la tabla donde se almacenara la entidad
@Table(name="Noticias")
public class Noticia {
	
	@Id // llave primaria. Al ser autoincrementable en la db
		// entonces sera unica
	@GeneratedValue(strategy=GenerationType.IDENTITY) // generable por secuencia
											// se define usar una constante(IDENTITY) que
											// varia segun el motor de base de datos
	private int id;
	/*
	 * @Column
	 * si el nombre de nuestro atributo en nuestra entidad, mapea con un campo de una tabla 
	 * y tienen el mismo nombre, en este caso se puede omitir la anotación @Column
	 * */
	@Column(name="titulo", length=250, nullable=false)
	private String titulo;
	@Column(name="fecha")
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
		this.detalle = detalle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Noticia [id=" + id + ", titulo=" + titulo + ", fechaPublicacion=" + fechaPublicacion + ", detalle="
				+ detalle + ", status=" + status + "]";
	}
}
