package com.mongo.mongoboot.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "pets")
@AllArgsConstructor
@ToString
public class Pets {

    @Id()
    private ObjectId _id;

    @Getter
    @Setter
    public String name;

    @Getter
    @Setter
    public String species;

    @Getter
    @Setter
    public String breed;

    public Pets() {
    }

    public String get_id() {
	return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
	this._id = _id;
    }

}
