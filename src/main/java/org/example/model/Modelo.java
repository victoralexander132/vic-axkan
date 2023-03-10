package org.example.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="modelos")
public class Modelo {
    @Id
    @Column(name = "IdModelo")
    private int id;

    @Column(name = "Modelo")
    private String modelo;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "FechaAlta")
    private Date fechaAlta;

    @ManyToOne
    @JoinColumn(nullable = false, name = "IdMarca")
    private Marca marca;

    @ManyToOne
    @JoinColumn(nullable = false, name = "IdTipoAuto")
    private Tipo tipo;

}
