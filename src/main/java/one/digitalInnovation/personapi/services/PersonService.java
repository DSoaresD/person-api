package one.digitalInnovation.personapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalInnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalInnovation.personapi.entities.Person;
import one.digitalInnovation.personapi.repositories.PersonRepository;

@Service
public class PersonService {

	private PersonRepository personRepository;
	
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
		
	public MessageResponseDTO createPerson(Person person) {
		Person savedPerson = personRepository.save(person);
		return MessageResponseDTO
				.builder()
				.message("Created person with id: " + savedPerson.getId())
				.build();
	}
}
