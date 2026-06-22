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
	@DisplayName("Validación largo de rut")
	void validarLargoRut() {
		Usuario usuario = usuarioService.buscarPorId("US0001");
		log.info("Validando largo de rut de usuario {}", usuario.getPnombreUsuario()+ usuario.getAppaternoUsuario());
		assertEquals(10,usuario.getRunUsuario().length());

	}
}
