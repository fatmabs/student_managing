package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{ //<Student: the class which we are working with , Integer the type of the primary key>
	// Recherche par nom complet
	 @Query("SELECT s FROM Student s WHERE s.full_name LIKE %:full_name%")
	 List<Student> findByFullnameContaining(@Param("full_name")String fulln_ame);
	 
	 
	 // Recherche par intervalle de score
	 @Query("SELECT s FROM Student s WHERE s.score BETWEEN :minScore AND :maxScore")
	 List<Student> findByScoreBetween(@Param("minScore") Double minScore, @Param("maxScore") Double maxScore);
	 
	 
	 // Recherche par nom complet et intervalle de score
	 @Query("SELECT s FROM Student s WHERE s.full_name LIKE %:full_name% AND s.score BETWEEN :minScore AND :maxScore")
	 List<Student> search(@Param("full_name") String full_name, @Param("minScore") Double minScore,
	@Param("maxScore") Double maxScore);
	 
	 
	} 


