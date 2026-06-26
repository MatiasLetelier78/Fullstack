package com.Gym.producto.Controller;

import com.Gym.producto.Model.Producto;
import com.Gym.producto.Service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
@Tag(name="API Productos",description = "API para la gestión de productos")

public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    @Operation(summary = "Obtener todos los productos", description = "Endpoint permite consultar todos los productos")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa, se entrega lista de productos")
    @ApiResponse(responseCode = "204", description = "consulta exitosa, pero no se encontraron productos")

    public ResponseEntity<List<Producto>> getAllProductos() {
        List<Producto> listado = productoService.listarProductos();
        if (listado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listado, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar producto por ID", description = "Retorna los datos de un producto específico según su ID interno.")
    @ApiResponse(responseCode = "200", description = "producto encontrado")
    @ApiResponse(responseCode = "404", description = "producto no encontrado")

    public ResponseEntity<Producto> getProductoById(@PathVariable String id) {
        Producto buscado = productoService.buscarPorId(id);
        if (buscado != null) {
            return new ResponseEntity<>(buscado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/sucursal/{idSucursal}")
    @Operation(summary = "Buscar producto por sucursal", description = "Permite localizar a un producto utilizando la sucursal.")
    @ApiResponse(responseCode = "200", description = "producto encontrado")
    @ApiResponse(responseCode = "404", description = "producto no encontrado")

    public ResponseEntity<List<Producto>> getProductosBySucursal(@PathVariable String idSucursal) {
        List<Producto> listado = productoService.buscarPorSucursal(idSucursal);
        if (listado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listado, HttpStatus.OK);
        }
    }

    @GetMapping("/proveedor/{idProveedor}")
    @Operation(summary = "Buscar producto por proveedor", description = "Permite localizar a un producto utilizando el proveedor.")
    @ApiResponse(responseCode = "200", description = "producto encontrado")
    @ApiResponse(responseCode = "404", description = "producto no encontrado")

    public ResponseEntity<List<Producto>> getProductosByProveedor(@PathVariable String idProveedor) {
        List<Producto> listado = productoService.buscarPorProveedor(idProveedor);
        if (listado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listado, HttpStatus.OK);
        }
    }

    @PostMapping("/")
    @Operation(summary = "Crear nuevo producto", description = "Registra un nuevo producto en la base de datos validando que el ID no exista previamente.")
    @ApiResponse(responseCode = "201", description = "producto creado exitosamente")
    @ApiResponse(responseCode = "400", description = "Datos inválidos o el producto ya existe")

    public ResponseEntity<Producto> createProducto(@RequestBody @Valid Producto producto) {
        Producto nuevo = productoService.agregarProducto(producto);
        if (nuevo != null) {
            return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un producto", description = "Borra un producto del sistema utilizando su ID.")
    @ApiResponse(responseCode = "200", description = "producto eliminado correctamente")
    @ApiResponse(responseCode = "400", description = "Error al intentar eliminar el producto (ID no existe)")

    public ResponseEntity<Void> deleteProducto(@PathVariable String id) {
        boolean res = productoService.borrarProducto(id);
        if (res) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar datos del producto", description = "Actualiza la información personal de un producto existente por su ID.")
    @ApiResponse(responseCode = "200", description = "producto actualizado exitosamente")
    @ApiResponse(responseCode = "400", description = "El producto no existe o los datos enviados no son válidos")

    public ResponseEntity<Producto> updateProducto(@PathVariable String id, @RequestBody @Valid Producto nuevo) {
        Producto actualizado = productoService.actualizarProducto(id, nuevo);
        if (actualizado != null) {
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}