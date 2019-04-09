package com.cristianroot.projections.controllers;

import com.cristianroot.projections.entities.Person;
import com.cristianroot.projections.projections.Projection;
import com.cristianroot.projections.services.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

	private final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping("/people")
	public List<Projection<Person>> findAll(@RequestHeader List<String> projectionRequest) {
		return personService.findAll(projectionRequest);
	}

}
