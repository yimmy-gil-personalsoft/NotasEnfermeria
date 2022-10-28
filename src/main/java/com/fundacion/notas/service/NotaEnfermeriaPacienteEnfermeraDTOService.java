package com.fundacion.notas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundacion.notas.dto.NotaEnfermeriaPacienteEnfermeraDTO;
import com.fundacion.notas.entity.NotaEnfermeria;
import com.fundacion.notas.repository.INotaEnfermeriaRepository;

@Service
public class NotaEnfermeriaPacienteEnfermeraDTOService {

	@Autowired
	private INotaEnfermeriaRepository iNotaEnfermeriaRepository;
	
	public List<NotaEnfermeriaPacienteEnfermeraDTO> getAllHistorial(){
		return iNotaEnfermeriaRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
				
	}
	
	private NotaEnfermeriaPacienteEnfermeraDTO convertEntityToDto(NotaEnfermeria notaEnfermeria) {
		NotaEnfermeriaPacienteEnfermeraDTO objNota = new NotaEnfermeriaPacienteEnfermeraDTO();
		objNota.setFechaNota(notaEnfermeria.getFecha());
		objNota.setHoraNota(notaEnfermeria.getHora());
		objNota.setNotaGeneral(notaEnfermeria.getNota());
		objNota.setNombresEnfermera(notaEnfermeria.getEnfermera().getNombre());
		objNota.setApellidosEnfermera(notaEnfermeria.getEnfermera().getApellido());
		objNota.setTelefonoEnfermera(notaEnfermeria.getEnfermera().getTelefono());
		objNota.setCorreoEnfermera(notaEnfermeria.getEnfermera().getCorreo());
		objNota.setNombresPaciente(notaEnfermeria.getPaciente().getNombrePaciente());
		objNota.setApellidosPaciente(notaEnfermeria.getPaciente().getApellidoP());
		objNota.setTelefonoPaciente(notaEnfermeria.getPaciente().getTelefonoP());
		objNota.setCorreoPaciente(notaEnfermeria.getPaciente().getCorreoP());
		return objNota;
	}
	
}
