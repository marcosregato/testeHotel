package com.testeHotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.testeHotel.entity.CheckIn;
import com.testeHotel.entity.Hospede;

@Repository
public interface CheckInRepository extends JpaRepository<CheckIn, Long> { 

	public ResponseEntity<CheckIn> getById(long id);
	
	public Hospede post(CheckIn hospede);

	public ResponseEntity<CheckIn> put(CheckIn newCheckIn);

	public ResponseEntity<Object> delete(long id);

}