package com.ud.gestionhotel.persistence;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "habitacion")
public class HabitacionEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private Long id;

    @Column(name = "numero_habitacion")
    private Long numeroHabitacion;

    @Column(name = "precio_dia")
    private Long precioDia;

    private boolean disponible;

    @ManyToOne
    @JoinColumn(name = "fk_id_hotel")
    private HotelEntity hotelEntity;

    @ManyToOne
    @JoinColumn(name = "fk_id_tipo_habitacion")
    private TipoHabitacionEntity tipoHabitacionEntity;

    public HabitacionEntity() {
    }

    public HabitacionEntity(Long id, Long numeroHabitacion, Long precioDia, boolean disponible) {
        this.id = id;
        this.numeroHabitacion = numeroHabitacion;
        this.precioDia = precioDia;
        this.disponible = disponible;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(Long precioDia) {
        this.precioDia = precioDia;
    }

    public Long getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(Long numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public HotelEntity getHotelEntity() {
        return hotelEntity;
    }

    public void setHotelEntity(HotelEntity hotelEntity) {
        this.hotelEntity = hotelEntity;
    }
    public TipoHabitacionEntity getTipoHabitacionEntity() {
        return tipoHabitacionEntity;
    }

    public void setTipoHabitacionEntity(TipoHabitacionEntity tipoHabitacionEntity) {
        this.tipoHabitacionEntity = tipoHabitacionEntity;
    }

}