package com.siab.university.controller;

import com.siab.university.exception.EntityNotFoundException;
import com.siab.university.model.Group;
import com.siab.university.service.impl.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university/api/v1/group")
public class GroupController {
    private final GroupServiceImpl studentGroupService;

    @Autowired
    public GroupController(GroupServiceImpl groupService) {
        this.studentGroupService = groupService;
    }

    @PostMapping
    public Group createStudentGroup(Group group) {
        return studentGroupService.createStudentGroup(group);
    }

    @PostMapping(value = "{id}")
    public Group updateStudent(@PathVariable Long studentId, Group group) {
        return studentGroupService.updateStudentGroup(group,studentId);
    }

    @GetMapping("/all")
    public List<Group> getGroups() {
        return studentGroupService.findAllStudentGroups();
    }

    @GetMapping(value = "{id}")
    public Group getGroupById(@PathVariable Integer studentId) throws EntityNotFoundException {
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