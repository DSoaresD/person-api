package one.digitalInnovation.personapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalInnovation.personapi.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
