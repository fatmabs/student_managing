package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Car;

@Service
public class CarService implements ICarService {

	@Override
	public List<Car> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Car student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Car student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Car> findByFullname(String model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> search(String matricule) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
