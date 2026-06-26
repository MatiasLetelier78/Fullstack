package com.Gym.ejercicio;

import com.Gym.ejercicio.Model.Ejercicio;
import com.Gym.ejercicio.Service.EjercicioService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class EjercicioApplicationTests {

	@Autowired
	EjercicioService ejercicioService;

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("Revisando el id del ejercicio")
	void checkId() {
		Ejercicio ejercicio = ejercicioService.buscarPorId("EJE001");
		log.info("Revisando el id del ejercicio: {}", ejercicio.getIdEjercicio());
		assertEquals("EJE001", ejercicio.getIdEjercicio());
		assertEquals("Press Banca", ejercicio.getNombreEjercicio());
	}

	@Test
	@DisplayName("Revisando las series del ejercicio")
	void checkSeries() {
		Ejercicio ejercicio = new Ejercicio();
		ejercicio.setSeries(4);
		log.info("Revisando las series del ejercicio: {}", ejercicio.getSeries());
		assertEquals(4, ejercicio.getSeries());
	}

	@Test
	@DisplayName("Revisando las repeticiones del ejercicio")
	void checkRepeticiones() {
		Ejercicio ejercicio = new Ejercicio();
		ejercicio.setRepeticiones(12);
		ejercicio.setDuracionMinutosEjercicio(30);
		log.info("Revisando las repeticiones del ejercicio: {}", ejercicio.getRepeticiones());
		assertEquals(12, ejercicio.getRepeticiones());
		assertEquals(30, ejercicio.getDuracionMinutosEjercicio());
	}
}