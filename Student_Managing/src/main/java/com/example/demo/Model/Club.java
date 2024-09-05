package com.example.demo.Model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="CLUB")

public class Club {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long club_id;
	
	
	private String name_club;
	
	@ManyToMany(mappedBy = "clubs")
    private Set<Student> students = new HashSet<>();
	
	
	

	public Long getId() {
		return club_id;
	}

	public void setId(Long id) {
		this.club_id = id;
	}

	public String getName_club() {
		return name_club;
	}

	public void setName_club(String name_club) {
		this.name_club = name_club;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	
	
	
	

	

}
