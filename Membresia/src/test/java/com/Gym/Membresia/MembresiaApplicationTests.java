package com.Gym.Membresia;

import com.Gym.Membresia.Modelo.Membresia;
import com.Gym.Membresia.Service.MembresiaService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class MembresiaApplicationTests {
	@Autowired
	MembresiaService membresiaService ;
	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("Revisando el codigo de la membresia")
	void checkCode(){
		Membresia membresia = membresiaService.buscarMembresiaPorId("MEM001");
		log.info("Revisando el codigo de la membresia: {}", membresia.getIdMembresia());
		assertEquals("MEM001", membresia.getIdMembresia());
		assertEquals("Plan Basico", membresia.getNombreMembresia());
		assertEquals("Acceso a sala de pesas y cardio", membresia.getDescripcionMembresia());
	}

	@Test
	@DisplayName("Revisando el valor de la membresia")
	void checkValue(){
		Membresia membresia = new Membresia();
		log.info("Revisando el valor de la membresia: {}", membresia.getPrecioMembresia());
		membresia.setPrecioMembresia(BigDecimal.valueOf(29990.0));
		assertEquals(BigDecimal.valueOf(29990.0), membresia.getPrecioMembresia());
	}
	@Test
	@DisplayName("Revisando el estado de la membresia")
	void checkState(){
		Membresia membresia = new Membresia();
		log.info("Revisando el estado de la membresia: {}", membresia.getEstadoMembresia());
		membresia.setEstadoMembresia(true);
		assertTrue(membresia.getEstadoMembresia());
	}



}
