package org.example.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
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

    public Tipo() {
    }

    public Tipo(int id, String tipoAuto, int capacidad, String descripcion, Date fechaAlta) {
        this.id = id;
        this.tipoAuto = tipoAuto;
        this.capacidad = capacidad;
        this.descripcion = descripcion;
        this.fechaAlta = fechaAlta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoAuto() {
        return tipoAuto;
    }

    public void setTipoAuto(String tipoAuto) {
        this.tipoAuto = tipoAuto;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
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

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "id=" + id +
                ", tipoAuto='" + tipoAuto + '\'' +
                ", capacidad=" + capacidad +
                ", descripcion='" + descripcion + '\'' +
                ", fechaAlta=" + fechaAlta +
                ", modelos=" + modelos +
                '}';
    }
}
