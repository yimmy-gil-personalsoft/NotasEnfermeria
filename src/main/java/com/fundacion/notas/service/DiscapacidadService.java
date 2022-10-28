package com.fundacion.notas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundacion.notas.dto.DiscapacidadDTO;
import com.fundacion.notas.entity.Discapacidad;
import com.fundacion.notas.repository.IDiscapacidadRepository;



@Service
public class DiscapacidadService {


	@Autowired
	private IDiscapacidadRepository iDiscapacidadRepository;
	
	public List<Discapacidad> getAll() {
		return (List<Discapacidad>) iDiscapacidadRepository.findAll();
	}
	
	public Optional<Discapacidad> getByDetail(int idDiscapacidad) {
		return iDiscapacidadRepository.findById(idDiscapacidad);
	}


	public Discapacidad save(Discapacidad discapacidad) {
		return iDiscapacidadRepository.save(discapacidad);
	}
	
	public Discapacidad update(int id, Discapacidad discapacidadRequest) {
		Discapacidad discapacidad = iDiscapacidadRepository.findById(id)
				.orElseThrow(null);
		discapacidad.setNombreDiscapacidad(discapacidadRequest.getNombreDiscapacidad());
		return iDiscapacidadRepository.save(discapacidad);
				
	}

	
	public String delete(String nombreDiscapacidad) {

		try {
			iDiscapacidadRepository.deleteByNombreDiscapacidad(nombreDiscapacidad);
			return "Discapacidad eliminada";
		} catch (Exception e) {
			return "Error: " + e;
		}

	}

}
