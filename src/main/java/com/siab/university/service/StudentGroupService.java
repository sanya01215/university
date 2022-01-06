package com.siab.university.service;

import com.siab.university.model.*;

import java.util.List;

public interface StudentGroupService  {
//groups
    Group createStudentGroup (Group group);

    Group updateStudentGroup (Group group, Long groupId);

    List<Group> findAllStudentGroups();

    Group getStudentGroupById(long id);

    void deleteStudentGroupById(long id);
}
