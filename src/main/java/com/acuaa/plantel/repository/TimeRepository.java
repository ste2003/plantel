package com.acuaa.plantel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acuaa.plantel.models.Time;
import com.acuaa.plantel.models.User;
import com.acuaa.plantel.payload.request.TimeRequest;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {
	

}
