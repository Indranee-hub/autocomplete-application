package com.bottomline.excercise.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bottomline.excercise.entity.Person;
import com.bottomline.excercise.repository.IPersonRepository;

@Service
public class PersonService {
	@Autowired
	private IPersonRepository personRepo;

	public void loadNamesToDB(List<String> names) {
		List<Person> pList = new ArrayList<>();
		for (String name : names) {
			Person person = new Person();
			person.setName(name);
			pList.add(person);
			//personRepo.save(person);
		}
		personRepo.saveAll(pList);

	}

	public List<String> getAllNames() {
		List<String> names = new ArrayList<>();
		List<Person> pList = personRepo.findAll();
		for (Person p : pList) {
			names.add(p.getName());
		}
		return names;
	}

}
