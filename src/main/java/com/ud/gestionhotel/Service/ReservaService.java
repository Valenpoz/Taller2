package com.ud.gestionhotel.Service;

import com.ud.gestionhotel.exception.RecursoNoEncontradoException;
import com.ud.gestionhotel.persistence.ReservaEntity;
import com.ud.gestionhotel.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<ReservaEntity> obtenerTodas() {
        return reservaRepository.findAll();
    }

    public Optional<ReservaEntity> obtenerPorId(Long id) {
        return reservaRepository.findById(id);
    }

    public ReservaEntity crear(ReservaEntity reserva) {
        return reservaRepository.save(reserva);
    }

    public ReservaEntity actualizar(Long id, ReservaEntity nuevaReserva) {
        return reservaRepository.findById(id).map(reserva -> {
            reserva.setFechaInicio(nuevaReserva.getFechaInicio());
            reserva.setFechaFinal(nuevaReserva.getFechaFinal());
            reserva.setCantidadDias(nuevaReserva.getCantidadDias());
            reserva.setEstado(nuevaReserva.isEstado());
            reserva.setFechaReserva(nuevaReserva.getFechaReserva());
            reserva.setHabitacionEntity(nuevaReserva.getHabitacionEntity());
            reserva.setClienteEntity(nuevaReserva.getClienteEntity());
            return reservaRepository.save(reserva);
        }).orElseThrow(() -> new RecursoNoEncontradoException("Reserva no encontrada con ID: " + id));
    }

    public void eliminar(Long id) {
        if (!reservaRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("Reserva no encontrada con ID: " + id);
        }
        reservaRepository.deleteById(id);
    }
}
