package com.acme.api_crm.repository;
import com.acme.api_crm.model.Alumno;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Integer> {
    @Query(value = "SELECT o From Alumno o Where o.dni=?1")
    Optional<Alumno> findByNumero(String dni);

    @Query(value = "SELECT o FROM Alumno o WHERE o.sexo='M'")
    List<Alumno> getAllActiveProductos();

    @Query(value = "SELECT o From Alumno o Where o.sexo='M'")
    List<Map<String, Object>> queryCarreras();
}