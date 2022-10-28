package com.fundacion.notas.dto;

import java.math.BigDecimal;

public class EnfermeraDTO {
	
	private int id;
	private String nombre;
	private String apellido;
	private BigDecimal telefono;
	private String correo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public BigDecimal getTelefono() {
		return telefono;
	}
	public void setTelefono(BigDecimal telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	

}
