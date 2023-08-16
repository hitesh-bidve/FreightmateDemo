package com.freigtmate.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freigtmate.task.advice.ResourceNotFoundException;
import com.freigtmate.task.entity.Suburb;
import com.freigtmate.task.repository.SuburbRepository;

/*
 * @author hitesh.bidve
 * @implnote Implement SuburbService interface here with specific implementation of 
 *           business logic put in it.
 */
@Service
public class SuburbServiceImpl implements SuburbService
{
	
	private final SuburbRepository suburbRepository;

	@Autowired
	public SuburbServiceImpl(SuburbRepository suburbRepository) 
	{
		this.suburbRepository = suburbRepository;
	}

	/*
	 * Implementation of Get details of Suburb by Postcode.
	 */
	public List<Suburb> getSubUrbByPostcode(String postCode)
	{
		List<Suburb> listOfPostCodeDetails = suburbRepository.findByPostCode(postCode);
		
		if(listOfPostCodeDetails.isEmpty())
		{
			throw new ResourceNotFoundException("You searched for is not available..."); 
		}
		else
		{
			return listOfPostCodeDetails;
		}

	}
	
	/*
	 * Implementation of Get details of Postcode by Suburbname.
	 */
	public String getPostcodeBySuburbName(String suburbName)
	{
		Suburb suburb = suburbRepository.findBySuburbName(suburbName);
		
		if(suburb != null)
		{
			return suburb.getPostCode();
		}
		else
		{
			throw new ResourceNotFoundException("You searched for is not available..."); 
		}
		
	}

	/*
	 * Implementation of Post details of Suburb with name and postcode.
	 */
	public Suburb addSuburb(Suburb suburb) throws Exception
	{
		
		List<Suburb> listOfSuburb = suburbRepository.findAll();
		
		if(!listOfSuburb.contains(suburb))
		{
			return suburbRepository.save(suburb);
		}
		else
		{
			throw new Exception("Internal Server Esception Occurs.");
		}
		
	}
}

