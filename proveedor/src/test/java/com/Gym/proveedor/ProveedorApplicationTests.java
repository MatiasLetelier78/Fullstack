package com.Gym.proveedor;

import com.Gym.proveedor.Model.Proveedor;
import com.Gym.proveedor.Service.ProveedorService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ProveedorApplicationTests {

	@Autowired
	ProveedorService proveedorService;

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("Revisando el id del proveedor")
	void checkId() {
		Proveedor proveedor = proveedorService.buscarPorId("PRO001");
		log.info("Revisando el id del proveedor: {}", proveedor.getIdProveedor());
		assertEquals("PRO001", proveedor.getIdProveedor());
		assertEquals("FitSupplies", proveedor.getNombreProveedor());
	}

	@Test
	@DisplayName("Revisando el email del proveedor")
	void checkEmail() {
		Proveedor proveedor = new Proveedor();
		proveedor.setEmailProveedor("fit@gmail.com");
		log.info("Revisando el email del proveedor: {}", proveedor.getEmailProveedor());
		assertEquals("fit@gmail.com", proveedor.getEmailProveedor());
	}

	@Test
	@DisplayName("Revisando el tipo de servicio del proveedor")
	void checkTipoServicio() {
		Proveedor proveedor = new Proveedor();
		proveedor.setTipoServicio("Equipamiento");
		log.info("Revisando el tipo de servicio del proveedor: {}", proveedor.getTipoServicio());
		assertEquals("Equipamiento", proveedor.getTipoServicio());
	}
}
