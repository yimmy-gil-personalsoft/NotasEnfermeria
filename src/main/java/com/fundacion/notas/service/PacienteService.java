package com.fundacion.notas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundacion.notas.entity.Paciente;
import com.fundacion.notas.repository.IPacienteRepository;

@Service
public class PacienteService {
	
	@Autowired
	private IPacienteRepository iPacienteRepository;
	
	public List<Paciente> getAll(){
		return (List<Paciente>) iPacienteRepository.findAll();
	}
	
	public Optional<Paciente> detail(int id) {
		return iPacienteRepository.findById(id);
	}
	
	public Paciente save(Paciente paciente) {
		return iPacienteRepository.save(paciente);
	}
	
	public Paciente update(int id, Paciente paciente) {
		Paciente pacienteRequest = iPacienteRepository.findById(id).orElseThrow(null);
		pacienteRequest.setNombrePaciente(paciente.getNombrePaciente());
		pacienteRequest.setApellidoP(paciente.getApellidoP());
		pacienteRequest.setCorreoP(paciente.getCorreoP());
		pacienteRequest.setDiscapacidad(paciente.getDiscapacidad());
		pacienteRequest.setTelefonoP(paciente.getTelefonoP());
		return iPacienteRepository.save(pacienteRequest);
		
	}
	
	public String delete(int id) {
		try {
			iPacienteRepository.deleteById(id);
			return "Paciente eliminado";
		} catch (Exception e) {
			return "Error: "+e;
		}
	
	}
	

}
