package com.siab.university.serviceTests;

import com.siab.university.model.StudentGroup;
import com.siab.university.repository.GroupRepository;
import com.siab.university.service.impl.StudentGroupServiceImpl;
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
public class StudentGroupServiceImplTest {
    @Mock
    private GroupRepository groupRepository;
    @InjectMocks
    private StudentGroupServiceImpl groupService;

    @Test
    public void createStudentGroupSuccess() {
        StudentGroup studentGroup = getTestGroup();
        when(groupRepository.save(any(StudentGroup.class))).thenReturn(studentGroup);
        StudentGroup savedGroup = groupService.createStudentGroup(studentGroup);
        assertThat(savedGroup.getName()).isNotNull();
    }

    @Test
    public void getStudentSuccess() {
        StudentGroup studentGroup = getTestGroup();
        when(groupRepository.findById(131L)).thenReturn(Optional.of(studentGroup));
        StudentGroup gotStudentGroup = groupService.getStudentGroupById(131L);
        assertThat(gotStudentGroup.getName()).isNotNull();
    }

    @Test
    public void updateStudentSuccess() {
        StudentGroup studentGroup = getTestGroup();
        when(groupRepository.save(any(StudentGroup.class))).thenReturn(studentGroup);
        StudentGroup updatedStudent = groupService.updateStudentGroup(studentGroup, 131L);
        verify(groupRepository).save(studentGroup);
        assertThat(updatedStudent.getName()).isNotNull();
    }

    @Test
    public void deleteStudentSuccess() {
        StudentGroup studentGroup = getTestGroup();
        when(groupRepository.deleteById(studentGroup.getId())).thenReturn(Optional.of(studentGroup));
        groupService.deleteStudentGroupById(studentGroup.getId());
        verify(groupRepository).deleteById(studentGroup.getId());
    }

    private StudentGroup getTestGroup() {
        StudentGroup studentGroup = new StudentGroup();
        studentGroup.setName("BEM-15");
        studentGroup.setId(131L);
        return studentGroup;
    }
}
