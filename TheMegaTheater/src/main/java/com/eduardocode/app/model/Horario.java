package com.eduardocode.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.persistence.Transient;

@Entity
@Table(name="Horarios")
public class Horario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	//@Transient // Omitir este campo en busquedas con jpa
	@ManyToOne // relacion muchos horarios le pertenecen a una pelicula
	@JoinColumn(name="idPelicula")
	private Pelicula pelicula;
	
	private Date fecha;
	private String hora; // HH:mm
	private String sala;
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
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Horario [id=" + id + ", pelicula=" + pelicula + ", fecha=" + fecha + ", hora=" + hora + ", sala=" + sala
				+ ", precio=" + precio + "]";
	}
	
}
