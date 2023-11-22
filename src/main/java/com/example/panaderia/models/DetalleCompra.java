package com.example.panaderia.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "DetalleCompra")
public class DetalleCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detalleCompraId;
    @ManyToOne
    @JoinColumn(name = "comprobanteId")
    private Comprobante comprobanteId;
    @ManyToOne
    @JoinColumn(name = "empleadoId")
    private Empleado empleadoId;
    @ManyToOne
    @JoinColumn(name = "clienteId")
    private Cliente clienteId;
    @ManyToOne
    @JoinColumn(name = "productoId")
    private Producto productoId;
    public Long getDetalleCompraId() {
        return detalleCompraId;
    }
    public void setDetalleCompraId(Long detalleCompraId) {
        this.detalleCompraId = detalleCompraId;
    }
    public Comprobante getComprobanteId() {
        return comprobanteId;
    }
    public void setComprobanteId(Comprobante comprobanteId) {
        this.comprobanteId = comprobanteId;
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
    public Producto getProductoId() {
        return productoId;
    }
    public void setProductoId(Producto productoId) {
        this.productoId = productoId;
    }
}
