package com.siab.university.service;

import com.siab.university.model.*;

import java.util.List;

public interface StudentGroupService  {
//groups
    StudentGroup createStudentGroup (StudentGroup studentGroup);

    StudentGroup updateStudentGroup (StudentGroup studentGroup, Long groupId);

    List<StudentGroup> findAllStudentGroups();

    StudentGroup getStudentGroupById(long id);

    void deleteStudentGroupById(long id);
}
