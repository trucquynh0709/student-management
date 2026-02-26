package vn.edu.hcmut.cse.adse.lab.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // Luu y: su dung @Controller, KHONG dung → @RestController
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.edu.hcmut.cse.adse.lab.service.StudentService;
import vn.edu.hcmut.cse.adse.lab.entity.Student;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentWebController {
@Autowired
private StudentService service;
// Route: GET http://localhost:8080/students
@GetMapping
public String getAllStudents(
        @RequestParam(required = false) String keyword,
        Model model) {

    List<Student> students;

    if (keyword != null && !keyword.isEmpty()) {
        students = service.searchByName(keyword);
    } else {
        students = service.getAll();
    }

    model.addAttribute("dsSinhVien", students);
    model.addAttribute("keyword", keyword); // để giữ lại text khi search
    return "students";
}

@GetMapping("/{id}")
public String detail(@PathVariable String id, Model model) {
    Student student = service.getById(id);
    model.addAttribute("student", student);
    return "student-detail";
}

@GetMapping("/new")
public String createForm(Model model) {
    model.addAttribute("student", new Student());
    return "student-form";
}

@PostMapping
public String save(@ModelAttribute Student student) {
    service.save(student);
    return "redirect:/students";
}

@GetMapping("/edit/{id}")
public String editForm(@PathVariable String id, Model model) {
    model.addAttribute("student", service.getById(id));
    return "student-form";
}

@PostMapping("/delete/{id}")
public String delete(@PathVariable String id) {
    service.delete(id);
    return "redirect:/students";
}

}
