package com.ud.gestionhotel.Service;

import com.ud.gestionhotel.persistence.ClienteEntity;
import com.ud.gestionhotel.repository.ClienteRepository;
import com.ud.gestionhotel.exception.RecursoNoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteEntity> obtenerTodos() {
        return clienteRepository.findAll();
    }

    public Optional<ClienteEntity> obtenerPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public ClienteEntity crear(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }

    public ClienteEntity actualizar(Long id, ClienteEntity clienteActualizado) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setPrimerNombre(clienteActualizado.getPrimerNombre());
            cliente.setSegundoNombre(clienteActualizado.getSegundoNombre());
            cliente.setPrimerApellido(clienteActualizado.getPrimerApellido());
            cliente.setSegundoApellido(clienteActualizado.getSegundoApellido());
            cliente.setCedula(clienteActualizado.getCedula());
            cliente.setDireccion(clienteActualizado.getDireccion());
            return clienteRepository.save(cliente);
        }).orElseThrow(() -> new RecursoNoEncontradoException("Cliente no encontrado con ID: " + id));
    }

    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }
}
