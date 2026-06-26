package com.Gym.rutina;

import com.Gym.rutina.Model.Rutina;
import com.Gym.rutina.Service.RutinaService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class RutinaApplicationTests {

	@Autowired
	RutinaService rutinaService;

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("Revisando el id de la rutina")
	void checkId() {
		Rutina rutina = rutinaService.buscarPorId("RUT001");
		log.info("Revisando el id de la rutina: {}", rutina.getIdRutina());
		assertEquals("RUT001", rutina.getIdRutina());
		assertEquals("Rutina Fuerza Upper", rutina.getNombreRutina());
	}

	@Test
	@DisplayName("Revisando el objetivo de la rutina")
	void checkObjetivo() {
		Rutina rutina = new Rutina();
		rutina.setObjetivoRutina("Hipertrofia");
		log.info("Revisando el objetivo de la rutina: {}", rutina.getObjetivoRutina());
		assertEquals("Hipertrofia", rutina.getObjetivoRutina());
	}

	@Test
	@DisplayName("Revisando la descripcion de la rutina")
	void checkDescripcion() {
		Rutina rutina = new Rutina();
		rutina.setDescripcionRutina("Rutina para ganar masa muscular en tren superior");
		log.info("Revisando la descripcion de la rutina: {}", rutina.getDescripcionRutina());
		assertEquals("Rutina para ganar masa muscular en tren superior", rutina.getDescripcionRutina());
	}
}