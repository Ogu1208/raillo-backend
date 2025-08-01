package com.sudo.railo.train.infrastructure;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sudo.railo.train.domain.TrainSchedule;

public interface TrainScheduleRepository extends JpaRepository<TrainSchedule, Long> {

	@Query("SELECT MAX(ts.operationDate) FROM TrainSchedule ts")
	Optional<LocalDate> findLastOperationDate();

	boolean existsByOperationDate(LocalDate operationDate);
}
