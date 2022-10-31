package com.fundacion.notas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundacion.notas.entity.Usuario;
import com.fundacion.notas.repository.IUsuarioDao;


@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
	IUsuarioDao usuarioDao;
	
	@Autowired
	@Lazy
	private BCryptPasswordEncoder encoder;
	
	//@PreAuthorize("hasAuthority('SUPER') or hasAuthority('ADMIN')")
	public Usuario findByUserName(String userName) {
		return usuarioDao.findByUserName(userName).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao.findByUserName(username).orElse(null);
		if(usuario == null) {
			throw new UsernameNotFoundException("Error no existe el usuario");
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(usuario.getRole()));
		return new User(usuario.getUserName(), usuario.getPassword(), true, true, true, true, authorities);
	}
	
	public ResponseEntity<Object> agregarUsuario(Usuario usuario){
		ResponseEntity<Object> respuesta;
		try {
			usuario.setPassword(encoder.encode(usuario.getPassword()));
			usuarioDao.save(usuario);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(usuario,HttpStatus.OK);
		} catch (Exception e) {
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Error creando usuario",HttpStatus.BAD_REQUEST);
		}
		return respuesta;
	}

}
