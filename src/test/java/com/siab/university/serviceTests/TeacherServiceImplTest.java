package com.siab.university.serviceTests;

import com.siab.university.model.Teacher;
import com.siab.university.repository.TeacherRepository;
import com.siab.university.service.TeacherService;
import com.siab.university.service.impl.TeacherServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TeacherServiceImplTest {
    @Mock
    private TeacherRepository teacherRepository;
    @InjectMocks
    private TeacherServiceImpl teacherService;

    @Test
    public void createTeacherSuccess() {
        Teacher teacher = getTestTeacher();
        when(teacherRepository.save(any(Teacher.class))).thenReturn(teacher);
        Teacher savedTeacher = teacherService.save(teacher);
        assertThat(savedTeacher.getName()).isNotNull();
    }

    @Test
    public void getTeacherSuccess() {
        Teacher teacher = getTestTeacher();
        when(teacherRepository.findById(anyLong())).thenReturn(Optional.of(teacher));
        Teacher savedTeacher = teacherService.findByPersonId(131L);
        assertThat(savedTeacher.getName()).isNotNull();
    }

    @Test
    public void updateTeacherSuccess(){
        Teacher teacher = getTestTeacher();
        when(teacherRepository.save(any(Teacher.class))).thenReturn(teacher);
        Teacher updatedStudent = teacherService.update(teacher,131L);
        verify(teacherRepository).save(teacher);
        verify(teacherRepository).deleteById(131L);
        assertThat(updatedStudent.getName()).isNotNull();
    }
    @Test
    public void deleteTeacherSuccess() {
        Teacher teacher = getTestTeacher();
        when(teacherRepository.deleteById(teacher.getId())).thenReturn(Optional.of(teacher));
        teacherService.deleteById(teacher.getId());
        verify(teacherRepository).deleteById(teacher.getId());
    }
    private Teacher getTestTeacher(){
        Teacher teacher = new Teacher();
        teacher.setName("Vasia");
        teacher.setId(131L);
        return teacher;
    }
}
