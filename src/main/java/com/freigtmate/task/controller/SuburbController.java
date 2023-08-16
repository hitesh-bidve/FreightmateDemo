package com.freigtmate.task.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freigtmate.task.entity.Suburb;
import com.freigtmate.task.service.SuburbServiceImpl;


/*
 *  @author hitesh.bidve
 *  @implnote RestController for get and post RESTAPI.
 */

@RestController
@RequestMapping("/freightApp/v1/")
public class SuburbController 
{
	private final SuburbServiceImpl suburbService;
	
	private static final Logger log = LogManager.getLogger(SuburbController.class);
	
	@Autowired
	public SuburbController(SuburbServiceImpl suburbService) 
	{
		this.suburbService = suburbService;
	}


	/*
	 * This RESTAPI is used for getting information about Suburb by providing Postcode.
	 */
	@GetMapping(value = "suburbs/{postCode}")
	public ResponseEntity<List<Suburb>> getSubUrbByPostcode(@PathVariable String postCode)
	{
		log.info("Request for Postcode  " +postCode);
		
		List<Suburb> suburbs = suburbService.getSubUrbByPostcode(postCode);
		
		log.info("Getting Postcode "+postCode);
		
		return ResponseEntity.ok(suburbs);
	}
	
	/*
	 * This RESTAPI is used for getting information about Postcode by providing SuburbName.
	 */
	@GetMapping(value = "postcode/{suburbName}")
	public ResponseEntity<String> getPostcodeBySuburbName(@PathVariable String suburbName)
	{
		log.info("Request for Suburb Name  " +suburbName);
		
		String postcode = suburbService.getPostcodeBySuburbName(suburbName);
		
		log.info("Getting Suburb Name  " +suburbName);
		
		return ResponseEntity.ok(postcode);
		
	}
	
	/*
	 * This RESTAPI is used for post data about Suburb with postcode.
	 */
	@PostMapping(value = "addSuburbs")
	public ResponseEntity<Suburb> addSuburb(@Valid @RequestBody Suburb suburb) throws Exception
	{
		Suburb addSuburb = suburbService.addSuburb(suburb);
		
		return new ResponseEntity<Suburb>(addSuburb, HttpStatus.CREATED);
		
	}
	
}
