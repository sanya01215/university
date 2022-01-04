package com.siab.university.controller;

import com.siab.university.exception.EntityNotFoundException;
import com.siab.university.model.StudentGroup;
import com.siab.university.service.StudentGroupService;
import com.siab.university.service.impl.StudentGroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university/api/v1/group")
public class StudentGroupController {
    private final StudentGroupServiceImpl studentGroupService;

    @Autowired
    public StudentGroupController(StudentGroupServiceImpl studentGroupService) {
        this.studentGroupService = studentGroupService;
    }

    @PostMapping
    public StudentGroup createStudentGroup(StudentGroup studentGroup) {
        return studentGroupService.createStudentGroup(studentGroup);
    }

    @PostMapping(value = "{id}")
    public StudentGroup updateStudent(@PathVariable Long studentId, StudentGroup studentGroup) {
        return studentGroupService.updateStudentGroup(studentGroup,studentId);
    }

    @GetMapping
    public List<StudentGroup> getStudentGroups() {
        return studentGroupService.findAllStudentGroups();
    }

    @GetMapping(value = "{id}")
    public StudentGroup getStudentGroupById(@PathVariable Integer studentId) throws EntityNotFoundException {
        return studentGroupService.getStudentGroupById(studentId);
    }

    @DeleteMapping
    public void deleteStudentGroupById(Long id) {
        studentGroupService.deleteStudentGroupById(id);
    }

    @DeleteMapping("{id}")
    public void deleteStudentGroupById(@PathVariable Integer id) {
        studentGroupService.deleteStudentGroupById(id);
    }


}
