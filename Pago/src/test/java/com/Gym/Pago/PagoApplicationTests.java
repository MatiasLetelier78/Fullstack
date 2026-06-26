package com.Gym.Pago;

import com.Gym.Pago.Modelo.Pago;
import com.Gym.Pago.Service.PagoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Slf4j
@SpringBootTest
class PagoApplicationTests {
	@Autowired
	PagoService pagoService;
	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("Revisando el id del pago")
	void checkCode(){
		Pago pago = pagoService.findByIdPago("PAG001");
		log.info("Revisando el codigo del pago: {}", pago.getIdPago());
		assertEquals("PAG001", pago.getIdPago());
		assertEquals("Tarjeta", pago.getMetodoPago());
		assertEquals("Pagado", pago.getEstadoPago());
	}

	@Test
	@DisplayName("Revisando el monto del pago")
	void chechCodemonto(){
		Pago pago = pagoService.findByIdPago("PAG001");
		log.info("Revisando el codigo del pago: {}", pago.getMontoPago());
		assertEquals(29990, pago.getMontoPago());
	}

	@Test
	@DisplayName("Revisando la fecha del pago")
	void chechCodefecha(){
		Pago pago = pagoService.findByIdPago("PAG001");
		log.info("Revisando la fecha del pago: {}", pago.getFechaPago());
		assertEquals("2024-05-01", pago.getFechaPago().toString());
	}



}
