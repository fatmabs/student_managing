package com.example.demo.Model;


import java.util.HashSet;
import java.util.List;
import java.util.Set;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="STUDENT")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
//	@NotEmpty(message = "Cin is required")
//    @Size(min = 8, max = 8, message = "Cin must be between 1 and 20 characters")
    private String cin;
	
	
//    @NotEmpty(message = "Name is required")
//    @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
    private String full_name;
    
    
//    @Min(value = 0, message = "Value must be at least 0")
//    @Max(value = 20, message = "Value must be at most 20")
    private double score;
    
    
    @OneToMany(mappedBy = "student")
    List<Car> Cars; 
    
	@ManyToMany 
	@JoinTable(name="student_club", joinColumns= @JoinColumn(name="student_id"),inverseJoinColumns = @JoinColumn(name = "club_id"))
	private Set<Club> clubs= new HashSet<>();

    
    
    
	public List<Car> getCars() {
		return Cars;
	}
	public void setCars(List<Car> cars) {
		Cars = cars;
	}
	
	
	public Student(Long id, String cin, String full_name, double score) {
        this.id = id;
		this.cin = cin;
		this.full_name = full_name;
		this.score = score;
	}
	public Student(){}
	
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long nextId) {
		this.id =  nextId;
	}

}
