package com.ud.gestionhotel.persistence;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "pago")
public class PagoEntity implements Serializable {

    public Object getReservaEntity;
    @Id
    @Column(name = "id_pago")
    private long id;

    private LocalDateTime fecha;

    @Column(name = "metodo_pago")
    private String metodoPago;

    @Column(name = "pago_total")
    private long pagoTotal;

    @ManyToOne
    @JoinColumn(name = "fk_id_reserva")
    private ReservaEntity reservaEntity;

    public PagoEntity() {
    }

    public PagoEntity(long id, LocalDateTime fecha, String metodoPago, long pagoTotal) {
        this.id = id;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
        this.pagoTotal = pagoTotal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public long getPagoTotal() {
        return pagoTotal;
    }

    public void setPagoTotal(long pagoTotal) {
        this.pagoTotal = pagoTotal;
    }

    public ReservaEntity getReservaEntity() {
        return reservaEntity;
    }

    public void setReservaEntity(ReservaEntity reservaEntity) {
        this.reservaEntity = reservaEntity;
    }
}