package com.example.panaderia.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Insumo")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Insumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long insumoId;

    @Column(name = "nombreInsumo")
    private String nombreIns;

    @Column(name = "stockIns")
    private int stockIns;

    @Column(name = "precio")
    private float precio;

    @Column(name = "unidad")
    private String unidad;

    @Column(name = "marca")
    private String marca;

    public Long getInsumoId() {
        return insumoId;
    }

    public void setInsumoId(Long insumoId) {
        this.insumoId = insumoId;
    }

    public String getNombreIns() {
        return nombreIns;
    }

    public void setNombreIns(String nombreIns) {
        this.nombreIns = nombreIns;
    }

    public int getStockIns() {
        return stockIns;
    }

    public void setStockIns(int stockIns) {
        this.stockIns = stockIns;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
