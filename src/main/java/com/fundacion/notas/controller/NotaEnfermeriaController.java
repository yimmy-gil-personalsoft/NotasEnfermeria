package com.fundacion.notas.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Response;
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

import com.fundacion.notas.dto.NotaEnfermeriaDTO;
import com.fundacion.notas.entity.NotaEnfermeria;
import com.fundacion.notas.service.NotaEnfermeriaService;

@RestController
@RequestMapping("/api/notaEnfermeria")
public class NotaEnfermeriaController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private NotaEnfermeriaService notaEnfermeriaService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<NotaEnfermeriaDTO>> listarNotas(){
		return new ResponseEntity<>(notaEnfermeriaService.getAll()
				.stream().map(nota -> modelMapper.map(nota,NotaEnfermeriaDTO.class))
				.collect(Collectors.toList()),HttpStatus.OK);
	}
	
	@GetMapping("/detalle")
	public ResponseEntity<Optional<NotaEnfermeria>> detalleNota(int id){
		Optional<NotaEnfermeria> nota = notaEnfermeriaService.detail(id);
		NotaEnfermeriaDTO notaResponse = modelMapper.map(nota, NotaEnfermeriaDTO.class);
		return ResponseEntity.ok().body(nota);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<NotaEnfermeriaDTO> guardarNota(@RequestBody NotaEnfermeriaDTO notaEnfermeriaDTO){
		NotaEnfermeria notaRequest = modelMapper.map(notaEnfermeriaDTO, NotaEnfermeria.class);
		NotaEnfermeria notaEnfermeria = notaEnfermeriaService.save(notaRequest);
		NotaEnfermeriaDTO notaResponse = modelMapper.map(notaEnfermeria, NotaEnfermeriaDTO.class);
		return new ResponseEntity<NotaEnfermeriaDTO>(notaResponse,HttpStatus.OK);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<NotaEnfermeriaDTO> actualizarNota(int id, @RequestBody NotaEnfermeriaDTO notaEnfermeriaDTO){
		NotaEnfermeria notaRequest = modelMapper.map(notaEnfermeriaDTO, NotaEnfermeria.class);
		NotaEnfermeria nota = notaEnfermeriaService.update(id, notaRequest);
		NotaEnfermeriaDTO notaResponse = modelMapper.map(nota, NotaEnfermeriaDTO.class);
		return ResponseEntity.ok().body(notaResponse);
	}

	@DeleteMapping("/eliminar")
	public ResponseEntity<String> eliminarNota(int id){
		return new ResponseEntity<>(notaEnfermeriaService.delete(id),HttpStatus.OK);
	}
	
	
}
