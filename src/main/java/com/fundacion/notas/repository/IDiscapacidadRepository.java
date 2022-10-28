package com.fundacion.notas.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fundacion.notas.dto.DiscapacidadDTO;
import com.fundacion.notas.entity.Discapacidad;

@Repository
public interface IDiscapacidadRepository extends CrudRepository<Discapacidad, Integer>{
	
	@Transactional
	public Optional<DiscapacidadDTO> deleteByNombreDiscapacidad (String nombreDiscapacidad);
		
}
