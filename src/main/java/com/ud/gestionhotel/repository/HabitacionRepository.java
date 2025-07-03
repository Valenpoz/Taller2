package com.ud.gestionhotel.repository;

import com.ud.gestionhotel.persistence.HabitacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitacionRepository extends JpaRepository<HabitacionEntity, Long> {
}
