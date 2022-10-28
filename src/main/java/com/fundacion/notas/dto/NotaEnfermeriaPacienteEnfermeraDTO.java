package com.fundacion.notas.dto;

import java.math.BigDecimal;
import java.util.Date;


public class NotaEnfermeriaPacienteEnfermeraDTO {
	
	private Date fechaNota;
	private String horaNota;
	private String notaGeneral;
	private String nombresEnfermera;
	private String apellidosEnfermera;
	private BigDecimal telefonoEnfermera;
	private String correoEnfermera;
	private String nombresPaciente;
	private String apellidosPaciente;
	private BigDecimal telefonoPaciente;
	private String correoPaciente;
	
	public Date getFechaNota() {
		return fechaNota;
	}
	public void setFechaNota(Date fechaNota) {
		this.fechaNota = fechaNota;
	}
	public String getHoraNota() {
		return horaNota;
	}
	public void setHoraNota(String horaNota) {
		this.horaNota = horaNota;
	}
	public String getNotaGeneral() {
		return notaGeneral;
	}
	public void setNotaGeneral(String notaGeneral) {
		this.notaGeneral = notaGeneral;
	}
	public String getNombresEnfermera() {
		return nombresEnfermera;
	}
	public void setNombresEnfermera(String nombresEnfermera) {
		this.nombresEnfermera = nombresEnfermera;
	}
	public String getApellidosEnfermera() {
		return apellidosEnfermera;
	}
	public void setApellidosEnfermera(String apellidosEnfermera) {
		this.apellidosEnfermera = apellidosEnfermera;
	}
	public BigDecimal getTelefonoEnfermera() {
		return telefonoEnfermera;
	}
	public void setTelefonoEnfermera(BigDecimal telefonoEnfermera) {
		this.telefonoEnfermera = telefonoEnfermera;
	}
	public String getCorreoEnfermera() {
		return correoEnfermera;
	}
	public void setCorreoEnfermera(String correoEnfermera) {
		this.correoEnfermera = correoEnfermera;
	}
	public String getNombresPaciente() {
		return nombresPaciente;
	}
	public void setNombresPaciente(String nombresPaciente) {
		this.nombresPaciente = nombresPaciente;
	}
	public String getApellidosPaciente() {
		return apellidosPaciente;
	}
	public void setApellidosPaciente(String apellidosPaciente) {
		this.apellidosPaciente = apellidosPaciente;
	}
	public BigDecimal getTelefonoPaciente() {
		return telefonoPaciente;
	}
	public void setTelefonoPaciente(BigDecimal telefonoPaciente) {
		this.telefonoPaciente = telefonoPaciente;
	}
	public String getCorreoPaciente() {
		return correoPaciente;
	}
	public void setCorreoPaciente(String correoPaciente) {
		this.correoPaciente = correoPaciente;
	}
	
	
	

}
