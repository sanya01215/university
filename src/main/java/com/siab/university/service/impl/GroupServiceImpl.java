package com.siab.university.service.impl;

import com.siab.university.exception.EntityNotFoundException;
import com.siab.university.model.Group;
import com.siab.university.repository.GroupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GroupServiceImpl {
    private final Logger LOGGER = LoggerFactory.getLogger(GroupServiceImpl.class);
    private final GroupRepository groupRepository;
@Autowired
    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }


    public Group createStudentGroup(Group group) {
        return groupRepository.save(group);
    }


    public Group updateStudentGroup(Group group, long groupId) {
        return groupRepository.save(group);
    }


    public List<Group> findAllStudentGroups() {
        return groupRepository.findAll();
    }


    public Group getStudentGroupById(long id) throws EntityNotFoundException{
        return groupRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Group.class.getName()));
    }


    public Group deleteStudentGroupById(long id) {
       return groupRepository.deleteById(id).orElseThrow(()-> new EntityNotFoundException(Group.class.getName()));
    }

}
