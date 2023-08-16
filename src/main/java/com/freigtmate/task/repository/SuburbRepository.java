package com.freigtmate.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freigtmate.task.entity.Suburb;

/*
 *  @author hitesh.bidve
 *  @implnote provides additional functionality beyond basic CRUD operations
 */

public interface SuburbRepository extends JpaRepository<Suburb, Long> 
{
	
	/*
	 * For finding Suburb by Postcode.
	 */
	List<Suburb> findByPostCode(String postCode);
	
	/*
	 * For finding Postcode by SuburbName.
	 */
	Suburb findBySuburbName(String suburbName);
	
}
