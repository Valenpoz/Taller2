package com.ud.gestionhotel.Service;

import com.ud.gestionhotel.persistence.HotelEntity;
import com.ud.gestionhotel.persistence.TipoHabitacionEntity;
import com.ud.gestionhotel.repository.HotelRepository;
import com.ud.gestionhotel.repository.TipoHabitacionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoHabitacionService {

    private final TipoHabitacionRepository tipoHabitacionRepository;
    private final HotelRepository hotelRepository;

    @Autowired
    public TipoHabitacionService(TipoHabitacionRepository tipoHabitacionRepository, HotelRepository hotelRepository) {
        this.tipoHabitacionRepository = tipoHabitacionRepository;
        this.hotelRepository = hotelRepository;
    }

    public TipoHabitacionEntity crear(TipoHabitacionEntity tipoHabitacion, Long idHotel) {
        HotelEntity hotel = hotelRepository.findById(idHotel)
                .orElseThrow(() -> new EntityNotFoundException("Hotel no encontrado con ID: " + idHotel));
        tipoHabitacion.setHotelEntity(hotel);
        return tipoHabitacionRepository.save(tipoHabitacion);
    }

    public List<TipoHabitacionEntity> obtenerTodos() {
        return tipoHabitacionRepository.findAll();
    }

    public TipoHabitacionEntity obtenerPorId(Long id) {
        return tipoHabitacionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tipo de habitación no encontrado con ID: " + id));
    }

    public TipoHabitacionEntity actualizar(Long id, TipoHabitacionEntity tipoHabitacionActualizado) {
        TipoHabitacionEntity existente = obtenerPorId(id);
        existente.setNombre(tipoHabitacionActualizado.getNombre());
        existente.setCantidad(tipoHabitacionActualizado.getCantidad());
        return tipoHabitacionRepository.save(existente);
    }

    public void eliminar(Long id) {
        tipoHabitacionRepository.deleteById(id);
    }
}
