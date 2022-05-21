package com.bottomline.excercise.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bottomline.excercise.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping("/getMatchingNames/{prefix}")
	public ResponseEntity<List<String>> getMatchingNames(@PathVariable String prefix) {
		List<String> names = personService.getAllNames();
		List<String> fileteredList = names.stream().filter(name -> name.toUpperCase().startsWith(prefix.toUpperCase()))
				.collect(Collectors.toList());
		return new ResponseEntity<List<String>>(fileteredList, HttpStatus.OK);

	}

}
