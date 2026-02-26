package vn.edu.hcmut.cse.adse.lab.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import vn.edu.hcmut.cse.adse.lab.entity.Student;
import vn.edu.hcmut.cse.adse.lab.service.StudentService;

@RestController //Trả về JSON trực tiếp, Không trả về trang HTML
@RequestMapping("/api/students") //Tất cả API bên trong sẽ bắt đầu bằng:/api/students
public class StudentController {

    @Autowired
    private StudentService service;

    // GET http://localhost:8081/api/students
    @GetMapping("/")
    public String home() {
        return "Student Management API is running";
    }
    
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAll();
    }

    // GET http://localhost:8081/api/students/{id}
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        return service.getById(id);
    }
}