package com.thonline.test.service;

import java.util.List;

import com.thonline.test.model.Car;

public interface CarService {

	/**
	 * Retrieve all cars in the catalog.
	 * @return all cars
	 */
	public List<Car> findAll();
	
	/**
	 * search cars according to keyword in name and company.
	 * @param keyword for search
	 * @return list of car that match the keyword
	 */
	public List<Car> search(String keyword);
}
