package com.testeHotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Optional;

import javax.validation.Valid;

import com.testeHotel.entity.CheckIn;
import com.testeHotel.repository.CheckInRepository;

public class CheckInController {
	
	@Autowired
    private CheckInRepository checkInRepository;

    @RequestMapping(value = "/checkIn", method = RequestMethod.GET)
    public List<CheckIn> get() {
        return checkInRepository.findAll();
    }

    @RequestMapping(value = "/checkIn/{id}", method = RequestMethod.GET)
    public ResponseEntity<CheckIn> getById(@PathVariable(value = "id") long id){
        Optional<CheckIn> checkIn = checkInRepository.findById(id);
        if(checkIn.isPresent())
            return new ResponseEntity<CheckIn>(checkIn.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/checkIn", method =  RequestMethod.POST)
    public CheckIn post(@Valid @RequestBody CheckIn checkIn){
        return checkInRepository.save(checkIn);
    }

    @RequestMapping(value = "/checkIn/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<CheckIn> put(@PathVariable(value = "id") long id, @Valid @RequestBody CheckIn newCheckIn){
        Optional<CheckIn> oldCheckIn = checkInRepository.findById(id);
        if(oldCheckIn.isPresent()){
            CheckIn checkIn = oldCheckIn.get();
            checkIn.setDataEntrada(newCheckIn.getDataEntrada());
            checkIn.setDataSaida(newCheckIn.getDataSaida());
            checkIn.setAdicionarVeiculo(newCheckIn.isAdicionarVeiculo());
            checkInRepository.save(checkIn);
            return new ResponseEntity<CheckIn>(checkIn, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/checkIn/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable(value = "id") long id){
        Optional<CheckIn> checkIn = checkInRepository.findById(id);
        if(checkIn.isPresent()){
        	checkInRepository.delete(checkIn.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
