package com.ud.gestionhotel.Service;

import com.ud.gestionhotel.exception.RecursoNoEncontradoException;
import com.ud.gestionhotel.persistence.PagoEntity;
import com.ud.gestionhotel.persistence.PagoEntity;
import com.ud.gestionhotel.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {

    private final PagoRepository pagoRepository;

    @Autowired
    public PagoService(PagoRepository pagoRepository) {

        this.pagoRepository = pagoRepository;
    }

    public List<PagoEntity> obtenerTodos(){
        return  pagoRepository.findAll();
    }

    public Optional< PagoEntity> obtenerPorId(Long id){
        return pagoRepository.findById(id);
    }

    public  PagoEntity crear( PagoEntity pago){
        return pagoRepository.save(pago);
    }

    public  PagoEntity actualizar(Long id,  PagoEntity nuevopago){
        return pagoRepository.findById(id).map(  pago ->{
            pago.setFecha(nuevopago.getFecha());
            pago.setPagoTotal(nuevopago.getPagoTotal());
            pago.setMetodoPago(nuevopago.getMetodoPago());
            pago.setReservaEntity(nuevopago.getReservaEntity());
            return pagoRepository.save(pago);

        }).orElseThrow(()-> new RecursoNoEncontradoException("Pago no encontrada por Id: " +id));
    }
    public void eliminar(Long id){
        if(!pagoRepository.existsById(id)){
            throw new RecursoNoEncontradoException("Pago no encontrado por Id: " +id);
        } pagoRepository.deleteById(id);
    }
}
