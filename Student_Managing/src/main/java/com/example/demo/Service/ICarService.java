package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Car;

public interface ICarService {
    public List<Car> findAll();
    
    public Car findById(Long id);
    
    public void save(Car student);
    
    public void update(Car student);
    
    public void delete(Long id);
    
    public List<Car> findByFullname(String model);
    
    
    public List<Car> search(String matricule);
}
