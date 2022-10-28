package com.fundacion.notas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fundacion.notas.entity.Discapacidad;

public class PacienteDTO {
	
	private int id;
	private String nombrePaciente;
	private String apellidoP;
	private String telefonoP;
	private String correoP;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Discapacidad discapacidad;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombrePaciente() {
		return nombrePaciente;
	}
	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}
	public String getApellidoP() {
		return apellidoP;
	}
	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}
	public String getTelefonoP() {
		return telefonoP;
	}
	public void setTelefonoP(String telefonoP) {
		this.telefonoP = telefonoP;
	}
	public String getCorreoP() {
		return correoP;
	}
	public void setCorreoP(String correoP) {
		this.correoP = correoP;
	}
	public Discapacidad getDiscapacidad() {
		return discapacidad;
	}
	public void setDiscapacidad(Discapacidad discapacidad) {
		this.discapacidad = discapacidad;
	}
	
	
	
	

}
