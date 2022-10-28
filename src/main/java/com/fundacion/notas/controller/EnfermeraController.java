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

import com.fundacion.notas.dto.EnfermeraDTO;
import com.fundacion.notas.entity.Enfermera;
import com.fundacion.notas.service.EnfermeraService;

@RestController
@RequestMapping("/api/enfermera")
public class EnfermeraController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EnfermeraService enfermeraService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<EnfermeraDTO>> listarEnfermeras(){
		return new ResponseEntity<>(enfermeraService.getAll().stream()
				.map(enfermera -> modelMapper.map(enfermera, EnfermeraDTO.class))
				.collect(Collectors.toList()), HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<EnfermeraDTO> guardarEnfermera(@RequestBody EnfermeraDTO enfermeraDTO){
		Enfermera enfermeraRequest = modelMapper.map(enfermeraDTO,Enfermera.class);
		Enfermera enfermera = enfermeraService.save(enfermeraRequest);
		EnfermeraDTO enfermeraResponse = modelMapper.map(enfermera, EnfermeraDTO.class);
		return new ResponseEntity<EnfermeraDTO>(enfermeraResponse,HttpStatus.OK);
		//return new ResponseEntity<>(enfermeraService.save(enfermera),HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<EnfermeraDTO> actualizarEnfermera(int id, @RequestBody EnfermeraDTO enfermeraDTO){
		Enfermera enfermeraRequest = modelMapper.map(enfermeraDTO, Enfermera.class);
		Enfermera enfermera = enfermeraService.update(id, enfermeraRequest);
		EnfermeraDTO enfermeraResponse = modelMapper.map(enfermera, EnfermeraDTO.class);
		return ResponseEntity.ok().body(enfermeraResponse);
	}
		
	@GetMapping("/detalle")
	public ResponseEntity<Optional<Enfermera>> enfermeraDetalle(int id){
		Optional<Enfermera> enfermera = enfermeraService.getByDetail(id);
		EnfermeraDTO enfermeraDTO = modelMapper.map(enfermera, EnfermeraDTO.class);
		//return ResponseEntity.ok().body(enfermeraDTO);
		return ResponseEntity.ok().body(enfermera);
	}
	
	@DeleteMapping("/eliminar")
	public ResponseEntity<String> eliminarEnfermera(int id){
		return new ResponseEntity<>(enfermeraService.delete(id),HttpStatus.OK);
	}
	
	

}
