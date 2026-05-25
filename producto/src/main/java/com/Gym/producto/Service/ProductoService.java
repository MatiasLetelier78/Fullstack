package com.Gym.producto.Service;

import com.Gym.producto.Model.Producto;
import com.Gym.producto.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Producto buscarPorId(String id) {
        return productoRepository.findById(id).orElse(null);
    }

    public List<Producto> buscarPorSucursal(String idSucursal) {
        return productoRepository.findByIdSucursal(idSucursal);
    }

    public List<Producto> buscarPorProveedor(String idProveedor) {
        return productoRepository.findByIdProveedor(idProveedor);
    }

    public Producto agregarProducto(Producto nuevo) {
        return productoRepository.save(nuevo);
    }

    public boolean borrarProducto(String id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Producto actualizarProducto(String id, Producto nuevo) {
        if (productoRepository.existsById(id)) {
            Producto producto = productoRepository.findById(id).get();
            producto.setNombreProducto(nuevo.getNombreProducto());
            producto.setPrecioProducto(nuevo.getPrecioProducto());
            producto.setStockProducto(nuevo.getStockProducto());
            producto.setCategoriaProducto(nuevo.getCategoriaProducto());
            producto.setIdSucursal(nuevo.getIdSucursal());
            producto.setIdProveedor(nuevo.getIdProveedor());
            productoRepository.save(producto);
            return producto;
        } else {
            return null;
        }
    }
}