package one.digitalInnovation.personapi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import one.digitalInnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalInnovation.personapi.dto.resquests.PersonDTO;
import one.digitalInnovation.personapi.entities.Person;
import one.digitalInnovation.personapi.repositories.PersonRepository;
import one.digitalInnovation.personapi.services.PersonService;
import one.digitalInnovation.personapi.utils.PersonUtil;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

	@Mock
	private PersonRepository personRepository;
	
	@InjectMocks
	private PersonService personService;
	
	
	void testGivenPersonDtothenReturnSavedMessage() {
		PersonDTO personDTO = PersonUtil.createFakeDTO();
		Person expectedPersonSaved = PersonUtil.createFakeEntity();
		
		Mockito.when(personRepository.save(Mockito.any(Person.class))).thenReturn(expectedPersonSaved);
		
		MessageResponseDTO expectedMessage = MessageResponseDTO.builder()
				.message("Created person with id: "+expectedPersonSaved.getId()).build();
		
		MessageResponseDTO successMessage = personService.createPerson(personDTO);
		
		Assertions.assertEquals(expectedMessage, successMessage);
	}
}
