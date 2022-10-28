package com.fundacion.notas.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundacion.notas.dto.PacienteDTO;
import com.fundacion.notas.entity.Paciente;
import com.fundacion.notas.service.PacienteService;

@RestController
@RequestMapping("/api/paciente")
public class PacienteController {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PacienteService pacienteService;

	@GetMapping("/listar")
	public ResponseEntity<List<PacienteDTO>> listarPacientes() {
		return new ResponseEntity<>(pacienteService.getAll().stream()
				.map(paciente -> modelMapper.map(paciente, PacienteDTO.class))
				.collect(Collectors.toList()),HttpStatus.OK);
	}

	@GetMapping("/detalle")
	public ResponseEntity<Optional<Paciente>> detallePaciente(int id) {
		Optional<Paciente> paciente = pacienteService.detail(id);
		PacienteDTO pacienteResponse = modelMapper.map(paciente, PacienteDTO.class);
		return  ResponseEntity.ok().body(paciente);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Paciente> guardarPaciente(@RequestBody Paciente paciente){
		return new ResponseEntity<>(pacienteService.save(paciente),HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<PacienteDTO> actualizarPaciente(int id, @RequestBody PacienteDTO pacienteDTO){
		Paciente pacienteRequest = modelMapper.map(pacienteDTO, Paciente.class);
		Paciente paciente = pacienteService.update(id,pacienteRequest);
		PacienteDTO pacienteResponse = modelMapper.map(paciente, PacienteDTO.class);
		return ResponseEntity.ok().body(pacienteResponse);
	}
	
	@DeleteMapping("/eliminar")
	public ResponseEntity<String> eliminar(int id){
		return new ResponseEntity<>(pacienteService.delete(id),HttpStatus.OK);
	}

}
