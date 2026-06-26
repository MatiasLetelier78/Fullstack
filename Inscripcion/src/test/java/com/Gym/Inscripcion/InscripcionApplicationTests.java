package com.Gym.Inscripcion;

import com.Gym.Inscripcion.Model.Inscripcion;
import com.Gym.Inscripcion.Service.InscripcionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Slf4j
@SpringBootTest
class InscripcionApplicationTests {
	@Autowired
	InscripcionService inscripcionService;
	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("Revisando la busqueda por codigo")
	void checkCode() {
		Inscripcion inscripcion = new Inscripcion();
		inscripcion.setIdUsuario("USU001");
		inscripcion.setIdClase("CLASE001");
		assertEquals("USU001", inscripcion.getIdUsuario());
		assertEquals("CLASE001", inscripcion.getIdClase());
	}
}