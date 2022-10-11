package com.testeHotel.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.testeHotel.entity.Hospede;
import com.testeHotel.repository.HospedeRepository;

public class HospedeController {
	
	@Autowired
    private HospedeRepository hospedeRepository;

    @RequestMapping(value = "/hospede", method = RequestMethod.GET)
    public List<Hospede> get() {
        return hospedeRepository.findAll();
    }

    @RequestMapping(value = "/hospede/{id}", method = RequestMethod.GET)
    public ResponseEntity<Hospede> getById(@PathVariable(value = "id") long id){
        Optional<Hospede> hospede = hospedeRepository.findById(id);
        if(hospede.isPresent())
            return new ResponseEntity<Hospede>(hospede.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/hospede", method =  RequestMethod.POST)
    public Hospede post(@Valid @RequestBody Hospede hospede){
        return hospedeRepository.save(hospede);
    }

    @RequestMapping(value = "/hospede/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Hospede> put(@PathVariable(value = "id") long id, @Valid @RequestBody Hospede newHospede){
        Optional<Hospede> oldHospede = hospedeRepository.findById(id);
        if(oldHospede.isPresent()){
        	Hospede hospede = oldHospede.get();
        	hospede.setNome(newHospede.getNome());
        	hospede.setDocumento(newHospede.getDocumento());
            hospede.setTelefone(newHospede.getTelefone());
            hospedeRepository.save(hospede);
            return new ResponseEntity<Hospede>(hospede, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/hospede/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable(value = "id") long id){
        Optional<Hospede> hospede = hospedeRepository.findById(id);
        if(hospede.isPresent()){
        	hospedeRepository.delete(hospede.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
