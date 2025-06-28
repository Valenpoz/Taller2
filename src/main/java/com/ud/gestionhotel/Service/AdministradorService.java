package com.ud.gestionhotel.Service;

import com.ud.gestionhotel.exception.RecursoNoEncontradoException;
import com.ud.gestionhotel.persistence.AdministradorEntity;
import com.ud.gestionhotel.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorService {

    private final AdministradorRepository administradorRepository;

    @Autowired
    public AdministradorService(AdministradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }

    public List<AdministradorEntity> obtenerTodos(){
        return  administradorRepository.findAll();
    }

    public Optional< AdministradorEntity> obtenerPorId(Long id){
        return administradorRepository.findById(id);
    }

    public  AdministradorEntity crear( AdministradorEntity administrador){
        return administradorRepository.save(administrador);
    }

    public  AdministradorEntity actualizar(Long id,  AdministradorEntity nuevoadministador){
        return administradorRepository.findById(id).map(  administrador ->{
            administrador.setCorreo(nuevoadministador.getCorreo());
            administrador.setTelefono(nuevoadministador.getTelefono());
            administrador.setPrimerApellido(nuevoadministador.getPrimerApellido());
            administrador.setPrimerNombre(nuevoadministador.getPrimerNombre());
            administrador.setSegundoApellido(nuevoadministador.getSegundoApellido());
            administrador.setSegundoNombre(nuevoadministador.getSegundoNombre());
            return administradorRepository.save(administrador);

        }).orElseThrow(()-> new RecursoNoEncontradoException("Administador no encontrada con Id: " +id));
    }
    public void eliminar(Long id){
        if(!administradorRepository.existsById(id)){
            throw new RecursoNoEncontradoException("Administador no encontrado con Id: " +id);
        } administradorRepository.deleteById(id);
    }

}
