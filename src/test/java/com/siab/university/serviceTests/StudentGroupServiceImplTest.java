package com.siab.university.serviceTests;


import com.siab.university.model.StudentGroup;
import com.siab.university.repository.GroupRepository;
import com.siab.university.service.StudentGroupService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentGroupServiceImplTest {
    @MockBean
    private GroupRepository groupRepository;
    @Autowired
    private StudentGroupService groupService;

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
        when(groupRepository.findById(anyLong())).thenReturn(Optional.of(studentGroup));
        StudentGroup savedStudentGroup = groupService.getStudentGroupById(131L);
        assertThat(savedStudentGroup.getName()).isNotNull();
    }

    @Test
    public void updateStudentSuccess(){
        StudentGroup studentGroup = getTestGroup();
        when(groupRepository.save(any(StudentGroup.class))).thenReturn(studentGroup);
        StudentGroup updatedStudent = groupService.updateStudentGroup(studentGroup,131L);
        verify(groupRepository).save(studentGroup);
        verify(groupRepository).deleteById(131L);
        assertThat(updatedStudent.getName()).isNotNull();


    }
    @Test
    public void deleteStudentSuccess() {
        StudentGroup studentGroup = getTestGroup();
        when(groupRepository.findById(studentGroup.getId())).thenReturn(Optional.of(studentGroup));
        groupService.deleteStudentGroupById(studentGroup.getId());
        verify(groupRepository).deleteById(studentGroup.getId());
    }
    private StudentGroup getTestGroup(){
        StudentGroup studentGroup = new StudentGroup();
        studentGroup.setName("BEM-15");
        studentGroup.setId(131L);
        return studentGroup;
    }
}
