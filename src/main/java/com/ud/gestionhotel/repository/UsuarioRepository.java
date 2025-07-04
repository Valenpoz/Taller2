package com.ud.gestionhotel.repository;

import com.ud.gestionhotel.persistence.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    Optional<UsuarioEntity> findByNombreUsuario(String nombreUsuario);

}
