package org.example.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="marcas")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdMarca")
    private int id;

    @Column(name = "Marca")
    private String marca;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "FechaAlta")
    private Date fechaAlta;

    @OneToMany(mappedBy = "marca")
    private List<Modelo> modelos;

}
