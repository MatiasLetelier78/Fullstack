package com.Gym.clase;

import com.Gym.clase.Model.Clase;
import com.Gym.clase.Service.ClaseService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ClaseApplicationTests {

	@Autowired
	ClaseService claseService;

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("Revisando el id de la clase")
	void checkId() {
		Clase clase = claseService.findByIdClase("CLA001");
		log.info("Revisando el id de la clase: {}", clase.getIdClase());
		assertEquals("CLA001", clase.getIdClase());
		assertEquals("Spinning", clase.getNombreClase());
	}

	@Test
	@DisplayName("Revisando la capacidad de la clase")
	void checkCapacidad() {
		Clase clase = new Clase();
		log.info("Revisando la capacidad de la clase: {}", clase.getCapacidadClase());
		clase.setCapacidadClase(20);
		assertEquals(20, clase.getCapacidadClase());
	}

	@Test
	@DisplayName("Revisando el horario de la clase")
	void checkHorario() {
		Clase clase = new Clase();
		clase.setHorarioClase(LocalDate.of(2024, 5, 20));
		clase.setHoraInicioClase(LocalTime.of(8, 0));
		clase.setHoraTerminoClase(LocalTime.of(9, 0));
		log.info("Revisando el horario de la clase: {}", clase.getHorarioClase());
		assertEquals(LocalDate.of(2024, 5, 20), clase.getHorarioClase());
		assertEquals(LocalTime.of(8, 0), clase.getHoraInicioClase());
		assertEquals(LocalTime.of(9, 0), clase.getHoraTerminoClase());
	}
}