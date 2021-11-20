package com.reporalum.demoweb.repository;
import com.reporalum.demoweb.model.Alumno;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Integer> {
    @Query(value = "SELECT o From Alumno o Where o.dni=?1")
    Optional<Alumno> findByNumero(String dni);

    @Query(value = "SELECT CAST(o.Dni AS text) AS dniReceptor FROM Egresado o GROUP BY o.Dni")
    List<Map<String, Object>> querySumaTotalByReceptor();
}