package com.siab.university.serviceTests;

import com.siab.university.model.Student;
import com.siab.university.repository.StudentRepository;;
import com.siab.university.service.impl.StudentServiceImpl;
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
public class StudentServiceImplTest {
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentServiceImpl personService;

    @Test
    public void createStudentSuccess() {
        Student student = getTestStudent();
        when(studentRepository.save(any(Student.class))).thenReturn(student);
        Student savedStudent = personService.save(student);
        assertThat(savedStudent.getName()).isNotNull();
    }

    @Test
    public void getStudentSuccess() {
        Student student = getTestStudent();
        when(studentRepository.findById(anyLong())).thenReturn(Optional.of(student));
        Student findStudent = personService.findByPersonId(131L);
        assertThat(findStudent.getName()).isNotNull();
    }

    @Test
    public void updateStudentSuccess() {
        Student student = getTestStudent();
        when(studentRepository.save(any(Student.class))).thenReturn(student);
        when(studentRepository.deleteById(anyLong())).thenReturn(Optional.of(student));

        Student updatedStudent = personService.update(student, 131L);
        verify(studentRepository).save(student);
        verify(studentRepository).deleteById(131L);
        assertThat(updatedStudent.getName()).isNotNull();
    }

    @Test
    public void deleteStudentSuccess() {
        Student student = getTestStudent();
        when(studentRepository.deleteById(student.getId())).thenReturn(Optional.of(student));
        personService.deleteById(student.getId());
        verify(studentRepository).deleteById(student.getId());
    }

    private Student getTestStudent() {
        Student student = new Student();
        student.setName("Vasia");
        student.setId(131L);
        return student;
    }
}