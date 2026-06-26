package com.gym.Empleado;

import com.gym.Empleado.Model.Empleado;
import com.gym.Empleado.Service.EmpleadoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class EmpleadoApplicationTests {

	@Autowired
    EmpleadoService empleadoService;

	@Test
	void contextLoads() {
	}
	@Test
	@DisplayName("Insertar nuevo Empleado exitosamente")
	void testAgregarEmpleado_Exito() {
		Empleado nuevo = new Empleado();
		nuevo.setIdUsuario("US0001");
		nuevo.setEspecialidadEmpleado("Musculación y Peso Libre");
		nuevo.setCargoEmpleado("Entrenador Personal");
		nuevo.setFechaContratoEmp(java.time.LocalDate.now());
		nuevo.setIdSucursal("SUC001");

		Empleado resultado = empleadoService.agregarEmpleado(nuevo);

		assertNotNull(resultado);
	}

}
