package com.cristianroot.projections.repositories;

import com.cristianroot.projections.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
