package com.example.controller;

import com.example.dto.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/student")
@Controller
public class StudentController {
    private List<Student> studentList = new LinkedList<>();

    public StudentController() {
        studentList.add(new Student(UUID.randomUUID().toString(), "Ali", "Aliyev"));
        studentList.add(new Student(UUID.randomUUID().toString(), "Vali", "Valiyev"));
        studentList.add(new Student(UUID.randomUUID().toString(), "Toshmat", "Toshmatov"));
        studentList.add(new Student(UUID.randomUUID().toString(), "Eshmat", "Eshmatov"));
    }

    @RequestMapping("/one")
    public String home(Model model) {
        Student student = new Student();
        student.setId(UUID.randomUUID().toString());
        student.setName("Ali");
        student.setSurname("Aliyev");
        model.addAttribute("student", student);
        return "student";
    }

    @RequestMapping({"", "/list"})
    public String getAll(Model model) {
        model.addAttribute("studentList", studentList);
        return "student";
    }

    @GetMapping("/go/add")
    public String goToAdd(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("edit", false);
        return "student-add";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student, Model model) {
        student.setId(UUID.randomUUID().toString());
        studentList.add(student);
        return "redirect:/student";
    }

    @GetMapping("/go/edit/{id}")
    public String addStudent(@PathVariable("id") String id, Model model) {
        Student student = studentList.stream().filter(s -> s.getId().equals(id)).findAny().orElse(null);
        if (student == null) {
            return "redirect:/student";
        }
        model.addAttribute("student", student);
        model.addAttribute("edit", true);
        return "student-add";
    }

    @PostMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") String id,
                              @ModelAttribute Student student, Model model) {
        Student afterStudent = studentList.stream().filter(s -> s.getId().equals(id)).findAny().orElse(null);
        studentList.remove(afterStudent);
        studentList.add(student);
        return "redirect:/student";
    }
    @GetMapping("/go/delete/{id}")
    public String deleteStudent(@PathVariable("id") String id, Model model) {
        Student student = studentList.stream().filter(s -> s.getId().equals(id)).findAny().orElse(null);
        studentList.remove(student);
        return "redirect:/student";

    }
}
