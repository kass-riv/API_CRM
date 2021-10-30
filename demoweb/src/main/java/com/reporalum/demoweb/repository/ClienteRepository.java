package com.reporalum.demoweb.repository;

import com.reporalum.demoweb.model.Cliente;
import com.reporalum.demoweb.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface  ClienteRepository extends JpaRepository<Cliente, Integer>{


    @Query(value = "SELECT o FROM Cliente o WHERE o.user=?1")
    Cliente findByUsuario(Usuario user);
    
}
