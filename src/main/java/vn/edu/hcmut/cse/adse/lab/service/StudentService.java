package vn.edu.hcmut.cse.adse.lab.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import vn.edu.hcmut.cse.adse.lab.entity.Student;
import vn.edu.hcmut.cse.adse.lab.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> getAll() {
        return repository.findAll();
    }

    public Student getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Student save(Student student) {
    return repository.save(student);
    }

    public void delete(String id) {
    repository.deleteById(id);
    }

    public List<Student> searchByName(String keyword) {
    return repository.findByNameContainingIgnoreCase(keyword);
    }
}