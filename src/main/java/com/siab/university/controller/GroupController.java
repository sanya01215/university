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
    private final GroupServiceImpl groupService;

    @Autowired
    public GroupController(GroupServiceImpl groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    public Group createGroup(Group group) {
        return groupService.createStudentGroup(group);
    }

    @PostMapping(value = "{id}")
    public Group updateStudentInGroup(@PathVariable Long studentId, Group group) {
        return groupService.updateStudentGroup(group, studentId);
    }

    @GetMapping
    public List<Group> getGroups() {
        return groupService.findAllStudentGroups();
    }

    @GetMapping(value = "{id}")
    public Group getGroupById(@PathVariable Integer studentId) throws EntityNotFoundException {
        return groupService.getStudentGroupById(studentId);
    }

    @DeleteMapping
    public void deleteGroupById(Long id) {
        groupService.deleteStudentGroupById(id);
    }

    @DeleteMapping("{id}")
    public void deleteGroupById(@PathVariable Integer id) {
        groupService.deleteStudentGroupById(id);
    }


}
