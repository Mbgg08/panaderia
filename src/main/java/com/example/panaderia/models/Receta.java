package com.example.panaderia.models;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;
@Entity
@Table(name = "receta")
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recetaId;
    @ManyToOne
    @JoinColumn(name = "productoId")
    private Producto productoId;
    @ManyToOne
    @JoinColumn(name = "insumoId")
    private Insumo insumoId;
    public Long getRecetaId() {
        return recetaId;
    }
    public void setRecetaId(Long recetaId) {
        this.recetaId = recetaId;
    }
    public Producto getProductoId() {
        return productoId;
    }
    public void setProductoId(Producto productoId) {
        this.productoId = productoId;
    }
    public Insumo getInsumoId() {
        return insumoId;
    }
    public void setInsumoId(Insumo insumoId) {
        this.insumoId = insumoId;
    }
}
