package com.acme.api_crm.repository;
import java.util.List;
import java.util.Optional;

import com.acme.api_crm.model.Producto;
import com.acme.api_crm.model.Proforma;
import com.acme.api_crm.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProformaRepository extends JpaRepository<Proforma, Integer>{
    
    @Query(value = "SELECT o FROM Proforma o WHERE o.user=?1 And o.status='PENDING'")
    List<Proforma> findItemsByUsuario(Usuario user);

    @Query(value = "SELECT o FROM Proforma o WHERE o.user=?1 And o.product=?2 And o.status='PENDING'")
    Optional<Proforma> findProformaByUsuarioAndProducto(Usuario user, Producto product);
}