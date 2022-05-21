package com.bottomline.excercise;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.bottomline.excercise.service.PersonService;

@SpringBootApplication
public class AutocompleteApplication implements CommandLineRunner {

	@Autowired
	private PersonService personService;

	@Value("${filePath}")
	private String filePath;

	public static void main(String[] args) {
		SpringApplication.run(AutocompleteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(filePath);
		List<String> names = Files.readAllLines(Paths.get(filePath));
		personService.loadNamesToDB(names);

	}

}
