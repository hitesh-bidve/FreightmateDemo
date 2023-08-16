package com.freigtmate.task.service;

import java.util.List;

import com.freigtmate.task.entity.Suburb;

/*
 * @author hitesh.bidve
 * @implnote Creating Service interface for abstraction purpose or reusability of methods.
 */
public interface SuburbService 
{
	List<Suburb> getSubUrbByPostcode(String postCode);
	
	String getPostcodeBySuburbName(String suburbName);
	
	Suburb addSuburb(Suburb suburb) throws Exception;
}
