package com.siab.university.service.impl;

import com.siab.university.exception.EntityNotFoundException;
import com.siab.university.model.StudentGroup;
import com.siab.university.repository.GroupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentGroupServiceImpl{
    private final Logger LOGGER = LoggerFactory.getLogger(StudentGroupServiceImpl.class);
    private final GroupRepository groupRepository;
@Autowired
    public StudentGroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }


    public StudentGroup createStudentGroup(StudentGroup studentGroup) {
        return groupRepository.save(studentGroup);
    }


    public StudentGroup updateStudentGroup(StudentGroup studentGroup, long groupId) {
        return groupRepository.save(studentGroup);
    }


    public List<StudentGroup> findAllStudentGroups() {
        return groupRepository.findAll();
    }


    public StudentGroup getStudentGroupById(long id) throws EntityNotFoundException{
        return groupRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(StudentGroup.class.getName()));
    }


    public void deleteStudentGroupById(long id) {
        groupRepository.deleteById(id);
    }

}
