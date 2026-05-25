package com.Gym.clase.Repository;

import com.Gym.clase.Model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ClaseRepository extends JpaRepository<Clase, String> {
    List<Clase> findByIdSucursal(String idSucursal);
}
