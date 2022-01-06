package com.siab.university.serviceTests;

import com.siab.university.model.Group;
import com.siab.university.repository.GroupRepository;
import com.siab.university.service.impl.GroupServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GroupServiceImplTest {
    @Mock
    private GroupRepository groupRepository;
    @InjectMocks
    private GroupServiceImpl groupService;

    @Test
    public void createGroupSuccess() {
        Group group = getTestGroup();
        when(groupRepository.save(any(Group.class))).thenReturn(group);
        Group savedGroup = groupService.createStudentGroup(group);
        assertThat(savedGroup.getName()).isNotNull();
    }

    @Test
    public void getStudentInGroupSuccess() {
        Group group = getTestGroup();
        when(groupRepository.findById(131L)).thenReturn(Optional.of(group));
        Group gotGroup = groupService.getStudentGroupById(131L);
        assertThat(gotGroup.getName()).isNotNull();
    }

    @Test
    public void updateStudentInGroupSuccess() {
        Group group = getTestGroup();
        when(groupRepository.save(any(Group.class))).thenReturn(group);
        Group updatedStudent = groupService.updateStudentGroup(group, 131L);
        verify(groupRepository).save(group);
        assertThat(updatedStudent.getName()).isNotNull();
    }

    @Test
    public void deleteStudentInGroupSuccess() {
        Group group = getTestGroup();
        when(groupRepository.deleteById(group.getId())).thenReturn(Optional.of(group));
        groupService.deleteStudentGroupById(group.getId());
        verify(groupRepository).deleteById(group.getId());
    }

    private Group getTestGroup() {
        Group group = new Group();
        group.setName("BEM-15");
        group.setId(131L);
        return group;
    }
}
