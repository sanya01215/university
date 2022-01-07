package com.siab.university.controller;

import com.siab.university.model.Teacher;
import com.siab.university.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public Teacher createTeacher(Teacher teacher) {
        return teacherService.save(teacher);
    }

    @GetMapping("/all")
    public List<Teacher> getTeachers() {
        return teacherService.findAll();
    }

    @GetMapping(value = "{id}")
    public Teacher getTeacherById(@PathVariable Integer teacherId) throws Exception {
        return teacherService.findByPersonId(teacherId);
    }

    @DeleteMapping
    public void deleteTeacher(Teacher teacher) {
        teacherService.delete(teacher);
    }

    @DeleteMapping("{id}")
    public void deleteTeacherById(@PathVariable Integer id) {
        teacherService.deleteById(id);
    }

}