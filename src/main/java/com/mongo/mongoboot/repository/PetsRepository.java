package com.mongo.mongoboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongo.mongoboot.model.Pets;

@Repository
public interface PetsRepository extends MongoRepository<Pets, String> {

}
