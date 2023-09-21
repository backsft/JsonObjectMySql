package com.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        // Perform any necessary business logic here before saving the student
        // For example, validation, data manipulation, etc.

        // Save the student entity with the JSON data
        return studentRepository.save(student);
    }
}
