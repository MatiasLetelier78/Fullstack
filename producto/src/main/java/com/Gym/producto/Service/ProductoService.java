package com.Gym.producto.Service;

import com.Gym.producto.Model.Producto;
import com.Gym.producto.Repository.ProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarProductos() {
        log.info("listando todos los productos");
        return productoRepository.findAll();
    }

    public Producto buscarPorId(String id) {
        log.info("buscando producto por id {}", id);
        return productoRepository.findById(id).orElse(null);
    }

    public List<Producto> buscarPorSucursal(String idSucursal) {
        log.info("buscando productos por sucursal {}", idSucursal);
        return productoRepository.findByIdSucursal(idSucursal);
    }

    public List<Producto> buscarPorProveedor(String idProveedor) {
        log.info("buscando productos por proveedor ");
        return productoRepository.findByIdProveedor(idProveedor);
    }

    public Producto agregarProducto(Producto nuevo) {
        try {
            if (productoRepository.existsById(nuevo.getIdProducto())) {
                log.error("el producto ya existe ");
                return null;
            }
            log.info("agregando producto {}", nuevo);
            return productoRepository.save(nuevo);
        } catch (Exception e) {
            log.error("error al agregar producto ");
            return null;
        }
    }

    public boolean borrarProducto(String id) {
        try {
            Producto producto = productoRepository.findById(id).orElse(null);
            if (producto != null) {
                log.info("eliminando producto ");
                productoRepository.delete(producto);
                return true;
            } else {
                log.error("producto no encontrado ");
                return false;
            }
        } catch (Exception e) {
            log.error("error al borrar producto ");
            throw new RuntimeException(e);
        }
    }

    public Producto actualizarProducto(String id, Producto nuevo) {
        try {
            Producto producto = productoRepository.findById(id).orElse(null);
            if (producto != null) {
                producto.setNombreProducto(nuevo.getNombreProducto());
                producto.setPrecioProducto(nuevo.getPrecioProducto());
                producto.setStockProducto(nuevo.getStockProducto());
                producto.setCategoriaProducto(nuevo.getCategoriaProducto());
                producto.setIdSucursal(nuevo.getIdSucursal());
                producto.setIdProveedor(nuevo.getIdProveedor());
                log.info("actualizando producto {}", id);
                productoRepository.save(producto);
                return producto;
            } else {
                log.error("producto no encontrado ");
                return null;
            }
        } catch (Exception e) {
            log.error("error al actualizar producto ");
            throw new RuntimeException(e);
        }
    }
}