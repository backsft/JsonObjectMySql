package com.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

   
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.createStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }
    
  
    
    @PostMapping("/insert")
    public ResponseEntity<Student> createStudent22(@RequestParam("userData") String userData) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Student student = objectMapper.readValue(userData, Student.class);
            Student savedStudent = studentService.createStudent(student);
            return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
        } catch (JsonProcessingException e) {
            // Handle JSON parsing error
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    
    
}