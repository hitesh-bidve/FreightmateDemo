package com.freigtmate.task.advice;

public class ResourceNotFoundException extends RuntimeException 
{
	/*
	 * @author hitesh.bidve
	 * @implnote Custom class for handling custom exception handling. 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) 
	{
		super(message);
	}
	
}
