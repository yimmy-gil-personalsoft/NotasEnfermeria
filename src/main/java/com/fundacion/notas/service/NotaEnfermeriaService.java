package com.fundacion.notas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundacion.notas.entity.NotaEnfermeria;
import com.fundacion.notas.repository.INotaEnfermeriaRepository;

@Service
public class NotaEnfermeriaService {
	
	@Autowired
	private INotaEnfermeriaRepository iNotaEnfermeriaRepositorio;
	
	
	public List<NotaEnfermeria> getAll() {
		return (List<NotaEnfermeria>) iNotaEnfermeriaRepositorio.findAll();
	}
	
	public Optional<NotaEnfermeria> detail(int id) {
		return iNotaEnfermeriaRepositorio.findById(id);
	}
	
	public NotaEnfermeria save(NotaEnfermeria notaEnfermeria) {
		return iNotaEnfermeriaRepositorio.save(notaEnfermeria);
	}
	
	public NotaEnfermeria update(int id, NotaEnfermeria notaEnfermeria) {
		NotaEnfermeria nota = iNotaEnfermeriaRepositorio.findById(id).orElseThrow(null);
		nota.setEnfermera(notaEnfermeria.getEnfermera());
		nota.setFecha(notaEnfermeria.getFecha());
		nota.setHora(notaEnfermeria.getHora());
		nota.setNota(notaEnfermeria.getNota());
		nota.setPaciente(notaEnfermeria.getPaciente());
		return iNotaEnfermeriaRepositorio.save(nota);
	}
	
	public String delete(int id) {
		try {
			iNotaEnfermeriaRepositorio.deleteById(id);
			return "Nota Eliminada";
		} catch (Exception e) {
			return "Error: "+e;
		}

	}

}
