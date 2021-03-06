package com.example.shell.repo;

import java.util.List;

import com.example.shell.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private PersonRepository repository;

	@Test
	public void testFindAll() {
		Person person = entityManager.persist(Person.builder()
													.firstName("first")
													.surname("last")
													.build());
		List<Person> personList = repository.findAll();
		assertThat(personList).extracting(Person::getFirstName).containsOnly(person.getFirstName());
		assertThat(personList).extracting(Person::getSurname).containsOnly(person.getSurname());
	}

	@Test
	public void test() {
		assertThat("c:/test/".equals("c:\\test\\".replace("\\","/")));
		System.out.println("c:\\test\\".replace("\\","/"));
	}
}