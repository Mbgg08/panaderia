package com.example.panaderia.models;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "comprobante")
public class Comprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comprobanteId;

    @Column(name = "fechaEmision")
    private LocalDateTime fechaEmision = LocalDateTime.now();

    @Column(name = "montoTotal")
    private double montoTotal;

    @ManyToOne
    @JoinColumn(name = "empleadoId")
    private Empleado empleadoId;

    @ManyToOne
    @JoinColumn(name = "clienteId")
    private Cliente clienteId;
    public Long getComprobanteId() {
        return comprobanteId;
    }
    public void setComprobanteId(Long comprobanteId) {
        this.comprobanteId = comprobanteId;
    }
    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }
    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
    public double getMontoTotal() {
        return montoTotal;
    }
    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
    public Empleado getEmpleadoId() {
        return empleadoId;
    }
    public void setEmpleadoId(Empleado empleadoId) {
        this.empleadoId = empleadoId;
    }
    public Cliente getClienteId() {
        return clienteId;
    }
    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }
}
