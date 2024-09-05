package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Student;
import com.example.demo.Service.StudentService;

import jakarta.validation.Valid;



@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	
	//get All students
    @GetMapping
    public String studentsList(Model model){
        model.addAttribute("students", studentService.findAll());
        return "list_student";
    }
    
    
    @GetMapping("/register")
    public String userRegistrationPage(Model model){
        model.addAttribute("student", new Student());
        return "form-student";
    }
    
    //add student
    @PostMapping
    public String submitForm(Model model,
    						@ Valid @ModelAttribute("students") Student student,
    						BindingResult result
                             ){

    	if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
            return "form-student"; // Return the form view with errors
        }
        studentService.save(student);
        model.addAttribute("students",studentService.findAll() );
        
        return  "redirect:/students";
    }
    
    
    //edit student 
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
   
    model.addAttribute("student", studentService.findById(id));
    return "form-student-edit";
    }    

    
    // update student
    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Student student) {
    student.setId(id); 
    studentService.update(student);
    return  "redirect:/students";
    }
    
    
    
    //delete student 
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
    studentService.delete(id);
    return "redirect:/students";
    }
    
    
    @GetMapping("/search")
    public String search(@RequestParam("full_name") String fullname, @RequestParam(value = "minScore", required = false) Double minScore,
    					@RequestParam(value = "maxScore", required = false) Double maxScore,
    					Model model) {
    List<Student> students = studentService.search(fullname, minScore, maxScore);
    model.addAttribute("students", students);
    return "list_student";
    }
   } 



