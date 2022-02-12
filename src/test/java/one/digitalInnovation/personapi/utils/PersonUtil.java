package one.digitalInnovation.personapi.utils;

import java.time.LocalDate;
import java.util.Collections;

import one.digitalInnovation.personapi.dto.resquests.PersonDTO;
import one.digitalInnovation.personapi.entities.Person;

public class PersonUtil {
	
	private static final String FIRST_NAME = "Daniel";
	private static final String LAST_NAME = "Soares";
	private static final String CPF_NUMBER = "198.494.394-98";
	private static final Long PERSON_ID = 1L;
	public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);
	
	public static PersonDTO createFakeDTO() {
		return PersonDTO.builder()
				.firstName(FIRST_NAME)
				.lastName(LAST_NAME)
				.cpf(CPF_NUMBER)
				.birthDate("08-02-1988").phones(Collections.singletonList(PhoneUtil.createFakeDTO())).build();
	}
	
	public static Person createFakeEntity() {
		return Person.builder()
				.id(PERSON_ID)
				.firstName(FIRST_NAME)
				.lastName(LAST_NAME)
				.cpf(CPF_NUMBER)
				.birthDate(BIRTH_DATE).phones(Collections.singletonList(PhoneUtil.createFakeEntity())).build();
	}

}
