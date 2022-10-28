package com.fundacion.notas.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fundacion.notas.entity.Enfermera;
import com.fundacion.notas.entity.Paciente;

public class NotaEnfermeriaDTO {
	
	private int id;
	private Date fecha;
	private String hora;
	private String nota;
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Enfermera enfermera;
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Paciente paciente;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	public Enfermera getEnfermera() {
		return enfermera;
	}
	public void setEnfermera(Enfermera enfermera) {
		this.enfermera = enfermera;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
	

}
