package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService implements IStudentService {
	
	@Autowired
	private StudentRepository studentRepository;	
	
	 private Long nextId = 1L; 

	//get
	 @Override
	 public List<Student> findAll() {
		 return studentRepository.findAll();
	 }
	 
	 //getbyId
	 @Override
	 public Student findById(Long id) {
		return studentRepository.findById(id).orElse(new Student());
	 } 
	 
	 //post
	 @Override
	 public void save(Student student) {
		 if (student.getId() == null) {
		 student.setId(nextId++);
		 }
		 studentRepository.save(student);
	} 

	 //put
	 @Override
	 public void update(Student student) {
			 studentRepository.save(student);
		 
	} 
	 
	 //Delete by id
	 @Override
	 public void delete(Long id) {
		 studentRepository.deleteById(id);
	} 
	
	 @Override
	 public List<Student> findByFullname(String fullname) {
	 return studentRepository.findByFullnameContaining(fullname);
	 }
	 
	 @Override
	 public List<Student> findByScoreBetween(Double minScore, Double maxScore) {
	 return studentRepository.findByScoreBetween(minScore, maxScore);
	 }
	 
	 @Override
	 public List<Student> search(String fullname, Double minScore, Double maxScore) {
	 return studentRepository.search(fullname, minScore, maxScore);
	 }


	
	
}
