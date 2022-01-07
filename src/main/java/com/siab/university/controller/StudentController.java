package com.siab.university.controller;

import com.siab.university.model.Student;
import com.siab.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(Student student) {
        return studentService.save(student);
    }

    @PostMapping("{id}")
    public Student updateStudent(Student person, @PathVariable Integer id) {
        return studentService.update(person, id);
    }

    @GetMapping("/all")
    public List<Student> getStudents() {
        return studentService.findAll();
    }

    @GetMapping(value = "{id}")
    public Student getStudentById(@PathVariable Integer studentId) throws Exception {
        return studentService.findByPersonId(studentId);
    }

    @DeleteMapping
    public void deleteStudent(Student person) {
        studentService.delete(person);
    }

    @DeleteMapping("{id}")
    public void deleteStudentById(@PathVariable Integer id) {
        studentService.deleteById(id);
    }

}