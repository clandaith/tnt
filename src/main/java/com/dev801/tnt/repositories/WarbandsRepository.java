package com.dev801.tnt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.dev801.tnt.data.Warband;

public interface WarbandsRepository extends CrudRepository<Warband, Integer> {
	@Query("select w from Warband w where w.userId = :user_id")
	public List<Warband> findWarbandsByUserId(@Param("user_id") Integer userId);

}
