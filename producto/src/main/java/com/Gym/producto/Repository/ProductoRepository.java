package com.Gym.producto.Repository;

import com.Gym.producto.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String> {
    List<Producto> findByIdSucursal(String idSucursal);
    List<Producto> findByIdProveedor(String idProveedor);
}