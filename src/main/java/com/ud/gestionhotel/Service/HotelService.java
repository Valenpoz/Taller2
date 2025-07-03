package com.ud.gestionhotel.Service;

import com.ud.gestionhotel.persistence.HotelEntity;
import com.ud.gestionhotel.repository.HotelRepository;
import com.ud.gestionhotel.exception.RecursoNoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<HotelEntity> obtenerTodos() {
        return hotelRepository.findAll();
    }

    public Optional<HotelEntity> obtenerPorId(Long id) {
        return hotelRepository.findById(id);
    }

    public HotelEntity crear(HotelEntity hotel) {
        return hotelRepository.save(hotel);
    }

    public HotelEntity actualizar(Long id, HotelEntity hotelActualizado) {
        return hotelRepository.findById(id).map(hotel -> {
            hotel.setNombre(hotelActualizado.getNombre());
            hotel.setCiudad(hotelActualizado.getCiudad());
            hotel.setTelefono(hotelActualizado.getTelefono());
            hotel.setCorreo(hotelActualizado.getCorreo());
            hotel.setDireccion(hotelActualizado.getDireccion());
            return hotelRepository.save(hotel);
        }).orElseThrow(() -> new RecursoNoEncontradoException("Hotel no encontrado con ID: " + id));
    }

    public void eliminar(Long id) {
        if (!hotelRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("Hotel no encontrado con ID: " + id);
        }
        hotelRepository.deleteById(id);
    }
}
