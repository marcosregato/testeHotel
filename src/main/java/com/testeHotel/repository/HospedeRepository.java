package com.testeHotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.testeHotel.entity.Hospede;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Long> {

	public ResponseEntity<Hospede> getById(long id);
	
	public Hospede post(Hospede hospede);

	public ResponseEntity<Hospede> put(Hospede newHospede);

	public ResponseEntity<Object> delete(long id);



}


