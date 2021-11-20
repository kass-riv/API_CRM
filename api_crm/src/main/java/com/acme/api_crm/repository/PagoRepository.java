package com.acme.api_crm.repository;

import com.acme.api_crm.model.Pago;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  PagoRepository extends JpaRepository<Pago, Integer>{

    
}
