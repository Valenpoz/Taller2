package com.ud.gestionhotel.Service;

import com.ud.gestionhotel.exception.RecursoNoEncontradoException;
import com.ud.gestionhotel.persistence. AdministradorGeneralEntity;
import com.ud.gestionhotel.repository.AdministradorGeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorGeneralService {

    private final AdministradorGeneralRepository administradorGeneralRepository;

    @Autowired
    public AdministradorGeneralService(AdministradorGeneralRepository administradorGeneralRepository) {
        this.administradorGeneralRepository = administradorGeneralRepository;
    }


public List< AdministradorGeneralEntity> obtenerTodos(){
    return  administradorGeneralRepository.findAll();
}

public Optional< AdministradorGeneralEntity> obtenerPorId(Long id){
    return administradorGeneralRepository.findById(id);
}

public  AdministradorGeneralEntity crear( AdministradorGeneralEntity administradorGeneral){
    return administradorGeneralRepository.save(administradorGeneral);
}

public  AdministradorGeneralEntity actualizar(Long id,  AdministradorGeneralEntity nuevoadministadorGeneral){
    return administradorGeneralRepository.findById(id).map(  administadorGeneral ->{
        administadorGeneral.setCorreo(nuevoadministadorGeneral.getCorreo());
        administadorGeneral.setTelefono(nuevoadministadorGeneral.getTelefono());
        administadorGeneral.setPrimerApellido(nuevoadministadorGeneral.getPrimerApellido());
        administadorGeneral.setPrimerNombre(nuevoadministadorGeneral.getPrimerNombre());
        administadorGeneral.setSegundoApellido(nuevoadministadorGeneral.getSegundoApellido());
        administadorGeneral.setSegundoNombre(nuevoadministadorGeneral.getSegundoNombre());
        return administradorGeneralRepository.save(administadorGeneral);

    }).orElseThrow(()-> new RecursoNoEncontradoException("AdministadorGeneral no encontrada con Id: " +id));
}
public void eliminar(Long id){
    if(!administradorGeneralRepository.existsById(id)){
        throw new RecursoNoEncontradoException("AdministadorGeneral no encontrado con Id: " +id);
    } administradorGeneralRepository.deleteById(id);
}
}
