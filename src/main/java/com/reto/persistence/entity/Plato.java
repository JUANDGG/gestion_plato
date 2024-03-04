package com.reto.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "plato")
@Getter @Setter
public class Plato {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "id_plato" ,nullable = false,columnDefinition = "BIGINT")
    private long idPlato ;

    @Column(name = "nombre_plato" ,nullable = false,columnDefinition = "VARCHAR(50)",unique = true)
    private String nombrePlato ;

    @Column(name = "descripcion" ,nullable = false,columnDefinition = "VARCHAR(150)")
    private String descripcion ;

    @Column(name = "precio" ,nullable = false,columnDefinition = "DOUBLE")
    private double precio ;



}
