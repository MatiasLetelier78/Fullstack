package com.Gym.proveedor.Repository;


import com.Gym.proveedor.Model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, String> {
    Proveedor findByRutProveedor(String rutProveedor);
}