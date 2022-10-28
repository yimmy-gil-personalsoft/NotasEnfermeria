package com.fundacion.notas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundacion.notas.entity.Enfermera;
import com.fundacion.notas.repository.IEnfermeraRepository;

@Service
public class EnfermeraService {
	
	@Autowired
	private IEnfermeraRepository iEnfermeraRepository;
	
	public List<Enfermera> getAll(){
		return (List<Enfermera>) iEnfermeraRepository.findAll();
	}
	
	public Enfermera save(Enfermera enfermera) {
		return iEnfermeraRepository.save(enfermera);
	}
	
	public Enfermera update(int id, Enfermera enfermera) {
		Enfermera enfermeraRequest = iEnfermeraRepository.findById(id)
				.orElseThrow(null);
		enfermeraRequest.setNombre(enfermera.getNombre());
		enfermeraRequest.setApellido(enfermera.getApellido());
		enfermeraRequest.setCorreo(enfermera.getCorreo());
		enfermeraRequest.setTelefono(enfermera.getTelefono());
		return iEnfermeraRepository.save(enfermeraRequest);
	}
	
	public Optional<Enfermera> getByDetail(int id) {
		return iEnfermeraRepository.findById(id);
	}
	
	public String delete(int id) {
		try {
			iEnfermeraRepository.deleteById(id);
			return "Enfermera eliminada";
		} catch (Exception e) {
			return "Error"+e;
		}
	}

}
