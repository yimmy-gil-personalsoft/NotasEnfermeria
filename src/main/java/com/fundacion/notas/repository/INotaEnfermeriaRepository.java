package com.fundacion.notas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fundacion.notas.entity.NotaEnfermeria;

@Repository
public interface INotaEnfermeriaRepository extends JpaRepository<NotaEnfermeria, Integer>{

}
