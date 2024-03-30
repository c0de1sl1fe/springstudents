package ru.kors.springstudents.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kors.springstudents.model.Student;
import ru.kors.springstudents.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {

    private StudentService service;

    @GetMapping
    public List<Student> findAllStudent() {
        //todo
        return service.findAllStudent();
    }

    @PostMapping("save_student")
    public String saveStudent (@RequestBody Student student) {
        if (service.saveStudent(student) != null) {
            return "Student successfully saved!";
        }
        return "Saving student is failed";


    }

    @GetMapping("/{email}") // /api/v1/students/test1@emgail.com - example
    public Student findByEmail(@PathVariable("email") String email) {
        return service.findByEmail(email);
    }

    @PutMapping("update_student")
    public Student updateStudent(@RequestBody Student student) {
        return service.updateStudent(student);
    }

    @DeleteMapping("delete_student/{email}")
    public void deleteStudent(@PathVariable String email) {
        service.deleteStudent(email);
    }


}

