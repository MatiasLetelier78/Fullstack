package com.gym.Asistencia;

import com.gym.Asistencia.Model.Asistencia;
import com.gym.Asistencia.Service.AsistenciaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class AsistenciaApplicationTests {
	@Autowired

    AsistenciaService asistenciaService;

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("Insertar nueva Asistencia exitosamente")
	void testAgregarAsistencia_Exito() {
		Asistencia nueva = new Asistencia();
		nueva.setIdAsistencia("AS0999");
		nueva.setFechaAsistencia(java.time.LocalDate.now());
		nueva.setHoraEntrada(java.time.LocalTime.of(10, 30));
		nueva.setHoraSalida(java.time.LocalTime.of(12, 00));

		nueva.setIdUsuario("US0001");
		nueva.setIdSucursal("SUC001");

		Asistencia resultado = asistenciaService.addAsistencia(nueva);

		assertNotNull(resultado);

	}

}
