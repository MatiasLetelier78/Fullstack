package com.gym.Sucursal;

import com.gym.Sucursal.Model.Sucursal;
import com.gym.Sucursal.Service.SucursalService;
import com.netflix.discovery.converters.Auto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SucursalApplicationTests {

	@Autowired
	SucursalService sucursalService;

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("Insertar nueva Sucursal exitosamente")
	void testAgregarSucursal_Exito() {
		Sucursal nueva = new Sucursal();
		nueva.setIdSucursal("SUC999");
		nueva.setNombreSucursal("GYM Providencia");
		nueva.setDireccionSucursal("Avenida Siempre Viva 123");
		nueva.setComunaSucursal("Providencia");
		nueva.setTelefonoSucursal(912345678L);
		nueva.setCapacidadSucursal(150);

		Sucursal resultado = sucursalService.agregarSucursal(nueva);

		assertNotNull(resultado);

	}

}
