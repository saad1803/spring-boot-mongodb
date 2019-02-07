package com.mongo.mongoboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongo.mongoboot.model.Pets;
import com.mongo.mongoboot.repository.PetsRepository;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@CrossOrigin
public class MongoController {

    @Autowired
    private PetsRepository petsRepository;

    @RequestMapping(value = "/getAllPets", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getAllPets() throws Exception {

	List<Pets> allPets = petsRepository.findAll();
	allPets.stream().forEach(p -> log.debug(p.toString()));

	Map<String, Object> returnMap = new HashMap<String, Object>();
	returnMap.put("data", allPets);

	return new ResponseEntity<Map<String, Object>>(returnMap, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/addPets", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> addPets(@RequestBody Pets pets) {
	if (log.isDebugEnabled())
	    log.debug(pets.toString());
	pets.set_id(ObjectId.get());
	petsRepository.save(pets);

	Map<String, Object> returnMap = new HashMap<String, Object>();
	returnMap.put("status", true);

	return new ResponseEntity<Map<String, Object>>(returnMap, HttpStatus.ACCEPTED);
    }
}
