package com.ud.gestionhotel.persistence;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "factura")
public class FacturaEntity implements Serializable {

    @Id
    @Column(name = "id_factura")
    private long id;

    @Column(name = "fecha_emision")
    private LocalDateTime fechaEmision;

    @Column(name = "valor_total")
    private long valorTotal;

    @ManyToOne
    @JoinColumn(name = "jk_id_reserva")
    private ReservaEntity reservaEntity;

    @OneToOne
    @JoinColumn(name = "fk_id_pago")
    private PagoEntity pagoEntity;

    public FacturaEntity() {
    }

    public FacturaEntity(long id, long valorTotal, LocalDateTime fechaEmision) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.fechaEmision = fechaEmision;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public long getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(long valorTotal) {
        this.valorTotal = valorTotal;
    }

    public ReservaEntity getReservaEntity(){ return reservaEntity;};

    public void setReservaEntity(ReservaEntity reservaEntity) { this.reservaEntity = reservaEntity;}

    public PagoEntity getPagoEntity() { return pagoEntity;}
    public void setPagoEntity(PagoEntity pagoEntity) { this.pagoEntity = pagoEntity;}
}