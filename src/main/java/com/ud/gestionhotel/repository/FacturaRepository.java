package com.ud.gestionhotel.repository;

import com.ud.gestionhotel.persistence.FacturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FacturaRepository extends JpaRepository<FacturaEntity, Long> {

}
