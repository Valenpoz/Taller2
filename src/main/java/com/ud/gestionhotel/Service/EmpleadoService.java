package com.ud.gestionhotel.Service;

import com.ud.gestionhotel.exception.RecursoNoEncontradoException;
import com.ud.gestionhotel.persistence.EmpleadoEntity;
import com.ud.gestionhotel.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<EmpleadoEntity> obtenerTodos(){
        return  empleadoRepository.findAll();
    }

    public Optional< EmpleadoEntity> obtenerPorId(Long id){
        return empleadoRepository.findById(id);
    }

    public  EmpleadoEntity crear( EmpleadoEntity administrador){
        return empleadoRepository.save(administrador);
    }

    public  EmpleadoEntity actualizar(Long id,  EmpleadoEntity nuevoempleado){
        return empleadoRepository.findById(id).map(  empleado ->{
            empleado.setCorreo(nuevoempleado.getCorreo());
            empleado.setPrimerApellido(nuevoempleado.getPrimerApellido());
            empleado.setSegundoApellido(nuevoempleado.getSegundoApellido());
            empleado.setPrimerNombre(nuevoempleado.getPrimerNombre());
            empleado.setSegundoNombre(nuevoempleado.getSegundoNombre());
            empleado.setTelefono(nuevoempleado.getTelefono());
            return empleadoRepository.save(empleado);

        }).orElseThrow(()-> new RecursoNoEncontradoException("Empleado no encontrada con Id: " +id));
    }

    public void eliminar(Long id){

        if(!empleadoRepository.existsById(id)){
            throw new RecursoNoEncontradoException("Empleado no encontrado con Id: " +id);
        } empleadoRepository.deleteById(id);
    }
}
