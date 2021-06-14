package com.springboot.BeverageAPI.controller;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.BeverageAPI.APIError.ApirequestException;
import com.springboot.BeverageAPI.entities.Beverage;
import com.springboot.BeverageAPI.repository.BeverageRepository; 

@RestController
public class BeverageRestController {
	@Autowired
	BeverageRepository repository;
	
	@RequestMapping(value="api/beverages",method=RequestMethod.GET)
	public List<Beverage>getBeverages()
	{
		return repository.findAll();
	}
	
	@RequestMapping(value="api/beverages/{id}",method=RequestMethod.GET)
	public Beverage getBeverage(@PathVariable("id")int id) 
	{
		try {
			return repository.findById(id).get();
		}
		catch (Exception e){
			throw new ApirequestException("The id doesn't exist in the system");
		}
	}
	
	@RequestMapping(value="api/beverages",method=RequestMethod.POST)
	public Beverage createBeverage(Beverage beverage)
	{
		try {
			return repository.save(beverage);
		}
		catch (Exception e) {
			throw new ApirequestException("Something went wrong");
		}
	}
		
	
	@RequestMapping(value="api/beverages/{id}",method=RequestMethod.DELETE)
	public void deleteBeverage(@PathVariable("id")int id)
	{
		try {
			repository.deleteById(id);
		}
		catch (Exception e) {
			throw new ApirequestException("The id doesn't exist in the system and cannot be deleted");
		}
	}
}
