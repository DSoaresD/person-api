package one.digitalInnovation.personapi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalInnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalInnovation.personapi.dto.resquests.PersonDTO;
import one.digitalInnovation.personapi.entities.Person;
import one.digitalInnovation.personapi.exceptions.PersonNotFoundException;
import one.digitalInnovation.personapi.mapper.PersonMapper;
import one.digitalInnovation.personapi.repositories.PersonRepository;

@Service
public class PersonService {

	private PersonRepository personRepository;
	
	private final PersonMapper personMapper = PersonMapper.INSTANCE;
	
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	
	
	public MessageResponseDTO createPerson(PersonDTO personDTO) {
		
		Person personToSave = personMapper.toModel(personDTO);
				
						
		Person savedPerson = personRepository.save(personToSave);
		return MessageResponseDTO
				.builder()
				.message("Created person with id: " + savedPerson.getId())
				.build();
	}



	public List<PersonDTO> listAll() {
		List<Person> allPeople = personRepository.findAll();
		return allPeople.stream().map(personMapper::toDTO).collect(Collectors.toList());
		
	}



	public PersonDTO findById(Long id) throws PersonNotFoundException {
		Person person = verifyIfExists(id);
		return personMapper.toDTO(person);
	}
	
	public void delete(Long id) throws PersonNotFoundException {
		verifyIfExists(id);
		
		personRepository.deleteById(id);
	}
	
	public Person verifyIfExists(Long id) throws PersonNotFoundException {
		return personRepository.findById(id)
				.orElseThrow(()->new PersonNotFoundException(id));
	}
	
}
