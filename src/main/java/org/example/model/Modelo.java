package org.example.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
