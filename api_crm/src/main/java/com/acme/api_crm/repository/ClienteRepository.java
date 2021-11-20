package com.acme.api_crm.repository;

import com.acme.api_crm.model.Cliente;
import com.acme.api_crm.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface  ClienteRepository extends JpaRepository<Cliente, Integer>{


    @Query(value = "SELECT o FROM Cliente o WHERE o.user=?1")
    Cliente findByUsuario(Usuario user);
    
}
