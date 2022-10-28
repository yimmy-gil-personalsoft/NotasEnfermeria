package com.fundacion.notas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundacion.notas.dto.NotaEnfermeriaPacienteEnfermeraDTO;
import com.fundacion.notas.service.NotaEnfermeriaPacienteEnfermeraDTOService;

@RestController
@RequestMapping("/api/historial")
public class NotaEnfermeriaPacienteEnfermeraController {
	
	@Autowired
	private NotaEnfermeriaPacienteEnfermeraDTOService notaEnfermeriaPacienteService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<NotaEnfermeriaPacienteEnfermeraDTO>> listarHistorial(){
		return new ResponseEntity<>(notaEnfermeriaPacienteService.getAllHistorial(),HttpStatus.OK);
	}

}
