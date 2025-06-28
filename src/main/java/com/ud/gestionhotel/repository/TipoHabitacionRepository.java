package com.ud.gestionhotel.repository;

import com.ud.gestionhotel.persistence.TipoHabitacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacionEntity, Long> {
}
