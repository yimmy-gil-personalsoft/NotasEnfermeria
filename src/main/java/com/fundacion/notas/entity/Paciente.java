package com.fundacion.notas.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "paciente")
public class Paciente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombre_paciente")
	private String nombrePaciente;
	
	@Column(name = "apellido_paciente")
	private String apellidoP;
	
	@Column(name = "telefono_paciente")
	private BigDecimal telefonoP;
	
	@Column(name = "correo_paciente")
	private String correoP;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@ManyToOne(fetch = FetchType.LAZY)
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
	public BigDecimal getTelefonoP() {
		return telefonoP;
	}
	public void setTelefonoP(BigDecimal telefonoP) {
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
