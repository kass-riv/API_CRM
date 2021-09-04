package com.acme.api_crm.repository;
import com.acme.api_crm.model.Alumno;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Integer> {


}