package com.fundacion.notas;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FundacionNotasApplication implements CommandLineRunner{
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(FundacionNotasApplication.class, args);
	}

	@Override
	public void run(String... args) {
		String password = "12345";
		for(int i= 0; i<4; i++) {
			String passwordEncode = passwordEncoder.encode(password);
			System.out.println(passwordEncode);
		}
	}
	
}
