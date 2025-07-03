package com.ud.gestionhotel.persistence;
import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "tipo_habitacion")
public class TipoHabitacionEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_habitacion")
    private long id;
    private String nombre;
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "fk_id_hotel")
    private HotelEntity hotelEntity;

    public TipoHabitacionEntity() {
    }

    public TipoHabitacionEntity(long id, String nombre, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public void setHotelEntity(HotelEntity hotelEntity) {
        this.hotelEntity = hotelEntity;
    }
}
