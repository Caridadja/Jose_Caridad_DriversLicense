package com.caridadja.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.caridadja.relationships.models.Person;
import com.caridadja.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private PersonRepository personRepository;
	private PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	public void addPerson(Person person) {
		personRepository.save(person);
	}
	public List<Person> getAllPersons(){
		return personRepository.findAll();
	}
	public void deletePerson(Long id) {
		personRepository.deleteById(id);
	}
	public Person getPersonById(Long id) {
		Optional<Person> findPerson = personRepository.findById(id);
		if(findPerson.isPresent()) {
			return findPerson.get();
		}
		else {
			return null;
		}
	}
}
