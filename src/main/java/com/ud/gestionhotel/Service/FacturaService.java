package com.ud.gestionhotel.Service;

import com.ud.gestionhotel.exception.RecursoNoEncontradoException;
import com.ud.gestionhotel.persistence.FacturaEntity;
import com.ud.gestionhotel.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaService {

    private final FacturaRepository facturaRepository;

    @Autowired
    public FacturaService(FacturaRepository facturaRepository) {

        this.facturaRepository = facturaRepository;
    }

    public List<FacturaEntity> obtenerTodos(){
        return facturaRepository.findAll();
    }

    public Optional<FacturaEntity> obtenerPorId(Long id){
        return facturaRepository.findById(id);
    }

    public FacturaEntity crear(FacturaEntity factura){
        return facturaRepository.save(factura);
    }

    public FacturaEntity actualizar(Long id, FacturaEntity nuevafactura){
        return facturaRepository.findById(id).map(  factura ->{
            factura.setFechaEmision(nuevafactura.getFechaEmision());
            factura.setValorTotal(nuevafactura.getValorTotal());
            factura.setReservaEntity(nuevafactura.getReservaEntity());
            factura.setPagoEntity(nuevafactura.getPagoEntity());
            return facturaRepository.save(factura);
        }).orElseThrow(()-> new RecursoNoEncontradoException("Factura no encontrada con Id: " +id));
    }
     public void eliminar(Long id){
        if(!facturaRepository.existsById(id)){
            throw new RecursoNoEncontradoException("Factura no encontrada con Id: " +id);
        } facturaRepository.deleteById(id);
     }
}
