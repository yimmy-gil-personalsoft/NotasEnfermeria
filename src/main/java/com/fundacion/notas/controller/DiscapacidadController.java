package com.fundacion.notas.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

import com.fundacion.notas.dto.DiscapacidadDTO;
import com.fundacion.notas.entity.Discapacidad;
import com.fundacion.notas.service.DiscapacidadService;

@RestController
@RequestMapping("/api/discapacidad")
public class DiscapacidadController {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired(required=false)
	private DiscapacidadService discapacidadService;
	
	
	
	@GetMapping("/listar")
	public ResponseEntity<List<DiscapacidadDTO>> obtenerDiscapacidades(){
		return new ResponseEntity<>(discapacidadService.getAll().stream()
				.map(discapacidad -> modelMapper.map(discapacidad,DiscapacidadDTO.class))
				.collect(Collectors.toList()),HttpStatus.OK);
	}
	
	
	@GetMapping("/detalle")
	public ResponseEntity<Optional<Discapacidad>> discapacidadDetalle(int idDiscapacidad) {
		
		Optional<Discapacidad> discapacidad = discapacidadService.getByDetail(idDiscapacidad);
		DiscapacidadDTO discapacidadResponse = modelMapper.map(discapacidad,DiscapacidadDTO.class);
		return ResponseEntity.ok().body(discapacidad);
		//return discapacidadResponse;
		

		/*return discapacidadService.getByDetail(idDiscapacidad)
				.map(discapacidad -> new ResponseEntity<>(discapacidad,HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));*/
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<DiscapacidadDTO> guardar(@RequestBody DiscapacidadDTO discapacidadDTO) {
		//return new ResponseEntity<>(discapacidadService.save(discapacidad), HttpStatus.CREATED);
		Discapacidad discapacidadRequest = modelMapper.map(discapacidadDTO, Discapacidad.class);
		Discapacidad discapacidad = discapacidadService.save(discapacidadRequest);
		DiscapacidadDTO discapacidadResponse = modelMapper.map(discapacidad, DiscapacidadDTO.class);
		return new ResponseEntity<DiscapacidadDTO>(discapacidadResponse,HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<DiscapacidadDTO> updateDiscapacidad(int id, @RequestBody DiscapacidadDTO discapacidadDTO){
		Discapacidad discapacidadRequest = modelMapper.map(discapacidadDTO, Discapacidad.class);
		Discapacidad discapacidad = discapacidadService.update(id, discapacidadRequest);
		DiscapacidadDTO postResponse = modelMapper.map(discapacidad, DiscapacidadDTO.class);
		return ResponseEntity.ok().body(postResponse);
	}
	
	@DeleteMapping("/eliminar")
	public ResponseEntity<String> eliminar(String nombreDiscapacidad){
		return new ResponseEntity<>(discapacidadService.delete(nombreDiscapacidad),HttpStatus.OK);
	}

}
