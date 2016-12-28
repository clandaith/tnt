package com.dev801.tnt.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dev801.tnt.data.Injury;

public interface InjuriesRepository extends CrudRepository<Injury, Integer> {

}
