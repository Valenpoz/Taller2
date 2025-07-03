package com.ud.gestionhotel.Service;

import com.ud.gestionhotel.exception.RecursoNoEncontradoException;
import com.ud.gestionhotel.persistence.HabitacionEntity;
import com.ud.gestionhotel.repository.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitacionService {

    private final HabitacionRepository habitacionRepository;

    @Autowired
    public HabitacionService(HabitacionRepository habitacionRepository) {
        this.habitacionRepository = habitacionRepository;
    }

    public List<HabitacionEntity> obtenerTodas() {
        return habitacionRepository.findAll();
    }

    public Optional<HabitacionEntity> obtenerPorId(Long id) {
        return habitacionRepository.findById(id);
    }

    public HabitacionEntity crear(HabitacionEntity habitacion) {
        return habitacionRepository.save(habitacion);
    }

    public HabitacionEntity actualizar(Long id, HabitacionEntity nuevaHabitacion) {
        return habitacionRepository.findById(id).map(habitacion -> {
            habitacion.setNumeroHabitacion(nuevaHabitacion.getNumeroHabitacion());
            habitacion.setPrecioDia(nuevaHabitacion.getPrecioDia());
            habitacion.setDisponible(nuevaHabitacion.isDisponible());
            habitacion.setHotelEntity(nuevaHabitacion.getHotelEntity());
            habitacion.setTipoHabitacionEntity(nuevaHabitacion.getTipoHabitacionEntity());
            return habitacionRepository.save(habitacion);
        }).orElseThrow(() -> new RecursoNoEncontradoException("Habitación no encontrada con ID: " + id));
    }

    public void eliminar(Long id) {
        if (!habitacionRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("Habitación no encontrada con ID: " + id);
        }
        habitacionRepository.deleteById(id);
    }
}
