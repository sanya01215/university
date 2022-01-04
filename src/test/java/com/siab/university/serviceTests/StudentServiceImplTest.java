package com.siab.university.serviceTests;

import com.siab.university.model.Student;
import com.siab.university.repository.StudentRepository;
import com.siab.university.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceImplTest {
    @MockBean
    private StudentRepository studentRepository;
    @Autowired
    private StudentService personService;

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
        when(studentRepository.save(any(Student.class))).thenReturn(student);
        Student savedStudent = personService.findByPersonId(131L);
        assertThat(savedStudent.getName()).isNotNull();
    }

    @Test
    public void updateStudentSuccess(){
        Student student = getTestStudent();
        when(studentRepository.save(any(Student.class))).thenReturn(student);
        Student updatedStudent = personService.update(student,131L);
        verify(studentRepository).save(student);
        verify(studentRepository).deleteById(131L);
        assertThat(updatedStudent.getName()).isNotNull();
    }
    @Test
    public void deleteStudentSuccess() {
        Student student = getTestStudent();
        when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));
        personService.deleteById(student.getId());
        verify(studentRepository).deleteById(student.getId());
    }
    private Student getTestStudent(){
        Student student = new Student();
        student.setName("Vasia");
        student.setId(131L);
        return student;
    }
}