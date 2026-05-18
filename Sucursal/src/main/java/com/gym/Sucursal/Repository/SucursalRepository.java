package com.gym.Sucursal.Repository;

import com.gym.Sucursal.Model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, String>{
    Sucursal findByIdSucursal(String idSucursal);
    Sucursal findByNombreSucursal(String nombreSucursal);

}
