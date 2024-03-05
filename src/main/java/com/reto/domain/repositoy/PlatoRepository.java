package com.reto.domain.repositoy;

import com.reto.persistence.entity.Plato;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoRepository extends JpaRepository<Plato, Long> {
    @Query("SELECT p FROM Plato p WHERE lower(trim(p.nombrePlato)) = lower(trim(:nombrePlato))")
    List<Plato> buscar_x_nombre(@Param("nombrePlato")  String nombrePlato);
}

