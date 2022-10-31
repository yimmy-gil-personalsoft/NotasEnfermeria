package com.fundacion.notas.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fundacion.notas.entity.Usuario;

@Repository
public interface IUsuarioDao extends CrudRepository<Usuario, Integer>{

	public Optional<Usuario> findByUserName(String userName);
}
