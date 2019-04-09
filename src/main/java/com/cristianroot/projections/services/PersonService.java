package com.cristianroot.projections.services;

import com.cristianroot.projections.entities.Person;
import com.cristianroot.projections.projections.Projection;
import com.cristianroot.projections.projections.Projector;
import com.cristianroot.projections.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

	private final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public List<Projection<Person>> findAll(List<String> projectionRequest) {
		return personRepository.findAll()
							   .stream()
							   .map(person -> Projector.project(person, projectionRequest))
							   .collect(Collectors.toList());
	}

}
