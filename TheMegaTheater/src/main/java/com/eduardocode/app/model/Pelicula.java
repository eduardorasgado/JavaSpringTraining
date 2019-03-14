package com.eduardocode.app.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

// esta clase es un modelo y se representara como un java bean
@Entity
@Table(name="Peliculas")
public class Pelicula {

	// las propiedades esran privadas y podran ser
	// accesadas con setters / getters
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // Autoincrement MySQL
	private int id;
	@Column(name="titulo", length=250, nullable=false)
	private String titulo;
	private int duracion = 100;
	private String clasificacion = "B";
	private String genero;
	private String imagen = "cinema.png"; // valor por default
	private LocalDate fechaEstreno;
	private String status = "Activa";
	
	// atributos de la clase compuesta
	
	// ignorar este atributo durante la persistencia
	// indica a jpa que este atributo no es persistente
	// Es usado en casos de relaciones entre tablas
	// para evitar hacer la relacion en algun query que aisle a Pelicula
	@Transient 
	private Detalle detalle;
	
	public Pelicula() {
		// default constructor
		System.out.println("Se ha creado una pelicula");
	}
	
	// acceso a atributos
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
	public LocalDate getFechaEstreno() {
		return fechaEstreno;
	}
	public void setFechaEstreno(LocalDate fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Detalle getDetalle() {
		return detalle;
	}
	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}

	// formato del despliegue actual del objeto
	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", duracion=" + duracion + ", clasificacion="
				+ clasificacion + ", genero=" + genero + ", imagen=" + imagen + ", fechaEstreno=" + fechaEstreno
				+ ", status=" + status + ", detalle=" + detalle + "]";
	}
}
