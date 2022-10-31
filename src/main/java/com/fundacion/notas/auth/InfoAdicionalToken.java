package com.fundacion.notas.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.fundacion.notas.entity.Usuario;
import com.fundacion.notas.service.UsuarioService;



@Component
public class InfoAdicionalToken implements TokenEnhancer{
	
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Usuario usuario = usuarioService.findByUserName(authentication.getName());
		Map<String, Object> info = new HashMap<String, Object>();
		info.put("info adicional", "Hola: ".concat(authentication.getName()));
		info.put("Nombre", usuario.getNombre());
		info.put("Apellido", usuario.getApellido());
		info.put("email", usuario.getEmail());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return accessToken;
	}

}
