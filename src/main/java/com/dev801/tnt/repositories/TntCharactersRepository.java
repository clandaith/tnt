package com.dev801.tnt.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dev801.tnt.data.TntCharacter;

public interface TntCharactersRepository extends CrudRepository<TntCharacter, Integer> {

}
