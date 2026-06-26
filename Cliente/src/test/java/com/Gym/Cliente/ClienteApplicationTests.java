package com.Gym.Cliente;

import com.Gym.Cliente.Modelo.ClienteModelo;
import com.Gym.Cliente.Service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest
class ClienteApplicationTests {
	@Autowired
	ClienteService clienteService;
	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("Revisando el listado de clientes")
	void checkClientes(){
		ClienteModelo cliente = clienteService.buscarClientePorId("USU001");
		log.info("Revisando el cliente con id {}", cliente.getIdUsuario());
		assertEquals("USU001", cliente.getIdUsuario());
	}

}
