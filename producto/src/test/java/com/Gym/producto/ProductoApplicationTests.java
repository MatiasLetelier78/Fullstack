package com.Gym.producto;

import com.Gym.producto.Model.Producto;
import com.Gym.producto.Service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ProductoApplicationTests {

	@Autowired
	ProductoService productoService;

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("Revisando el id del producto")
	void checkId() {
		Producto producto = productoService.buscarPorId("PRD001");
		log.info("Revisando el id del producto: {}", producto.getIdProducto());
		assertEquals("PRD001", producto.getIdProducto());
		assertEquals("Proteina Whey 1kg", producto.getNombreProducto());
	}

	@Test
	@DisplayName("Revisando el stock del producto")
	void checkStock() {
		Producto producto = new Producto();
		producto.setStockProducto(50);
		log.info("Revisando el stock del producto: {}", producto.getStockProducto());
		assertEquals(50, producto.getStockProducto());
	}

	@Test
	@DisplayName("Revisando la categoria del producto")
	void checkCategoria() {
		Producto producto = new Producto();
		producto.setCategoriaProducto("Suplemento");
		producto.setPrecioProducto(35000);
		log.info("Revisando la categoria del producto: {}", producto.getCategoriaProducto());
		assertEquals("Suplemento", producto.getCategoriaProducto());
		assertEquals(35000, producto.getPrecioProducto());
	}
}