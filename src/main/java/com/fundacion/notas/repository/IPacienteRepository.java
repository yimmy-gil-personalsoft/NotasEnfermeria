package com.fundacion.notas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fundacion.notas.entity.Paciente;

@Repository
public interface IPacienteRepository extends CrudRepository<Paciente, Integer>{

}
