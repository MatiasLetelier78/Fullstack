package com.gym.Usuario;

import com.gym.Usuario.model.Usuario;
import com.gym.Usuario.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest

class UsuarioApplicationTests {

	@Autowired
	private UsuarioService usuarioService;

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("Test de agregado de nuevo usuario fallido por duplicación de ID")
	void insertarUsuario() {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario("US0005");
		usuario.setRunUsuario("20455854-1");
		usuario.setEmailUsuario("sdfkjhs@gmail.com");
		usuario.setAppaternoUsuario("Gonzalez");
		usuario.setApmaternoUsuario("Lopez");
		usuario.setPasswordUsuario("12423423");
		usuario.setPnombreUsuario("Valentina");
		usuario.setSnombreUsuario("Fernanda");
		usuario.setFechaNacimientoUsuario(java.time.LocalDate.of(2000, 1, 1));
		usuario.setRolUsuario("CLIENTE");
		usuario.setTelefonoUsuario(987654321L);

		Usuario nuevo = usuarioService.agregarUsuario(usuario);
		assertNull(nuevo);

	}

	@Test
	@DisplayName("Validar Largo Rut")
	void validarLargoRut() {
		Usuario usuario = usuarioService.buscarPorId("US0005");
		assertEquals(10,usuario.getRunUsuario().length());
	}

	@Test
	@DisplayName("Validar cantidad de usuarios")
	void validarCantidadUsuarios() {
		int cantidad = usuarioService.listarUsuarios().size();
		assertEquals(6,cantidad);
	}



	@Test
	@DisplayName("Validación nombre correcto")
	void validarNombreCorrectoYFechaNula() {
		Usuario usuario = usuarioService.buscarPorId("US0007");
		log.info("Validando nombre correcto");
		assertEquals("Javiera",usuario.getPnombreUsuario());
	}
}
