package org.example.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="tipo_autos")
public class Tipo {
    @Id
    @Column(name = "IdTipoAuto")
    private int id;

    @Column(name = "TipoAuto")
    private String tipoAuto;

    @Column(name = "Capacidad")
    private int capacidad;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "FechaAlta")
    private Date fechaAlta;

    @OneToMany(mappedBy = "tipo")
    private List<Modelo> modelos;


}
