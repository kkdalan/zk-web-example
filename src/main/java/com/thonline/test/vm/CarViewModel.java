package com.thonline.test.vm;

import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

import com.thonline.test.model.Car;
import com.thonline.test.service.CarService;
import com.thonline.test.service.impl.CarServiceImpl;

public class CarViewModel {

	private String keyword;
	private List<Car> carList;
	private int count;
	private Car selectedCar;

	private CarService carService = new CarServiceImpl();

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getKeyword() {
		return keyword;
	}

	public List<Car> getCarList() {
		return carList;
	}

	public int getCount() {
		return count;
	}

	public void setSelectedCar(Car selectedCar) {
		this.selectedCar = selectedCar;
	}

	public Car getSelectedCar() {
		return selectedCar;
	}

	@Command
	@NotifyChange({ "carList", "count" })
	public void search() {
		carList = carService.search(keyword);
		count = carList.size();
	}
}
