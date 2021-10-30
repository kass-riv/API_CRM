package com.reporalum.demoweb.repository;

import com.reporalum.demoweb.model.Pago;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  PagoRepository extends JpaRepository<Pago, Integer>{

    
}
