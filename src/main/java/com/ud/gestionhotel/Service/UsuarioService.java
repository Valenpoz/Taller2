package com.ud.gestionhotel.Service;

import com.ud.gestionhotel.exception.RecursoNoEncontradoException;
import com.ud.gestionhotel.persistence.UsuarioEntity;
import com.ud.gestionhotel.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioEntity> obtenerTodos(){
        return  usuarioRepository.findAll();
    }

    public Optional< UsuarioEntity> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public  UsuarioEntity crear( UsuarioEntity pago){
        return usuarioRepository.save(pago);
    }

    public  UsuarioEntity actualizar(Long id,  UsuarioEntity nuevoUsuario){
        return usuarioRepository.findById(id).map(  usuario ->{
            usuario.setNombreUsuario(nuevoUsuario.getNombreUsuario());
            usuario.setContrasena(nuevoUsuario.getContrasena());
            usuario.setRol(nuevoUsuario.getRol());
            usuario.setAdministradorEntity(nuevoUsuario.getAdministradorEntity());
            usuario.setEmpleadoEntity(nuevoUsuario.getEmpleadoEntity());
            usuario.setAdministradorGeneralEntity(nuevoUsuario.getAdministradorGeneralEntity());
            usuario.setClienteEntity(nuevoUsuario.getClienteEntity());
            return usuarioRepository.save(usuario);

        }).orElseThrow(()-> new RecursoNoEncontradoException("Pago no encontrada por Id: " +id));
    }
    public void eliminar(Long id){
        if(!usuarioRepository.existsById(id)){
            throw new RecursoNoEncontradoException("Pago no encontrado por Id: " +id);
        } usuarioRepository.deleteById(id);
    }
}
