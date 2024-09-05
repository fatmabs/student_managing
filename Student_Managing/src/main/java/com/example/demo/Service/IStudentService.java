package com.example.demo.Service;
import java.util.*;

import com.example.demo.Model.Student;


public interface IStudentService {
    

    public List<Student> findAll();
    
    public Student findById(Long id);
    
    public void save(Student student);
    
    public void update(Student student);
    
    public void delete(Long id);
    
    public List<Student> findByFullname(String fullname);
    
    public List<Student> findByScoreBetween(Double minScore, Double maxScore);
    
    public List<Student> search(String fullname, Double minScore, Double maxScore);
    
}
