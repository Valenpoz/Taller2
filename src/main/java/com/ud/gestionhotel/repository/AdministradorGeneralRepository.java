package com.ud.gestionhotel.repository;

import com.ud.gestionhotel.persistence.AdministradorGeneralEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorGeneralRepository extends JpaRepository<AdministradorGeneralEntity, Long> {
}
