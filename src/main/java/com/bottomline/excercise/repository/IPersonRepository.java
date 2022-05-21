package com.bottomline.excercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bottomline.excercise.entity.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer>{

}
