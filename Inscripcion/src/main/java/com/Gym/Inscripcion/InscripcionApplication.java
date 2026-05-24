package com.Gym.Inscripcion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class InscripcionApplication {

	public static void main(String[] args) {
		SpringApplication.run(InscripcionApplication.class, args);
	}

}
