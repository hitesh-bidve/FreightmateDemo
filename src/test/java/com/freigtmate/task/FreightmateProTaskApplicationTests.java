package com.freigtmate.task;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.freigtmate.task.entity.Suburb;

@SpringBootTest
class FreightmateProTaskApplicationTests 
{
	/*
	 * Declared Base Url
	 */
	String baseUrl = "http://localhost:8080/freightApp/v1/";
	
	
	Logger logger = LoggerFactory.getLogger(FreightmateProTaskApplicationTests.class);
	
	
	
/*
 * This below checks wheather project context is loaded or not.
 */
	@Test
	void contextLoads() 
	{
	
	}
	
	/*
	 * This method checkes or test getSuburbname API with response code and compare with the same....
	 */
	@Test
	public void testGetSubUrbByPostcode() throws URISyntaxException
	{
		RestTemplate restTemplate = new RestTemplate();
		
		URI uri = new URI(baseUrl + "suburbs/394210");
		
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		
		
		Assertions.assertEquals(200, response.getStatusCodeValue());
		
		logger.info("testGetSubUrbByPostcode method with statuscode Value: "+response.getStatusCodeValue());
	}
	
	
	/*
	 * This method checkes or test getPostcode API with response code and compare with the same....
	 */
	@Test
	public void testGetPostcodeBySuburbName() throws URISyntaxException
	{
		RestTemplate restTemplate = new RestTemplate();
		
		
		URI uri = new URI(baseUrl+"postcode/Wagholi,Pune");
		
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		
		
		Assertions.assertEquals(200, response.getStatusCodeValue());
		
		logger.info("testGetSubUrbByPostcode method with statuscode value: "+response.getStatusCodeValue());
		
	}
	
	/*
	 * This method checkes or test addSuburb API with response code and compare with the same....
	 */
	@Test
//	@Disabled
	public void testAddSuburb() throws URISyntaxException
	{
		RestTemplate restTemplate = new RestTemplate();
		
		URI uri = new URI(baseUrl + "addSuburbs");
		
		Suburb suburb = new Suburb().builder().suburbName("Vesu Surat").postCode("394212").build();
		
		ResponseEntity<String> response = restTemplate.postForEntity(uri, suburb, String.class);
			
		Assertions.assertEquals(201, response.getStatusCodeValue());

		logger.info("testGetSubUrbByPostcode method with statuscode value: "+response.getStatusCodeValue());
	}
	

}
