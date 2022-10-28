package com.fundacion.notas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fundacion.notas.entity.Enfermera;

@Repository
public interface IEnfermeraRepository extends CrudRepository<Enfermera, Integer>{

}
