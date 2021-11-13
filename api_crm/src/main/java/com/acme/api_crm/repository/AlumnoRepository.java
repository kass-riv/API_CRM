package com.acme.api_crm.repository;
import com.acme.api_crm.model.Alumno;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Integer> {
    @Query(value = "SELECT o From Alumno o Where o.dni=?1")
    Optional<Alumno> findByNumero(String dni);
}